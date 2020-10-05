package com.marwit23.cook.ingredient;

import java.util.List;

public interface IngredientService {
    List<Ingredient> findAll(Integer pageNo, Integer pageSize, String sortBy);
    Ingredient findById(Long theId);
    Ingredient findByName(String ingredientName);
    void save(Ingredient theIngredient);
    void deleteById(Long theId);
}
