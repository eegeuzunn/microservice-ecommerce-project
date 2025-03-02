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

    private boolean isOnPayment;

    @OneToMany(mappedBy = "cart")
    private List<CartItem> cartItems;

    public Cart() {
    }

    public Cart(Long customerId, boolean isOnPayment, List<CartItem> cartItems) {
        this.customerId = customerId;
        this.isOnPayment = isOnPayment;
        this.cartItems = cartItems;
    }

    public Cart(Long id, Long customerId, boolean isOnPayment, List<CartItem> cartItems) {
        this.id = id;
        this.customerId = customerId;
        this.isOnPayment = isOnPayment;
        this.cartItems = cartItems;
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
