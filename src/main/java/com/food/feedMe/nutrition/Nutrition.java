package com.food.feedMe.nutrition;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.food.feedMe.product.Product;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class Nutrition {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private double calories100g;
    private double protein100g;
    private double fat100g;
    private double carbohydrates100g;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id")
    @JsonBackReference
    private Product product;

}
