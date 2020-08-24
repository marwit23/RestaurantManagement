package com.marwit23.cook.dish;

import java.util.List;

public interface DishService {
    public List<Dish> findAll();
    public Dish findById(Long dishId);
    public void save(Dish theDish);
    public void deleteById(Long dishId);
}
