package com.marwit23.cook.ingredient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class IngredientServiceImpl implements IngredientService {

    private IngredientRepository ingredientRepository;

    @Autowired
    public IngredientServiceImpl(IngredientRepository ingredientRepository) {
        this.ingredientRepository = ingredientRepository;
    }

    @Override
    public List<Ingredient> findAll() {
        return (List<Ingredient>) ingredientRepository.findAll();
    }

    @Override
    public Ingredient findById(Long theId) {
        Optional<Ingredient> result = ingredientRepository.findById(theId);
        Ingredient theIngredient = null;

        if(result.isPresent()){
            theIngredient =result.get();
        } else {
            throw new RuntimeException("Didn't find id = " + theId);
        }
        return theIngredient;
    }

    @Override
    public void save(Ingredient theIngredient) {
        ingredientRepository.save(theIngredient);

    }

    @Override
    public void deleteById(Long theId) {
        ingredientRepository.deleteById(theId);

    }
}
