package com.cartservice.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Cart {

    @Id
    @Column(name = "cart_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "customer_id")
    private Long customerId;
    @Column(name = "total_amount")
    private double totalAmount;

    private boolean isOnPayment;

    @OneToMany(mappedBy = "cart")
    private List<CartItem> cartItems;

    public Cart() {
    }

    public Cart(Long id, Long customerId, double totalAmount, boolean isOnPayment, List<CartItem> cartItems) {
        this.id = id;
        this.customerId = customerId;
        this.totalAmount = totalAmount;
        this.isOnPayment = isOnPayment;
        this.cartItems = cartItems;
    }

    public Cart(List<CartItem> cartItems, boolean isOnPayment, double totalAmount, Long customerId) {
        this.cartItems = cartItems;
        this.isOnPayment = isOnPayment;
        this.totalAmount = totalAmount;
        this.customerId = customerId;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public boolean isOnPayment() {
        return isOnPayment;
    }

    public void setOnPayment(boolean onPayment) {
        isOnPayment = onPayment;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<CartItem> getCartItems() {
        return cartItems;
    }

    public void setCartItems(List<CartItem> cartItems) {
        this.cartItems = cartItems;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }
}
