package com.marwit23.cook.ingredient;

import java.util.List;

public interface IngredientService {
    List<Ingredient> findAll();
    List<Ingredient> findAllWithParams(Integer pageNo, Integer pageSize, String sortBy);
    Ingredient findById(Long theId);
    void save(Ingredient theIngredient);
    void deleteById(Long theId);
}
