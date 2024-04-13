package com.white.oder.order;

import com.white.oder.item.OrderItemDTO;
import lombok.*;

import java.util.List;

public abstract class OrderDTO {
    @AllArgsConstructor
    @NoArgsConstructor
    @Getter
    @Setter
    @Builder
    public static class Create {
        private String customerName;
        private String customerAddress;
        private String customerPhone;
        private double totalPrice;
        private List<OrderItemDTO.Create> orderItems;
    }
}
