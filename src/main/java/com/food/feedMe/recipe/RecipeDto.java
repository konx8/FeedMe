package com.food.feedMe.recipe;

import com.food.feedMe.product.RecipeProductDto;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class RecipeDto {

    private String recipeName;
    private String preparationDescription;
    private List<RecipeProductDto> ingredients;
    private double caloriesPerMeal;
    private int preparationTimeMinutes;

    @Enumerated(EnumType.STRING)
    private RecipeType type;
}
