package com.orderservice.dto.converter;

import com.orderservice.dto.OrderItemDto;
import com.orderservice.model.OrderItem;
import org.springframework.stereotype.Component;

@Component
public class OrderItemConverter {

    public OrderItemDto toOrderItemDto(OrderItem orderItem) {

        if (orderItem == null) {
            return null;
        }

        OrderItemDto orderItemDto = new OrderItemDto();
        orderItemDto.setProductId(orderItem.getProductId());
        orderItemDto.setQuantity(orderItem.getQuantity());
        return orderItemDto;
    }

    public OrderItem toOrderItem(OrderItemDto orderItemDto) {

        if (orderItemDto == null) {
            return null;
        }

        OrderItem orderItem = new OrderItem();
        orderItem.setProductId(orderItemDto.getProductId());
        orderItem.setQuantity(orderItemDto.getQuantity());
        return orderItem;

    }
}
