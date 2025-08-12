package com.food.feedMe.recipe;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RecipeRepo extends JpaRepository <Recipe, Long> {

    List<Recipe> findByRecipeNameContainingIgnoreCase(String namePart);

}
