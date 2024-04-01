package com.white.product.product;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.white.product.category.Category;
import com.white.product.core.CoreEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.List;

@Entity(name = "product")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Product extends CoreEntity {
    @NotNull
    @Size(min = 3, max = 50, message = "Name must be between 3 and 50 characters")
    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @NotNull
    @Min(value = 0, message = "Price must be greater than 0")
    @Column(name = "price")
    private Double price;

    @NotNull
    @Min(value = 0, message = "Quantity must be greater than 0")
    @Column(name = "quantity")
    private int quantity;
    @ManyToMany
    @JsonManagedReference
    private List<Category> categories;
}
