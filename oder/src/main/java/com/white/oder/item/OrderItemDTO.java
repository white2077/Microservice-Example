package com.white.oder.item;

import lombok.*;

public abstract class OrderItemDTO {
    @AllArgsConstructor
    @NoArgsConstructor
    @Getter
    @Setter
    @Builder
    public static class Create {
        private String orderId;
        private String productId;
        private int quantity;
        private double price;
    }
}
