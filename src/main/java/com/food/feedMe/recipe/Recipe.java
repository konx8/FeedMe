package com.food.feedMe.recipe;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Recipe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String recipeName;

    private String preparationDescription;

    private String preparationTime;

    @Enumerated(EnumType.STRING)
    private RecipeType type;

    @Transient
    private Double totalCalories;

    @OneToMany(mappedBy = "recipe", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<RecipeProduct> ingredients = new ArrayList<>();

}
