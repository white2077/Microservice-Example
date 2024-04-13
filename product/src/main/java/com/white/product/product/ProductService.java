package com.white.product.product;

import com.white.product.category.Category;
import com.white.product.category.ICategoryRepository;
import com.white.product.utils.MapperUtil;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
public class ProductService {
    private final IProductRepository productRepository;
    private final ICategoryRepository categoryRepository;

    public List<Product> getProducts() {
        log.info("Fetching all products");
        return productRepository.findAll();
    }
    public Product createProduct(ProductDTO.CreateProductDTO createProductDTO) {
        log.info("Creating product: "+createProductDTO);
        Product product = productRepository.save(MapperUtil.map(createProductDTO, Product.class));
        List<Category> categories = categoryRepository.findAllById(createProductDTO.getCategoryId());
        product.setCategories(categories);
        return productRepository.save(product);
    }
    public Product updateProduct(String id, ProductDTO.UpdateProductDTO updateProductDTO) {
        log.info("Updating product: "+updateProductDTO);
        Product product = productRepository.findById(id).orElseThrow(() -> new RuntimeException("Product not found"));
        MapperUtil.map(updateProductDTO, Product.class);
        log.info("Product updated successfully");
        return productRepository.save(product);
    }
    public void deleteProduct(String id) {
        log.info("Deleting product with id: "+id);
        productRepository.deleteById(id);
        log.info("Product deleted successfully");
    }
}
