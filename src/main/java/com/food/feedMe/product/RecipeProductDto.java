package com.food.feedMe.product;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class RecipeProductDto {

    private String productName;
    private double amount;
    private String unit;
    private double calories;

}
