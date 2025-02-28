package com.cartservice.dto;

import java.util.List;

public class CartDto {

    private Long id;
    private Long customerId;
    private List<CartItemDto> cartItems;

    public CartDto() {
    }

    public CartDto(Long id, Long customerId, List<CartItemDto> cartItems) {
        this.id = id;
        this.customerId = customerId;
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

    public List<CartItemDto> getCartItems() {
        return cartItems;
    }

    public void setCartItems(List<CartItemDto> cartItems) {
        this.cartItems = cartItems;
    }
}
