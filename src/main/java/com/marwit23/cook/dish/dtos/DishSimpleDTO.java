package com.marwit23.cook.dish.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DishSimpleDTO {

    private long dishId;
    private String dishName;
}
