package com.marwit23.cook.dish;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.marwit23.cook.ingredient.Ingredient;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class DishIngredient {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long dishIngredientId;

    @ManyToOne
    @JoinColumn(name = "ingredientId")
    private Ingredient ingredient;
    private int quantityGrams;

    @ManyToOne
    @JoinColumn(name = "dishId")
    private Dish dish;

    public DishIngredient(Ingredient ingredient, int quantityGrams) {
        this.ingredient = ingredient;
        this.quantityGrams = quantityGrams;
    }
}
