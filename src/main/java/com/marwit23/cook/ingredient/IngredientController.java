package com.marwit23.cook.ingredient;

import com.marwit23.cook._exception.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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
    public List<Ingredient> findAll(
            @RequestParam(defaultValue = "0") Integer pageNo,
            @RequestParam(defaultValue = "25") Integer pageSize,
            @RequestParam(defaultValue = "ingredientId") String sortBy) {
        return ingredientService.findAll(pageNo, pageSize, sortBy);
    }

    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    public Ingredient addIngredient(@RequestBody Ingredient theIngredient) {
        ingredientService.save(theIngredient);
        return theIngredient;
    }

    @GetMapping("/{ingredientId}")
    public Ingredient getIngredient(@PathVariable Long ingredientId) {
        Ingredient theIngredient = ingredientService.findById(ingredientId);
        if (theIngredient == null) throw new EntityNotFoundException("ingredient", ingredientId.toString());
        return theIngredient;
    }

    @PutMapping("/{ingredientId}")
    @PreAuthorize("hasRole('ADMIN')")
    public Ingredient updateIngredient(@Valid @RequestBody Ingredient theIngredient, @PathVariable Long ingredientId) {
        theIngredient.setIngredientId(ingredientId);
        ingredientService.save(theIngredient);
        return theIngredient;
    }

    @DeleteMapping("/{ingredientId}")
    @PreAuthorize("hasRole('ADMIN')")
    public String deleteIngredient(@PathVariable Long ingredientId) {
        Ingredient tempIngredient = ingredientService.findById(ingredientId);
        if (tempIngredient == null) throw new EntityNotFoundException("ingredient", ingredientId.toString());
        ingredientService.deleteById(ingredientId);
        return "Deleted ingredient id - " + ingredientId;
    }
}
