package com.food.feedMe.product;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.food.feedMe.nutrition.Nutrition;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@Getter
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name_pl")
    private String namePl;

    @Column(name = "name_en")
    private String nameEn;

    @Column(name = "price_per_100g")
    private double price;

    @OneToOne(mappedBy = "product", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private Nutrition nutrition;

}
