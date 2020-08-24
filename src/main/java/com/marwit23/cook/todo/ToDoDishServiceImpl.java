package com.marwit23.cook.todo;

import com.marwit23.cook.dish.Dish;
import com.marwit23.cook.dish.DishRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ToDoDishServiceImpl implements ToDoDishService {

    private ToDoDishRepository toDoDishRepository;

    @Autowired
    public ToDoDishServiceImpl(ToDoDishRepository toDoDishRepository) {
        this.toDoDishRepository = toDoDishRepository;
    }

    @Override
    public List<ToDoDish> findAll() {
        return toDoDishRepository.findAll();
    }

    @Override
    public ToDoDish findById(Long toDoDishId) {
        Optional<ToDoDish> result = toDoDishRepository.findById(toDoDishId);

        ToDoDish theToDoDish = null;

        if(result.isPresent()){
            theToDoDish = result.get();
        } else {
            throw new RuntimeException("Didn't find Id -" +toDoDishId);
        }
        return theToDoDish;
    }

    @Override
    public void save(ToDoDish theToDoDish) {
        toDoDishRepository.save(theToDoDish);

    }

    @Override
    public void deleteById(Long toDoDishId) {
        toDoDishRepository.deleteById(toDoDishId);
    }
}
