package com.marwit23.cook.ingredient;

import com.marwit23.cook._constants.IngredientCategory;

public class IngredientDTO {
    private long ingredientId;
    private String ingredientName;
    private IngredientCategory ingredientCategory;
    private int shelfLife;
    private int totalQuantity;
    private int orderedQuantity;
    private int safeQuantity;
}
