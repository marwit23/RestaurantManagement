package com.marwit23.cook.ingredient;

import com.marwit23.cook._exception.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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
    public List<Ingredient> findAll(Integer pageNo, Integer pageSize, String sortBy) {
        Pageable pageable = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));
        Page<Ingredient> ingredientPage = ingredientRepository.findAll(pageable);
        return ingredientPage.getContent();
    }

    @Override
    public Ingredient findById(Long theId) {
        Optional<Ingredient> result = ingredientRepository.findById(theId);
        Ingredient theIngredient = result.get();

        if(result.isPresent()){
            theIngredient =result.get();
        } else {
            throw new EntityNotFoundException("ingredient", theId);
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
