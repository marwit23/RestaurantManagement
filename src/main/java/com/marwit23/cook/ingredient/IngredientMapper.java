package com.marwit23.cook.ingredient;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class IngredientMapper {

    private ModelMapper modelMapper;

    public IngredientMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    IngredientDTO convertToDto(Ingredient ingredient) {
        IngredientDTO ingredientDto = modelMapper.map(ingredient, IngredientDTO.class);
        return ingredientDto;
    }

    Ingredient convertToEntity(IngredientDTO ingredientDto, Ingredient ingredient) {
        ingredient.setIngredientName(ingredientDto.getIngredientName());
        ingredient.setIngredientCategory(ingredientDto.getIngredientCategory());
        ingredient.setShelfLife(ingredientDto.getShelfLife());
        return ingredient;
    }
}
