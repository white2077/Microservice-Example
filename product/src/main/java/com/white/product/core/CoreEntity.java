package com.white.product.core;

import jakarta.persistence.*;

import java.sql.Timestamp;

@MappedSuperclass
public class CoreEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private Timestamp createdAt;
    private Timestamp updatedAt;
    private Timestamp deletedAt;
    @PrePersist
    public void prePersist() {
        this.createdAt = new Timestamp(System.currentTimeMillis());
    }
}
