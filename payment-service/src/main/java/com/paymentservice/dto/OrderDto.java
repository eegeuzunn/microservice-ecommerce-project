package com.paymentservice.dto;


import java.util.List;

public class OrderDto {

    private Long id;
    private Long userId;
    private OrderStatus orderStatus;
    private Double totalAmount;
    private List<OrderItemDto> orderItems;

    public OrderDto() {
    }

    public OrderDto(Long id, Long userId, OrderStatus orderStatus, Double totalAmount, List<OrderItemDto> orderItems) {
        this.id = id;
        this.userId = userId;
        this.orderStatus = orderStatus;
        this.totalAmount = totalAmount;
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

    public List<OrderItemDto> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<OrderItemDto> orderItems) {
        this.orderItems = orderItems;
    }
}
