package com.example.rig.service.impl;

import com.example.rig.dto.OrderDto;
import com.example.rig.entity.Book;
import com.example.rig.entity.Customer;
import com.example.rig.entity.Order;
import com.example.rig.exception.OutOfStockException;
import com.example.rig.mapper.OrderMapper;
import com.example.rig.repository.BookRepository;
import com.example.rig.repository.CustomerRepository;
import com.example.rig.repository.OrderRepository;
import com.example.rig.response.OrderResponse;
import com.example.rig.service.OrderService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

@Service
@Transactional
public class OrderServiceImpl implements OrderService {

    private final CustomerRepository customerRepository;
    private final BookRepository bookRepository;
    private final OrderRepository orderRepository;
    private final OrderMapper orderMapper;

    public OrderServiceImpl(CustomerRepository customerRepository, BookRepository bookRepository, OrderRepository orderRepository, OrderMapper orderMapper) {
        this.customerRepository = customerRepository;
        this.bookRepository = bookRepository;
        this.orderRepository = orderRepository;
        this.orderMapper = orderMapper;
    }

    @Override
    public OrderResponse save(OrderDto orderDto){
        Customer customer = customerRepository.getById(orderDto.getCustomerId());
        List<Book> bookList = new ArrayList<>();

        orderDto.getBookIds().forEach(id -> bookList.add(bookRepository.getById(id)));

        Order order = new Order();
        order.setOrderDate(new Date());
        order.setTotalPrice(orderDto.getTotalPrice());
        order.setCustomer(customer);
        order.setBookList(bookList);

         List<Long> outOfStockBooks = checkBookStock(bookList);
        if (outOfStockBooks.isEmpty()){
            Order createdOrder = orderRepository.save(order);
            updateBookStock(bookList);
            return orderMapper.entityToResponse(createdOrder);
        } else {
            throw new OutOfStockException("Books with these ids are out of stock : " + outOfStockBooks);
        }
    }

    private List<Long> checkBookStock(List<Book> bookList) {
        List<Long> outOfStockBooks = new ArrayList<>();
        bookList.forEach(book -> {
            if (book.getStock() ==0){
                outOfStockBooks.add(book.getId());
            }
        });

        return outOfStockBooks;
    }

    private void updateBookStock(List<Book> bookList) {
        bookList.forEach(book -> {
            Long newBookStock = book.getStock();
            book.setStock(newBookStock -1);
            bookRepository.save(book);
        });
    }

    @Override
    public List<OrderResponse> getAllByCustomerId(Long customerId) {
        Customer customer = customerRepository.getById(customerId);
        List<Order> orderList = orderRepository.findAllByCustomer(customer);
        List<OrderResponse> orderResponseList = new ArrayList<>();

        orderList.forEach(order -> {
            orderResponseList.add(orderMapper.entityToResponse(order));
        });

        return orderResponseList;
    }

    @Override
    public OrderResponse getById(Long orderId) {
        return orderMapper.entityToResponse(orderRepository.getById(orderId));
    }


}
