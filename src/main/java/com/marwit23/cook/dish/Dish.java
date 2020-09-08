package com.marwit23.cook.dish;


import com.marwit23.cook.delivery.DeliveryItem;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter @Setter
@Entity
public class Dish {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long dishId;
    private String dishName;

    @OneToMany(mappedBy = "dish")
    private List<DishIngredient> dishIngredients;

    public void setDishIngredients(List<DishIngredient> dishIngredients) {
        this.dishIngredients = dishIngredients;
        for(DishIngredient dishIngredient: this.dishIngredients) {
            dishIngredient.setDish(this);
        }
    }
}
