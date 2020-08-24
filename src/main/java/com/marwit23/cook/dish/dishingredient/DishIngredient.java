package com.marwit23.cook.dish.dishingredient;

import com.marwit23.cook.dish.Dish;
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
    @JoinColumn(name = "recipeIngredients" )
    private Ingredient ingredient;
    private int ingredientQuantity;

    @ManyToOne
    @JoinColumn(name = "dishId")
    private Dish dish;

}
