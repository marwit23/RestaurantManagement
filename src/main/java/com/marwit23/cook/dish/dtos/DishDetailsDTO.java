package com.marwit23.cook.dish.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DishDetailsDTO {

    private long dishId;
    private String dishName;
    private List<DishIngredientDTO> ingredients;
}
