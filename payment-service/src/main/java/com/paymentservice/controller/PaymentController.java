package com.paymentservice.controller;

import com.paymentservice.service.PaymentService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PaymentController {

    private final PaymentService paymentService;

    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @PostMapping("/payment/value/{value}/cartId/{cartId}")
    public String makePayment(Long value, Long cartId) {
        paymentService.makePayment(value, cartId);
        return "Payment made successfully";
    }
}
