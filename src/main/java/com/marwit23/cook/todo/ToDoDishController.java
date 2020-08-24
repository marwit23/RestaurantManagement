package com.marwit23.cook.todo;

import com.marwit23.cook.dish.Dish;
import com.marwit23.cook.ingredient.Ingredient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/to-do-dishes")
public class ToDoDishController {

    private ToDoDishService toDoDishService;

    @Autowired
    public ToDoDishController(ToDoDishService toDoDishService) {
        this.toDoDishService = toDoDishService;
    }

    @GetMapping
    public List<ToDoDish> findAll() {
        return toDoDishService.findAll();
    }

    @GetMapping("/{toDoDishId}")
    public ToDoDish findById(@PathVariable Long toDoDishId) {
        ToDoDish theToDoDish = toDoDishService.findById(toDoDishId);

        if(theToDoDish == null){
            throw new RuntimeException("To-do-dish Id not found - " + toDoDishId);
        }

        return theToDoDish;
    }

    @PostMapping
    public ToDoDish addToDoDish(@RequestBody ToDoDish theToDoDish) {
        theToDoDish.setToDoDishId(0);
        toDoDishService.save(theToDoDish);
        return theToDoDish;
    }

    @PutMapping
    public ToDoDish updateToDoDish(@RequestBody ToDoDish theToDoDish) {
        toDoDishService.save(theToDoDish);
        return theToDoDish;
    }

    @DeleteMapping("/{toDoDishId}")
    public String deleteById(@PathVariable Long toDoDishId) {
        ToDoDish tempToDoDish = toDoDishService.findById(toDoDishId);

        if(tempToDoDish == null){
            throw new RuntimeException("To-do-dish Id not found - " + toDoDishId);
        }
        toDoDishService.deleteById(toDoDishId);
        return "Deleted to-do-dish id - " + toDoDishId;
    }
}
