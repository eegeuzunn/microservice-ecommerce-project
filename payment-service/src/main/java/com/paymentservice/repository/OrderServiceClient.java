package com.paymentservice.repository;

import com.paymentservice.dto.OrderDto;
import com.paymentservice.dto.OrderPostDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "order-service", path = "/orders")
public interface OrderServiceClient {

    @GetMapping("/customers/{customerId}")
    public ResponseEntity<List<OrderDto>> getOrdersByCustomerId(@PathVariable Long customerId);

    @PostMapping
    public String createOrder(@RequestBody OrderPostDto orderPostDto);

    @PatchMapping("/{orderId}")
    public String updateStatus(@PathVariable Long orderId, @RequestBody String status);
}
