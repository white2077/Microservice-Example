package com.white.product.product;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/products")
public class ProductController {
    private final ProductService productService;

    @GetMapping("/all-products")
    public ResponseEntity<?> getProducts() {
        return  ResponseEntity.ok(productService.getProducts());
    }
    @PostMapping("/create-product")
    public ResponseEntity<?> createProduct(@RequestBody ProductDTO.CreateProductDTO createProductDTO) {
        return ResponseEntity.ok(productService.createProduct(createProductDTO));
    }
    @PutMapping("/update-product/{id}")
    public ResponseEntity<?> updateProduct(@PathVariable String id, @RequestBody ProductDTO.UpdateProductDTO updateProductDTO) {
        return ResponseEntity.ok(productService.updateProduct(id, updateProductDTO));
    }
    @DeleteMapping("/delete-product/{id}")
    public ResponseEntity<?> deleteProduct(@PathVariable String id) {
        productService.deleteProduct(id);
        return ResponseEntity.ok("Product deleted successfully");
    }
}
