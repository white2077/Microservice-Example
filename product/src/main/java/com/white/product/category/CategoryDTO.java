package com.white.product.category;

public abstract class CategoryDTO {
    public static class CreateCategoryDTO {
        private String name;
        private String description;
    }
    public static class UpdateCategoryDTO {
        private String name;
        private String description;
    }
}
