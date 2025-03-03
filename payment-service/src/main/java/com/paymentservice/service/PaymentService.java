package com.paymentservice.service;

import com.paymentservice.dto.CartDto;
import com.paymentservice.dto.OrderItemDto;
import com.paymentservice.dto.OrderPostDto;
import com.paymentservice.dto.OrderStatus;
import com.paymentservice.feignClients.CartServiceClient;
import com.paymentservice.model.Payment;
import com.paymentservice.repository.OrderServiceClient;
import com.paymentservice.repository.PaymentRepository;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    private final PaymentRepository paymentRepository;
    private final CartServiceClient cartServiceClient;
    private final OrderServiceClient orderServiceClient;

    public PaymentService(PaymentRepository paymentRepository, CartServiceClient cartServiceClient, OrderServiceClient orderServiceClient) {
        this.paymentRepository = paymentRepository;
        this.cartServiceClient = cartServiceClient;
        this.orderServiceClient = orderServiceClient;
    }


    public void makePayment(Long value, Long cartId) {
        CartDto cart = cartServiceClient.getCart(cartId).getBody();
        cartServiceClient.changePaymentStatus(cart.getId(), "true");

        OrderPostDto orderPostDto = new OrderPostDto();
        orderPostDto.setOrderStatus(OrderStatus.ON_PAYMENT);
        orderPostDto.setTotalAmount(cart.getTotalAmount());
        orderPostDto.setUserId(cart.getCustomerId());
        orderPostDto.setOrderItems(cart.getCartItems().stream()
                .map(cartItemDto -> new OrderItemDto(cartItemDto.getProductId(), (long) cartItemDto.getQuantity()))
                .toList());
        String orderId = orderServiceClient.createOrder(orderPostDto);

        Payment payment = new Payment(Long.parseLong(orderId), (double) value, cart.getId());
    }
}
