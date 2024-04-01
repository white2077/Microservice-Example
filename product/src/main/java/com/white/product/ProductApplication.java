package com.white.product;

import com.white.product.category.Category;
import com.white.product.category.ICategoryRepository;
import com.white.product.product.IProductRepository;
import com.white.product.product.Product;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@RequiredArgsConstructor
@Slf4j
public class ProductApplication implements CommandLineRunner {
    private final IProductRepository productRepository;
    private final ICategoryRepository categoryRepository;

    public static void main(String[] args) {
        SpringApplication.run(ProductApplication.class, args);
    }

    @Override
    public void run(String... args){
        categoryRepository.save(Category.builder().name("Category 1").description("Category 1 description").build());
        categoryRepository.save(Category.builder().name("Category 2").description("Category 2 description").build());
        categoryRepository.save(Category.builder().name("Category 3").description("Category 3 description").build());
        categoryRepository.findAll().forEach(category -> log.info("Category: "+category));
        productRepository.save(Product.builder().name("Product 1").description("Product 1 description").price(100.0).quantity(10).categories(categoryRepository.findAll()).build());
        productRepository.save(Product.builder().name("Product 2").description("Product 2 description").price(200.0).quantity(20).categories(categoryRepository.findAll()).build());
        productRepository.save(Product.builder().name("Product 3").description("Product 3 description").price(300.0).quantity(30).categories(categoryRepository.findAll()).build());
        productRepository.findAll().forEach(product -> log.info("Product: "+product));
        log.info("ProductApplication is running...");
    }
}
