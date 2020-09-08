package com.marwit23.cook.dish;

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
public class DishServiceImpl implements DishService {

    private DishRepository dishRepository;

    @Autowired
    public DishServiceImpl(DishRepository dishRepository) {
        this.dishRepository = dishRepository;
    }

    @Override
    public List<Dish> findAll(Integer pageNo, Integer pageSize, String sortBy) {
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
        dishRepository.deleteById(dishId);
    }
}
