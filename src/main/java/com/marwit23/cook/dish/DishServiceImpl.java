package com.marwit23.cook.dish;

import com.marwit23.cook._exception.EntityNotFoundException;
import com.marwit23.cook.todo.ToDoDish;
import com.marwit23.cook.todo.ToDoDishRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DishServiceImpl implements DishService {

    private DishRepository dishRepository;
    private DishIngredientRepository dishIngredientRepository;
    private ToDoDishRepository toDoDishRepository;

    @Autowired
    public DishServiceImpl(DishRepository dishRepository, DishIngredientRepository dishIngredientRepository, ToDoDishRepository toDoDishRepository) {
        this.dishRepository = dishRepository;
        this.dishIngredientRepository = dishIngredientRepository;
        this.toDoDishRepository = toDoDishRepository;
    }

    @Override
    public List<Dish> findAll() {
        return dishRepository.findAll();
    }

    @Override
    public List<Dish> findAllWithParams(Integer pageNo, Integer pageSize, String sortBy) {
        Pageable pageable = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));
        Page<Dish> dishPage = dishRepository.findAll(pageable);
        return dishPage.getContent();
    }

    @Override
    public Dish findById(Long dishId) {
        Optional<Dish> result = dishRepository.findById(dishId);
        Dish theDish;
        if(result.isPresent())theDish = result.get();
        else throw new EntityNotFoundException("dish", dishId.toString());
        return theDish;
    }

    @Override
    public void save(Dish theDish) {
        dishRepository.save(theDish);
    }

    @Override
    public void deleteById(Long dishId) {
        Optional <Dish> result = dishRepository.findById(dishId);
        Dish theDish = new Dish();
        if(result.isPresent()) theDish = result.get();
            for(DishIngredient dishIngredient : theDish.getDishIngredients()){
                dishIngredient.setDish(null);
                dishIngredient.setIngredient(null);
                dishIngredientRepository.delete(dishIngredient);
            }
            for(ToDoDish toDoDish : theDish.getToDoDishList()){
                toDoDish.setDish(null);
                toDoDishRepository.delete(toDoDish);
            }
            dishRepository.deleteById(dishId);
    }
}
