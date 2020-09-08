package com.marwit23.cook.ingredient;

import java.util.List;

public interface IngredientService {
    public List<Ingredient> findAll(Integer pageNo, Integer pageSize, String sortBy);
    public Ingredient findById(Long theId);
    public Ingredient findByName(String ingredientName);
    public void save(Ingredient theIngredient);
    public void deleteById(Long theId);
}
