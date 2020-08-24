package com.marwit23.cook.ingredient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/ingredients")
public class IngredientController {

    private IngredientService ingredientService;

    @Autowired
    public IngredientController(IngredientService ingredientService) {
        this.ingredientService = ingredientService;
    }

    @GetMapping
    public List<Ingredient> findAll() {
        return ingredientService.findAll();
    }

    @GetMapping("/{ingredientId}")
    public Ingredient getIngredient(@PathVariable Long ingredientId){
        Ingredient theIngredient = ingredientService.findById(ingredientId);

        if(theIngredient == null){
            throw new RuntimeException("Ingredient id not found - " + ingredientId);
        }
        return theIngredient;
    }

    @PostMapping
    public Ingredient addIngredient(@RequestBody Ingredient theIngredient){
        theIngredient.setIngredientId((long) 0);
        ingredientService.save(theIngredient);
        return theIngredient;
    }

    @PutMapping
    public Ingredient updateIngredient(@RequestBody Ingredient theIngredient) {
        ingredientService.save(theIngredient);
        return theIngredient;
    }

    @DeleteMapping("/{ingredientId}")
    public String deleteIngredient(@PathVariable Long ingredientId) {
        Ingredient tempIngredient = ingredientService.findById(ingredientId);

        if(tempIngredient == null){
            throw new RuntimeException("Ingredient id not found - " + ingredientId);
        }
        ingredientService.deleteById(ingredientId);
        return "Deleted ingredient id - " + ingredientId;
    }
}
