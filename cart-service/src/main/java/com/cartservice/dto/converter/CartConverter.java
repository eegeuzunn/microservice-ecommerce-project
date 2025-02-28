package com.cartservice.dto.converter;

import com.cartservice.dto.CartDto;
import com.cartservice.model.Cart;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class CartConverter {

    private final CartItemConverter cartItemConverter;

    public CartConverter(CartItemConverter cartItemConverter) {
        this.cartItemConverter = cartItemConverter;
    }

    public CartDto convertCartToDto(Cart cart) {
        return new CartDto(
                cart.getId(),
                cart.getCustomerId(),
                cart.getCartItems() != null ? cart.getCartItems().stream()
                        .map(cartItemConverter::toCartItemDto)
                        .collect(Collectors.toList()): null
        );
    }


}
