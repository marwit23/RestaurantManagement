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
        DishDetailsDTO dishDetailsDTO = new DishDetailsDTO();
        dishDetailsDTO.setDishId(dish.getDishId());
        dishDetailsDTO.setDishName(dish.getDishName());
        List<DishIngredientDTO> dishIngredientDTOS = new ArrayList<>();
        for(int i = 0; i< dish.getDishIngredients().size(); i++) {
            DishIngredientDTO tempDishIngredientDTO = new DishIngredientDTO();
            tempDishIngredientDTO.setIngredientId(dish.getDishIngredients().get(i).getIngredient().getIngredientId());
            tempDishIngredientDTO.setIngredientName(dish.getDishIngredients().get(i).getIngredient().getIngredientName());
            tempDishIngredientDTO.setQuantityGrams(dish.getDishIngredients().get(i).getQuantityGrams());
            tempDishIngredientDTO.setAvailableQuantity(dish.getDishIngredients().get(i).getIngredient().getAvailableQuantity());
            dishIngredientDTOS.add(tempDishIngredientDTO);
        }
        dishDetailsDTO.setIngredients(dishIngredientDTOS);
        return dishDetailsDTO;
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
            dishIngredients.add(tempDishIngredient);
        }
        dish.setDishIngredients(dishIngredients);
        return dish;
    }

}
