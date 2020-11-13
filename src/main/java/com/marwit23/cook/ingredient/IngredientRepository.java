package com.marwit23.cook.ingredient;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface IngredientRepository extends JpaRepository<Ingredient, Long> {
    public Ingredient findByIngredientName(String ingredientName);

    List<Ingredient> findAll();
}
