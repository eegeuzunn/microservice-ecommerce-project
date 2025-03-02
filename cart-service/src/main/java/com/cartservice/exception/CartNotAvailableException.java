package com.cartservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.LOCKED)
public class CartNotAvailableException extends RuntimeException {
    public CartNotAvailableException(String message) {
        super(message);
    }
}
