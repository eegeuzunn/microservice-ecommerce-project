package com.cartservice.service;

import com.cartservice.dto.CartDto;
import com.cartservice.dto.ProductDto;
import com.cartservice.dto.converter.CartConverter;
import com.cartservice.exception.CartNotFoundException;
import com.cartservice.exception.ProductNotFoundException;
import com.cartservice.feignClient.ProductServiceClient;
import com.cartservice.model.Cart;
import com.cartservice.model.CartItem;
import com.cartservice.repository.CartItemRepository;
import com.cartservice.repository.CartRepository;
import org.springframework.stereotype.Service;

@Service
public class CartService {

    private final CartRepository cartRepository;
    private final CartItemRepository cartItemRepository;
    private final ProductServiceClient productServiceClient;
    private final CartConverter cartConverter;

    public CartService(CartRepository cartRepository, CartItemRepository cartItemRepository, ProductServiceClient productServiceClient, CartConverter cartConverter) {
        this.cartRepository = cartRepository;
        this.cartItemRepository = cartItemRepository;
        this.productServiceClient = productServiceClient;
        this.cartConverter = cartConverter;
    }

    public CartDto getCart(Long customerId) {
        if(!cartRepository.existsByCustomerId(customerId)) {
            return cartConverter.convertCartToDto(cartRepository.save(new Cart(customerId, null)));
        }
        return cartConverter.convertCartToDto(cartRepository.findByCustomerId(customerId).get());
    }

    public void addProductToCart(Long customerId, Long productId) {
        Cart cart;
        if(!cartRepository.existsByCustomerId(customerId)) {
            cart = cartRepository.save(new Cart(customerId, null));
        } else {
            cart = cartRepository.findByCustomerId(customerId).get();
        }

        ProductDto product = productServiceClient.getProductById(productId).getBody();
        CartItem cartItem = new CartItem(
                product.getId(),
                1,
                product.getPrice(),
                product.getPrice(),
                cart
        );
        cartItemRepository.save(cartItem);
    }

    public void deleteProductFromCart(Long userId, Long productId) {
        if(!cartRepository.existsByCustomerId(userId)) {
            throw new CartNotFoundException("Cart not found");
        }

        Cart cart = cartRepository.findByCustomerId(userId).get();
        CartItem cartItem = cartItemRepository.findByProductIdAndCartId(productId, cart.getId()).orElseThrow(() -> new ProductNotFoundException("Product not found in cart"));
        cartItemRepository.delete(cartItem);
    }
}
