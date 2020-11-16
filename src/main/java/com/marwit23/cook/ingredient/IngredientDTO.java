package com.marwit23.cook.ingredient;

import com.marwit23.cook._constants.IngredientCategory;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class IngredientDTO {

    private long ingredientId;
    private String ingredientName;
    private IngredientCategory ingredientCategory;
    private int shelfLife;
    private int safeQuantity;
    private int expiredQuantity;
    private int orderedQuantity;

}
