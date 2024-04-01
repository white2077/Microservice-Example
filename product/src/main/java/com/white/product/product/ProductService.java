package com.white.product.product;

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

    public List<Product> getProducts() {
        log.info("Fetching all products");
        return productRepository.findAll();
    }
    public Product createProduct(ProductDTO.CreateProductDTO createProductDTO) {
        log.info("Creating product: "+createProductDTO);
        return productRepository.save(MapperUtil.map(createProductDTO, Product.class));
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
