package com.example.rig.mapper;

import com.example.rig.entity.Order;
import com.example.rig.response.OrderResponse;

public interface OrderMapper {

    OrderResponse entityToResponse(Order order);
}
