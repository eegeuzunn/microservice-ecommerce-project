package com.cartservice.repository;

import com.cartservice.model.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CartRepository extends JpaRepository<Cart, Long> {
    public boolean existsByCustomerId(Long customerId);

    Optional<Cart> findByCustomerId(Long customerId);
}
