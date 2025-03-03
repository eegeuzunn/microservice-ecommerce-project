package com.orderservice.model;

import jakarta.persistence.*;

@Entity
public class OrderItem {

    @Id
    private Long id;
    @Column(name = "product_id")
    private Long productId;
    private Long quantity;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;

    public OrderItem() {
    }

    public OrderItem(Long id, Long productId, Long quantity, Order order) {
        this.id = id;
        this.productId = productId;
        this.quantity = quantity;
        this.order = order;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }


}
