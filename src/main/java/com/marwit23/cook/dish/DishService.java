package com.marwit23.cook.dish;

import java.util.List;

public interface DishService {
    public List<Dish> findAll(Integer pageNo, Integer pageSize, String sortBy);
    public Dish findById(Long dishId);
    public void save(Dish theDish);
    public void deleteById(Long dishId);
}
