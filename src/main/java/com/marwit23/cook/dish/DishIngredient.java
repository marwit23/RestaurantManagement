package com.marwit23.cook.dish;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.marwit23.cook.ingredient.Ingredient;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter @Setter
@Entity
public class DishIngredient {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long dishIngredientId;

    @ManyToOne
    @JoinColumn(name = "ingredientId")
    @JsonIgnoreProperties("dishIngredients")
    private Ingredient ingredient;
    private int quantityGrams;

    @ManyToOne
    @JoinColumn(name = "dishId")
    @JsonIgnoreProperties("dishIngredients")
    private Dish dish;
}
