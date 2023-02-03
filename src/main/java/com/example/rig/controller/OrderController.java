package com.example.rig.controller;


import com.example.rig.dto.OrderDto;
import com.example.rig.exception.OutOfStockException;
import com.example.rig.response.OrderResponse;
import com.example.rig.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order")
@RequiredArgsConstructor
public class OrderController {
    private final OrderService orderService;

    @PostMapping
    public ResponseEntity<OrderResponse> save(@RequestBody OrderDto orderDto){
        return ResponseEntity.ok(orderService.save(orderDto));
    }

    @GetMapping("/getByCustomerId/{customerId}")
    public ResponseEntity<List<OrderResponse>> getAllByCustomerId(@PathVariable Long customerId) {
        return ResponseEntity.ok(orderService.getAllByCustomerId(customerId));
    }

    @GetMapping("/getById/{orderId}")
    public ResponseEntity<OrderResponse> getById(@PathVariable Long orderId) {
        return ResponseEntity.ok(orderService.getById(orderId));
    }
}
