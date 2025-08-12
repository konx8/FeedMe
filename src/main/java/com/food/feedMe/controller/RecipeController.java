package com.food.feedMe.controller;

import com.food.feedMe.recipe.RecipeDto;
import com.food.feedMe.recipe.RecipeService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class RecipeController {

    private final RecipeService recipeService;

    @GetMapping("/recipes")
    public ResponseEntity<List<RecipeDto>> getRecipeByName(@RequestParam String recipeName){
        return ResponseEntity.ok(recipeService.getRecipeByName(recipeName));
    }

}
