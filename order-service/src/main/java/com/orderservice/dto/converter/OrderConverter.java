package com.orderservice.dto.converter;

import com.orderservice.dto.OrderDto;
import com.orderservice.model.Order;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class OrderConverter {

    private final OrderItemConverter orderItemConverter;

    public OrderConverter(OrderItemConverter orderItemConverter) {
        this.orderItemConverter = orderItemConverter;
    }

    public OrderDto toOrderDto(Order order) {
        OrderDto orderDto = new OrderDto();
        orderDto.setId(order.getId());
        orderDto.setUserId(order.getUserId());
        orderDto.setOrderStatus(order.getOrderStatus());
        orderDto.setTotalAmount(order.getTotalAmount());
        if(order.getOrderItems() != null) orderDto.setOrderItems(order.getOrderItems()
                .stream()
                .map(orderItemConverter::toOrderItemDto)
                .collect(Collectors.toList()));
        return orderDto;
    }

}
