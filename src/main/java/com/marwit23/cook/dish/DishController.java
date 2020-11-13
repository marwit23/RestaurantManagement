package com.marwit23.cook.dish;

import com.marwit23.cook._exception.EntityNotFoundException;
import com.marwit23.cook.dish.dtos.DishDetailsDTO;
import com.marwit23.cook.dish.dtos.DishSimpleDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/dishes")
public class DishController {

    private DishService dishService;
    private DishMapper dishMapper;


    @Autowired
    public DishController(DishService dishService, DishMapper dishMapper) {
        this.dishService = dishService;
        this.dishMapper = dishMapper;
    }

    @GetMapping
    public List<DishSimpleDTO> findAll() {
        List<Dish> theDishes = dishService.findAll();
        return theDishes.stream()
                .map(dish -> dishMapper.convertToDtoSimple(dish))
                .collect(Collectors.toList());
    }

//    @GetMapping
//    public List<Dish> findAll(
//            @RequestParam(defaultValue = "0") Integer pageNo,
//            @RequestParam(defaultValue = "25") Integer pageSize,
//            @RequestParam(defaultValue = "dishId") String sortBy) {
//        return dishService.findAll(pageNo, pageSize, sortBy);
//    }

    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    public DishDetailsDTO addDish(@RequestBody DishDetailsDTO DishDetailsDTO) {
        Dish theDish = dishMapper.convertToEntity(DishDetailsDTO);
        dishService.save(theDish);
        return dishMapper.convertToDtoDetails(theDish);
    }

    @GetMapping("/{dishId}")
    public DishDetailsDTO findById(@PathVariable Long dishId) {
        Dish theDish = dishService.findById(dishId);
        DishDetailsDTO theDishDetailsDTO = dishMapper.convertToDtoDetails(theDish);
        if(theDish == null) throw new EntityNotFoundException("dish", dishId.toString());
        return theDishDetailsDTO;
    }

    @PutMapping("/{dishId}")
    @PreAuthorize("hasRole('ADMIN')")
    public DishDetailsDTO updateDish(@RequestBody DishDetailsDTO DishDetailsDTO, @PathVariable Long dishId) {
        Dish theDish = dishMapper.convertToEntity(DishDetailsDTO);
        theDish.setDishId(dishId);
        dishService.save(theDish);
        return dishMapper.convertToDtoDetails(theDish);
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
