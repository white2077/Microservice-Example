package com.white.oder.order;

import org.springframework.data.jpa.repository.JpaRepository;

public interface IOderRepository extends JpaRepository<Order, String> {
}
