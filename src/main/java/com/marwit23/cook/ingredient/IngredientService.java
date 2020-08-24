package com.marwit23.cook.ingredient;

import java.util.List;

public interface IngredientService {
    public List<Ingredient> findAll();
    public Ingredient findById(Long theId);
    public void save(Ingredient theIngredient);
    public void deleteById(Long theId);
}
