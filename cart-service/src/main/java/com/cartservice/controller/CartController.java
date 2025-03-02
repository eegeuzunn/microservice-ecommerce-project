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

    @PostMapping("/users/{userId}/products/{productId}/{quantity}")
    public ResponseEntity<String> addProductToCart(@PathVariable Long userId, @PathVariable Long productId, @PathVariable(required = false) Integer quantity) {
        cartService.addProductToCart(userId, productId, quantity);
        return ResponseEntity.ok("Product added to cart");
    }

    @DeleteMapping("/users/{userId}/products/{productId}")
    public ResponseEntity<?> removeProductFromCart(@PathVariable Long userId, @PathVariable Long productId) {
        cartService.deleteProductFromCart(userId, productId);
        return ResponseEntity.ok("Product removed from cart");
    }

    @PatchMapping("{cartId}/paymentStatus")
    public ResponseEntity<?> changePaymentStatus(@PathVariable Long cartId, @RequestBody String isOnPayment) {
        cartService.changePaymentStatus(cartId, isOnPayment);
        return ResponseEntity.ok("Payment status changed");
    }

    @GetMapping("{cartId}/paymentStatus")
    public ResponseEntity<Boolean> getPaymentStatus(@PathVariable Long cartId) {
        return ResponseEntity.ok(cartService.getPaymentStatus(cartId));
    }

}
