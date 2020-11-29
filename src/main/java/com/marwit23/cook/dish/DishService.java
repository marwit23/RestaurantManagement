package com.marwit23.cook.dish;

import java.util.List;

public interface DishService {
    List<Dish> findAll();
    List<Dish> findAllWithParams(Integer pageNo, Integer pageSize, String sortBy);
    Dish findById(Long dishId);
    void save(Dish theDish);
    void deleteById(Long dishId);
}
