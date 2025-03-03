package com.orderservice.service;

import com.orderservice.dto.OrderDto;
import com.orderservice.dto.OrderPostDto;
import com.orderservice.dto.converter.OrderConverter;
import com.orderservice.dto.converter.OrderItemConverter;
import com.orderservice.model.Order;
import com.orderservice.model.OrderStatus;
import com.orderservice.repository.OrderItemRepository;
import com.orderservice.repository.OrderRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderService {

    private final OrderRepository orderRepository;
    private final OrderItemRepository orderItemRepository;
    private final OrderItemConverter orderItemConverter;
    private final OrderConverter orderConverter;

    public OrderService(OrderRepository orderRepository, OrderItemRepository orderItemRepository, OrderItemConverter orderItemConverter, OrderConverter orderConverter) {
        this.orderRepository = orderRepository;
        this.orderItemRepository = orderItemRepository;
        this.orderItemConverter = orderItemConverter;
        this.orderConverter = orderConverter;
    }

    public List<OrderDto> getOrdersByCustomerId(Long customerId) {
        List<Order> orders = orderRepository.findAllByCustomerId(customerId);
        if (orders.isEmpty()) {
            throw new EntityNotFoundException("No orders found for customer with id: " + customerId);
        }

        return orders.stream()
                .map(orderConverter::toOrderDto)
                .collect(Collectors.toList());
    }

    public String createOrder(OrderPostDto orderPostDto) {
        Order order = new Order();
        order.setOrderStatus(orderPostDto.getOrderStatus());
        order.setUserId(orderPostDto.getUserId());
        order.setTotalAmount(orderPostDto.getTotalAmount());
        order.setOrderItems(orderPostDto.getOrderItems() == null ? List.of() :
                        orderPostDto.getOrderItems()
                            .stream()
                            .map(orderItemConverter::toOrderItem)
                            .collect(Collectors.toList()));
        return orderRepository.save(order).getId().toString();
    }

    public void updateStatus(Long orderId, String status) {
        Order order = orderRepository.findById(orderId)
                .orElseThrow(() -> new EntityNotFoundException("Order not found with id: " + orderId));
        order.setOrderStatus(OrderStatus.valueOf(status.toUpperCase()));
        orderRepository.save(order);
    }
}
