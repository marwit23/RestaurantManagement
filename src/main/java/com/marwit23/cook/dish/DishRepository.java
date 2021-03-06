package com.marwit23.cook.dish;

import org.springframework.data.jpa.repository.JpaRepository;

public interface DishRepository extends JpaRepository <Dish, Long> {

    public Dish findByDishName(String dishName);
}
