package com.marwit23.cook.dish;

import com.marwit23.cook.todo.ToDoDish;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter @Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Dish {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long dishId;
    @Column(unique = true)
    private String dishName;

    @OneToMany(mappedBy = "dish")
    private List<ToDoDish> toDoDishList;

    @OneToMany(mappedBy = "dish", cascade = CascadeType.ALL)
    private List<DishIngredient> dishIngredients;

    public Dish(String dishName, List<DishIngredient> dishIngredients) {
        this.dishName = dishName;
        this.dishIngredients = dishIngredients;
    }

    public void setDishIngredients(List<DishIngredient> dishIngredients) {
        this.dishIngredients = dishIngredients;
        for(DishIngredient dishIngredient: dishIngredients) {
            dishIngredient.setDish(this);
        }
    }
}
