package com.food.feedMe.product;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class ProductDto {

    private Long id;

    private String name;

    private double calories;

    private double protein;

    private double fat;

    private double carbs;

    private double price;

}
