package com.marwit23.cook.todo;

import com.marwit23.cook.dish.Dish;

import java.util.List;

public interface ToDoDishService {

    public List<ToDoDish> findAll();
    public ToDoDish findById(Long toDoDishId);
    public void save(ToDoDish theToDoDish);
    public void deleteById(Long toDoDishId);
}
