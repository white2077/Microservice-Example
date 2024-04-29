package com.white.product.product;

import com.white.product.core.model.ResponseObject;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/products")
public class ProductController {
    private final ProductService productService;

    @GetMapping("/all-products")
    public ResponseObject<List<Product>> getProducts() {
        return  new ResponseObject<>(HttpStatus.OK, "Products fetched successfully v1.1", productService.getProducts());
    }
    @PostMapping("/create-product")
    public ResponseObject<Product> createProduct(@RequestBody ProductDTO.CreateProductDTO createProductDTO) {
        return new ResponseObject<>(HttpStatus.CREATED, "Product created successfully", productService.createProduct(createProductDTO));
    }
    @PutMapping("/update-product/{id}")
    public ResponseObject<Product> updateProduct(@PathVariable String id, @RequestBody ProductDTO.UpdateProductDTO updateProductDTO) {
        return new ResponseObject<>(HttpStatus.ACCEPTED, "Product updated successfully", productService.updateProduct(id, updateProductDTO));
    }
    @DeleteMapping("/delete-product/{id}")
    public ResponseObject<?> deleteProduct(@PathVariable String id) {
        productService.deleteProduct(id);
        return new ResponseObject<>(HttpStatus.OK, "Product deleted successfully");
    }
}
