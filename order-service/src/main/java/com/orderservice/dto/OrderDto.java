package com.orderservice.dto;

import com.orderservice.model.OrderItem;
import com.orderservice.model.OrderStatus;
import jakarta.persistence.*;

import java.util.List;

public class OrderDto {

    private Long id;
    private Long userId;
    private OrderStatus orderStatus;
    private Double totalAmount;
    private Long paymentId;
    private List<OrderItemDto> orderItems;

    public OrderDto() {
    }

    public OrderDto(Long id, Long userId, OrderStatus orderStatus, Double totalAmount, Long paymentId, List<OrderItemDto> orderItems) {
        this.id = id;
        this.userId = userId;
        this.orderStatus = orderStatus;
        this.totalAmount = totalAmount;
        this.paymentId = paymentId;
        this.orderItems = orderItems;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }

    public Double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public Long getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(Long paymentId) {
        this.paymentId = paymentId;
    }

    public List<OrderItemDto> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<OrderItemDto> orderItems) {
        this.orderItems = orderItems;
    }
}
