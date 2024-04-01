package com.white.product.category;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.white.product.core.CoreEntity;
import com.white.product.product.Product;
import jakarta.persistence.Column;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToMany;
import lombok.*;

import java.util.List;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Entity(name = "category")
public class Category extends CoreEntity {
    @Column(name = "name")
    private String name;
    @Column(name = "description")
    private String description;
    @ManyToMany(mappedBy = "categories",fetch = FetchType.LAZY)
    @JsonBackReference
    private List<Product> products;
}
