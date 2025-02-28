package com.cartservice.repository;

import com.cartservice.model.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CartItemRepository extends JpaRepository<CartItem, Long> {
    Optional<CartItem> findByProductIdAndCartId(Long cartId, Long productId);
    void deleteByProductIdAndCartId(Long cartId, Long productId);
}
