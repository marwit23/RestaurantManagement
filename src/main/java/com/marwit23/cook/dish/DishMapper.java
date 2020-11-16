package com.marwit23.cook.dish;

import com.marwit23.cook.delivery.Delivery;
import com.marwit23.cook.delivery.DeliveryItem;
import com.marwit23.cook.delivery.dtos.DeliveryDetailsDTO;
import com.marwit23.cook.delivery.dtos.DeliveryItemDTO;
import com.marwit23.cook.dish.dtos.DishDetailsDTO;
import com.marwit23.cook.dish.dtos.DishSimpleDTO;
import com.marwit23.cook.dish.dtos.DishIngredientDTO;
import com.marwit23.cook.ingredient.IngredientRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class DishMapper {

    private ModelMapper modelMapper;
    private IngredientRepository ingredientRepository;

    public DishMapper(ModelMapper modelMapper, IngredientRepository ingredientRepository) {
        this.modelMapper = modelMapper;
        this.ingredientRepository = ingredientRepository;
    }

    DishSimpleDTO convertToDtoSimple(Dish dish) {
        DishSimpleDTO theDishSimpleDTO = modelMapper.map(dish, DishSimpleDTO.class);
        return theDishSimpleDTO;
    }

    DishDetailsDTO convertToDtoDetails(Dish dish) {
        DishDetailsDTO DishDetailsDTO = modelMapper.map(dish, DishDetailsDTO.class);
        DishDetailsDTO.setIngredients(
                dish.getDishIngredients().stream()
                        .map(dishIngredient -> modelMapper.map(dishIngredient, DishIngredientDTO.class))
                        .collect(Collectors.toList())
        );
        return DishDetailsDTO;
    }

    Dish convertToEntity(DishDetailsDTO dishDetailsDTO) {
        Dish dish = new Dish();
        dish.setDishName(dishDetailsDTO.getDishName());
        List<DishIngredient> dishIngredients = new ArrayList<>();
        for(int i = 0; i < dishDetailsDTO.getIngredients().size(); i++ ) {
            DishIngredient tempDishIngredient = new DishIngredient();
            DishIngredientDTO tempDishIngredientDTO = dishDetailsDTO.getIngredients().get(i);
            tempDishIngredient.setIngredient(ingredientRepository.findByIngredientName(tempDishIngredientDTO.getIngredientName()));
            tempDishIngredient.setQuantityGrams(tempDishIngredientDTO.getQuantityGrams());
            tempDishIngredient.setDishIngredientId(tempDishIngredientDTO.getDishIngredientId());
            dishIngredients.add(tempDishIngredient);
        }
        dish.setDishIngredients(dishIngredients);
        return dish;
    }

}
