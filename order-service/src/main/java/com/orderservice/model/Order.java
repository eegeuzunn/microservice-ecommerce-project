package com.orderservice.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "customer_id")
    private Long customerId;
    @Enumerated(EnumType.STRING)
    @Column(name = "order_status")
    private OrderStatus orderStatus;
    @Column(name = "total_amount")
    private Double totalAmount;

    @OneToMany(mappedBy = "order")
    private List<OrderItem> orderItems;

    public Order() {
    }

    public Order(Long customerId, OrderStatus orderStatus, Double totalAmount) {
        this.customerId = customerId;
        this.orderStatus = orderStatus;
        this.totalAmount = totalAmount;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return customerId;
    }

    public void setUserId(Long customerId) {
        this.customerId = customerId;
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

    public List<OrderItem> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }
}
