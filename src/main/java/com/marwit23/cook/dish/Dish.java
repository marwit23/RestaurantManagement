package com.marwit23.cook.dish;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.marwit23.cook.todo.ToDoDish;
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
    @Column(unique = true)
    private String dishName;

    @OneToMany(mappedBy = "dish")
    @JsonIgnore
    private List<ToDoDish> toDoDishList;

    @OneToMany(mappedBy = "dish", cascade = CascadeType.ALL)
    private List<DishIngredient> dishIngredients;

    public void setDishIngredients(List<DishIngredient> dishIngredients) {
        this.dishIngredients = dishIngredients;
        for(DishIngredient dishIngredient: this.dishIngredients) {
            dishIngredient.setDish(this);
        }
    }
}
