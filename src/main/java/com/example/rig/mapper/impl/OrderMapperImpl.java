package com.example.rig.mapper.impl;

import com.example.rig.entity.Order;
import com.example.rig.mapper.OrderMapper;
import com.example.rig.response.OrderResponse;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderMapperImpl implements OrderMapper {
    @Override
    public OrderResponse entityToResponse(Order order) {
        if (order == null){
            return null;
        }
        OrderResponse orderResponse = new OrderResponse();
        orderResponse.setId(order.getId());
        orderResponse.setOrderDate(order.getOrderDate());
        orderResponse.setBookIds(getOrderBookList(order));
        orderResponse.setTotalPrice(order.getTotalPrice());
        orderResponse.setCustomerId(order.getCustomer().getId());
        return orderResponse;
    }

    private List<Long> getOrderBookList(Order order) {
        List<Long> bookIds = new ArrayList<>();
        order.getBookList().forEach(book -> bookIds.add(book.getId()));
        return bookIds;
    }
}
