package com.paymentservice.dto;

import java.util.List;

public class CartDto {

    private Long id;
    private Long customerId;
    private double totalAmount;
    private boolean isOnPayment;
    private List<CartItemDto> cartItems;

    public CartDto() {
    }

    public CartDto(Long id, Long customerId, double totalAmount, boolean isOnPayment, List<CartItemDto> cartItems) {
        this.id = id;
        this.customerId = customerId;
        this.totalAmount = totalAmount;
        this.isOnPayment = isOnPayment;
        this.cartItems = cartItems;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
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

    public List<CartItemDto> getCartItems() {
        return cartItems;
    }

    public void setCartItems(List<CartItemDto> cartItems) {
        this.cartItems = cartItems;
    }
}
