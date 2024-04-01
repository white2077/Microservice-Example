package com.white.product.category;

import com.white.product.utils.MapperUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryService {
    private final ICategoryRepository categoryRepository;
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    public Category createCategory(CategoryDTO.CreateCategoryDTO createCategoryDTO) {
        return categoryRepository.save(MapperUtil.map(createCategoryDTO, Category.class));
    }
    public Category updateCategory(String id, CategoryDTO.UpdateCategoryDTO updateCategoryDTO) {
        Category category = categoryRepository.findById(id).orElseThrow(() -> new RuntimeException("Category not found"));
        MapperUtil.map(updateCategoryDTO, Category.class);
        return categoryRepository.save(category);
    }
    public void deleteCategory(String id) {
        categoryRepository.deleteById(id);
    }
}
