package com.cartservice.controller;

import com.cartservice.dto.CartDto;
import com.cartservice.service.CartService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/carts")
public class CartController {

    private final CartService cartService;

    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

    @GetMapping("/users/{userId}")
    public ResponseEntity<CartDto> getCart(@PathVariable Long userId) {
        return ResponseEntity.ok(cartService.getCart(userId));
    }

    @PostMapping("/users/{userId}/products/{productId}")
    public ResponseEntity<String> addProductToCart(@PathVariable Long userId, @PathVariable Long productId) {
        cartService.addProductToCart(userId, productId);
        return ResponseEntity.ok("Product added to cart");
    }

    @DeleteMapping("/users/{userId}/products/{productId}")
    public ResponseEntity<?> removeProductFromCart(@PathVariable Long userId, @PathVariable Long productId) {
        cartService.deleteProductFromCart(userId, productId);
        return ResponseEntity.ok("Product removed from cart");
    }

}
