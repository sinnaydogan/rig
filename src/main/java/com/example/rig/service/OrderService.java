package com.example.rig.service;

import com.example.rig.dto.OrderDto;
import com.example.rig.exception.OutOfStockException;
import com.example.rig.response.OrderResponse;

import java.util.List;

public interface OrderService {
    OrderResponse save(OrderDto orderDto) throws OutOfStockException;

    List<OrderResponse> getAllByCustomerId(Long customerId);

    OrderResponse getById(Long orderId);
}
