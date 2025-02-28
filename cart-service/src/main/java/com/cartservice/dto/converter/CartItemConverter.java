package com.cartservice.dto.converter;

import com.cartservice.dto.CartItemDto;
import com.cartservice.model.CartItem;
import org.springframework.stereotype.Component;

@Component
public class CartItemConverter {

    public CartItemDto toCartItemDto(CartItem cartItem) {
        if(cartItem == null) return null;
        return new CartItemDto(cartItem.getId(),
                cartItem.getProductId(),
                cartItem.getQuantity(),
                cartItem.getUnitPrice(),
                cartItem.getTotalPrice());
    }
}
