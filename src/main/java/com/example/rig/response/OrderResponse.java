package com.example.rig.response;

import com.example.rig.dto.OrderDto;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Getter
@Setter
public class OrderResponse{
    private Long id;
    private BigDecimal totalPrice;
    private List<Long> bookIds;
    private Long customerId;

    private Date orderDate;

}
