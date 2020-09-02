package com.marwit23.cook.ingredient;

import com.marwit23.cook._constants.IngredientCategory;
import com.marwit23.cook.dishingredient.DishIngredient;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Range;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Getter @Setter
@Entity
public class Ingredient {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long ingredientId;

    @Column(unique = true)
    @NotNull(message = "ingredient name cannot be null")
    private String ingredientName;

    @Enumerated(EnumType.STRING)
    @NotNull(message = "ingredient category cannot be null")
    private IngredientCategory ingredientCategory;

    @NotNull(message = "shelf life cannot be null")
    @Range(min = 1, max = 180, message = "shelf life must be between 1 and 180 days")
    private int shelfLife;

    @OneToMany(mappedBy = "dishIngredientId")
    private List<DishIngredient> dishIngredients;
}
