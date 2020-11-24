package com.marwit23.cook.dish.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DishIngredientDTO {

    private long ingredientId;
    private String ingredientName;
    private int quantityGrams;
    private int availableQuantity;
}
