package com.marwit23.cook.dish;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DishServiceImpl implements DishService {

    private DishRepository dishRepository;

    @Autowired
    public DishServiceImpl(DishRepository dishRepository) {
        this.dishRepository = dishRepository;
    }

    @Override
    public List<Dish> findAll() {
        return dishRepository.findAll();
    }

    @Override
    public Dish findById(Long dishId) {
        Optional<Dish> result = dishRepository.findById(dishId);

        Dish theDish = null;

        if(result.isPresent()){
            theDish = result.get();
        } else {
            throw new RuntimeException("Didn't find Id -" + dishId);
        }
        return theDish;
    }

    @Override
    public void save(Dish theDish) {
        dishRepository.save(theDish);

    }

    @Override
    public void deleteById(Long dishId) {
        dishRepository.deleteById(dishId);
    }
}
