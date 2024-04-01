package com.white.oder.order;

import com.white.oder.core.CoreEntity;
import com.white.oder.core.emum.OrderStatus;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.*;

@Entity(name = "orders")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Order extends CoreEntity {
    @Column(name = "customer_name")
    private String customerName;
    @Column(name = "customer_address")
    private String customerAddress;
    @Column(name = "customer_phone")
    private String customerPhone;
    @Column(name = "total_price")
    private double totalPrice;
    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private OrderStatus status;
}
