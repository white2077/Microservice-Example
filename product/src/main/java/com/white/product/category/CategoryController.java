package com.white.product.category;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/category")
@RequiredArgsConstructor
public class CategoryController {
    private final CategoryService categoryService;
    @GetMapping("/all")
    public ResponseEntity<?> getAllCategories(){
        return ResponseEntity.ok(categoryService.getAllCategories());
    }
    @PostMapping("/create")
    public ResponseEntity<?> createCategory(CategoryDTO.CreateCategoryDTO createCategoryDTO){
        return ResponseEntity.ok(categoryService.createCategory(createCategoryDTO));
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteCategory(@PathVariable String id){
        categoryService.deleteCategory(id);
        return ResponseEntity.ok("Category deleted successfully");
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateCategory(@PathVariable String id, CategoryDTO.UpdateCategoryDTO updateCategoryDTO){
        return ResponseEntity.ok(categoryService.updateCategory(id, updateCategoryDTO));
    }
}
