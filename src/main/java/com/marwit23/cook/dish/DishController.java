package com.marwit23.cook.dish;

import com.marwit23.cook._exception.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/dishes")
public class DishController {

    private DishService dishService;

    @Autowired
    public DishController(DishService dishService) {
        this.dishService = dishService;
    }

    @GetMapping
    public List<Dish> findAll(
            @RequestParam(defaultValue = "0") Integer pageNo,
            @RequestParam(defaultValue = "25") Integer pageSize,
            @RequestParam(defaultValue = "dishId") String sortBy) {
        return dishService.findAll(pageNo, pageSize, sortBy);
    }

    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    public Dish addDish(@RequestBody Dish theDish) {
        dishService.save(theDish);
        return theDish;
    }

    @GetMapping("/{dishId}")
    public Dish findById(@PathVariable Long dishId) {
        Dish theDish = dishService.findById(dishId);
        if(theDish == null) throw new EntityNotFoundException("dish", dishId.toString());
        return theDish;
    }

    @PutMapping("/{dishId}")
    @PreAuthorize("hasRole('ADMIN')")
    public Dish updateDish(@RequestBody Dish theDish, @PathVariable Long dishId) {
        theDish.setDishId(dishId);
        dishService.save(theDish);
        return theDish;
    }

    @DeleteMapping("/{dishId}")
    @PreAuthorize("hasRole('ADMIN')")
    public String deleteById(@PathVariable Long dishId) {
        Dish tempDish = dishService.findById(dishId);
        if(tempDish == null) throw new RuntimeException("Dish id not found -" + dishId);
        dishService.deleteById(dishId);
        return "Deleted dish id - " + dishId;
    }
}
