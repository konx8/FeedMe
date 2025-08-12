package com.food.feedMe.recipe;

import com.food.feedMe.product.*;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class RecipeService {

    private final RecipeRepo recipeRepo;
    private final ProductUnitWeightService productUnitWeightService;

    public List<RecipeDto> getRecipeByName(String recipeName) {

        List<Recipe> recipeList = recipeRepo.findByRecipeNameContainingIgnoreCase(recipeName);
        return prepareRecipeDto(recipeList);

    }

    private List<RecipeDto> prepareRecipeDto(List<Recipe> recipeList) {

        List<ProductUnitWeight> productWithCustomWeight = productUnitWeightService.findProductWithCustomWeight();

        return recipeList.stream()
                .map(recipe -> {
                    RecipeDto recipeDto = new RecipeDto();
                    recipeDto.setRecipeName(recipe.getRecipeName());
                    recipeDto.setPreparationDescription(recipe.getPreparationDescription());
                    List<RecipeProductDto> recipeProductDtoList = mapToRecipeProductDtoList(recipe, productWithCustomWeight);
                    recipeDto.setIngredients(recipeProductDtoList);
                    recipeDto.setCaloriesPerMeal(countTotalCalPerMeal(recipeProductDtoList));
                    recipeDto.setType(recipe.getType());
                    return recipeDto;
                })
                .toList();
    }

    private double countTotalCalPerMeal(List<RecipeProductDto> recipeProductDtoList) {
        return recipeProductDtoList.stream()
                .mapToDouble(RecipeProductDto::getCalories)
                .sum();
    }

    private List<RecipeProductDto> mapToRecipeProductDtoList(Recipe recipe, List<ProductUnitWeight> productWithCustomWeight) {
        return recipe.getIngredients().stream().map(ingredient -> {
                    RecipeProductDto dto = new RecipeProductDto();
                    dto.setProductName(ingredient.getProduct().getNamePl());
                    dto.setAmount(ingredient.getAmount());
                    dto.setUnit(ingredient.getUnit());
                    dto.setCalories(countCalories(ingredient, productWithCustomWeight));
                    return dto;
                })
                .toList();
    }

    private double countCalories(RecipeProduct recipeProduct, List<ProductUnitWeight> productUnitWeightList) {
        Double unitWeight = productUnitWeightList.stream().filter(puw ->
                        puw.getProduct().getNamePl().equalsIgnoreCase(recipeProduct.getProduct().getNamePl()))
                .map(ProductUnitWeight::getWeightInGrams)
                .findFirst()
                .orElse(recipeProduct.getProduct().getNutrition().getCalories100g() / 100);

        return recipeProduct.getAmount() * unitWeight;

    }

}
