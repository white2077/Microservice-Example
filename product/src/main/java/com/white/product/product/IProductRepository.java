package com.white.product.product;

import org.springframework.data.jpa.repository.JpaRepository;

public interface IProductRepository extends JpaRepository<Product, String> {
}

