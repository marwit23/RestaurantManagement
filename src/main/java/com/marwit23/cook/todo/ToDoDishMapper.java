package com.marwit23.cook.todo;

import com.marwit23.cook.dish.Dish;
import com.marwit23.cook.dish.DishRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class ToDoDishMapper {

    private ModelMapper modelMapper;
    private DishRepository dishRepository;

    public ToDoDishMapper(ModelMapper modelMapper, DishRepository dishRepository) {
        this.modelMapper = modelMapper;
        this.dishRepository = dishRepository;
    }

    ToDoDishDTO convertToDto(ToDoDish toDoDish) {
        ToDoDishDTO toDoDishDto = modelMapper.map(toDoDish, ToDoDishDTO.class);
        return toDoDishDto;
    }

    ToDoDish convertToEntity(ToDoDishDTO toDoDishDTO) {
        ToDoDish toDoDish = new ToDoDish();
        Dish dish = dishRepository.findByDishName(toDoDishDTO.getDishName());
        toDoDish.setDish(dish);
        toDoDish.setDishQuantity(toDoDishDTO.getDishQuantity());
        toDoDish.setToDoDate(toDoDishDTO.getToDoDate());
        toDoDish.setToDoStatus(toDoDishDTO.getToDoStatus());
        return toDoDish;
    }
}
