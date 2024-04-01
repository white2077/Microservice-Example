package com.white.oder.item;

import com.white.oder.core.CoreEntity;
import jakarta.persistence.Entity;
import lombok.*;

@Entity(name = "order_items")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class OrderItems extends CoreEntity{
    private String orderId;
    private String productId;
    private int quantity;
    private double price;
}
