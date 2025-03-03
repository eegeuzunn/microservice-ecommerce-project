package com.paymentservice.feignClients;

import com.paymentservice.dto.CartDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "cart-service", path = "/carts")
public interface CartServiceClient{

        @GetMapping("/users/{userId}")
        ResponseEntity<CartDto> getCart(@PathVariable Long userId);

        @PostMapping("/users/{userId}/products/{productId}/{quantity}")
        ResponseEntity<String> addProductToCart(@PathVariable Long userId, @PathVariable Long productId, @PathVariable(required = false) Integer quantity);

        @DeleteMapping("/users/{userId}/products/{productId}")
        ResponseEntity<?> removeProductFromCart(@PathVariable Long userId, @PathVariable Long productId);

        @PatchMapping("{cartId}/paymentStatus")
        ResponseEntity<?> changePaymentStatus(@PathVariable Long cartId, @RequestBody String isOnPayment);

        @GetMapping("{cartId}/paymentStatus")
        ResponseEntity<Boolean> getPaymentStatus(@PathVariable Long cartId);


}
