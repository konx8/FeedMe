package com.food.feedMe.product;

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

    private String name;

    @Column(name = "calories_per_100g")
    private double calories;

    @Column(name = "protein_per_100g")
    private double protein;

    @Column(name = "fat_per_100g")
    private double fat;

    @Column(name = "carbs_per_100g")
    private double carbs;

    @Column(name = "price_per_100g")
    private double price;

}
