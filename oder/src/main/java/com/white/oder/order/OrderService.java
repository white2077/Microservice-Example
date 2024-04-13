package com.white.oder.order;

import com.white.oder.item.IOrderItemRepository;
import com.white.oder.item.OrderItemDTO;
import com.white.oder.item.OrderItems;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final ModelMapper modelMapper;
    private final IOderRepository orderRepository;
    private final IOrderItemRepository orderItemRepository;

    public Order createOrder(OrderDTO.Create order) {
        Order newOrder = modelMapper.map(order, Order.class);
        orderRepository.save(newOrder);
        orderItemRepository.saveAll(order.getOrderItems().stream().map(this::apply).toList());
        return newOrder;
    }

    private OrderItems apply(OrderItemDTO.Create orderItem) {
        return modelMapper.map(orderItem, OrderItems.class);
    }
}
