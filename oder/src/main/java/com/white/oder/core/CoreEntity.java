package com.white.oder.core;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;

@MappedSuperclass
public class CoreEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;
}
