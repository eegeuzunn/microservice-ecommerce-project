package com.orderservice.controller;

import com.orderservice.dto.OrderDto;
import com.orderservice.dto.OrderPostDto;
import com.orderservice.service.OrderService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping("/customers/{customerId}")
    public ResponseEntity<List<OrderDto>> getOrdersByCustomerId(@PathVariable Long customerId) {
        List<OrderDto> orders = orderService.getOrdersByCustomerId(customerId);
        return ResponseEntity.ok(orders);
    }

    @PostMapping
    public String createOrder(@RequestBody OrderPostDto orderPostDto) {
        return orderService.createOrder(orderPostDto);
    }

    @PatchMapping("/{orderId}")
    public String updateStatus(@PathVariable Long orderId, @RequestBody String status) {
        orderService.updateStatus(orderId, status);
        return "Order status updated successfully";
    }

}
