package com.white.product.product;

import com.white.product.category.CategoryDTO;
import lombok.*;

import java.util.List;

public abstract class ProductDTO {
    @AllArgsConstructor
    @NoArgsConstructor
    @Getter
    @Setter
    @Builder
    @ToString
    public static class CreateProductDTO {
        private String name;
        private String description;
        private Double price;
        private int quantity;
        private List<String> categoryId;
    }
    @AllArgsConstructor
    @NoArgsConstructor
    @Getter
    @Setter
    @Builder
    public static class UpdateProductDTO {
        private String name;
        private Double price;
        private int quantity;
        private String description;
    }
}
