package com.marwit23.cook.ingredient;

import com.marwit23.cook._exception.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/ingredients")
public class IngredientController {

    private IngredientService ingredientService;
    private IngredientMapper ingredientMapper;

    @Autowired
    public IngredientController(IngredientService ingredientService, IngredientMapper ingredientMapper) {
        this.ingredientService = ingredientService;
        this.ingredientMapper = ingredientMapper;
    }

    @GetMapping
    public List<IngredientDTO> findAll(){
        List<Ingredient> theIngredients = ingredientService.findAll();
        return theIngredients.stream()
                .map(ingredient -> ingredientMapper.convertToDto(ingredient))
                .collect(Collectors.toList());
    }

//    @GetMapping
//    public List<Ingredient> findAllWithParams(
//            @RequestParam(defaultValue = "0") Integer pageNo,
//            @RequestParam(defaultValue = "25") Integer pageSize,
//            @RequestParam(defaultValue = "ingredientId") String sortBy) {
//        return ingredientService.findAllWithParams(pageNo, pageSize, sortBy);
//    }

    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    public IngredientDTO addIngredient(@RequestBody IngredientDTO ingredientDto) {
        Ingredient theIngredient = ingredientMapper.convertToEntity(ingredientDto);
        ingredientService.save(theIngredient);
        return ingredientMapper.convertToDto(theIngredient);
    }

    @GetMapping("/{ingredientId}")
    public IngredientDTO getIngredient(@PathVariable Long ingredientId) {
        Ingredient theIngredient = ingredientService.findById(ingredientId);
        IngredientDTO theIngredientDTO = ingredientMapper.convertToDto(theIngredient);
        if (theIngredient == null) throw new EntityNotFoundException("ingredient", ingredientId.toString());
        return theIngredientDTO;
    }

    @PutMapping("/{ingredientId}")
    @PreAuthorize("hasRole('ADMIN')")
    public IngredientDTO updateIngredient(@Valid @RequestBody IngredientDTO ingredientDto, @PathVariable Long ingredientId) {
        Ingredient theIngredient = ingredientMapper.convertToEntity(ingredientDto);
        theIngredient.setIngredientId(ingredientId);
        ingredientService.save(theIngredient);
        return ingredientMapper.convertToDto(theIngredient);
    }

    @DeleteMapping("/{ingredientId}")
    @PreAuthorize("hasRole('ADMIN')")
    public String deleteIngredient(@PathVariable Long ingredientId) {
        Ingredient theIngredient = ingredientService.findById(ingredientId);
        if (theIngredient == null) throw new EntityNotFoundException("ingredient", ingredientId.toString());
        ingredientService.deleteById(ingredientId);
        return "Deleted ingredient id - " + ingredientId;
    }
}
