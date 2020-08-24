package com.marwit23.cook.ingredient;

import com.marwit23.cook.constants.IngredientCategory;
import com.marwit23.cook.dish.dishingredient.DishIngredient;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Getter @Setter
@Entity
public class Ingredient {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long ingredientId;
    private String ingredientName;

    @Enumerated(EnumType.STRING)
    private IngredientCategory ingredientCategory;

    private BigDecimal unitPrice;
    private int shelfLife;

    @OneToMany(mappedBy = "dishIngredientId")
    private List<DishIngredient> recipeIngredients;

}
