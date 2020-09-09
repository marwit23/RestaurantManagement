package com.marwit23.cook.ingredient;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.dao.DataIntegrityViolationException;

import javax.validation.ConstraintViolationException;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import static com.marwit23.cook._constants.IngredientCategory.FRUITS;
import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@DataJpaTest
public class IngredientRepositoryTest {

    @Autowired
    private TestEntityManager testEntityManager;
    @Autowired
    private IngredientRepository ingredientRepository;

    // * GET METHOD-----------------------------------------------------------------------------------------------------

    // * correct all items
    @Test
    public void testFindAllIngredients(){
        List<Ingredient> allIngredients = ingredientRepository.findAll();
        assertThat(allIngredients).isNotEmpty();
    }

    // * correct single item
    @Test
    public void testFindById(){
        Optional<Ingredient> result = ingredientRepository.findById((long) 1);
        Ingredient ingredient = result.get();
        assertThat(ingredient.getIngredientName()).isEqualTo("Flour");
    }

    @Test
    public void testFindByIngredientName(){
        Optional<Ingredient> result = ingredientRepository.findByIngredientName("Flour");
        Ingredient ingredient = result.get();
        assertThat(ingredient.getIngredientName()).isEqualTo("Flour");
    }

    // * item id does not exist
    @Test
    public void testFindByIdDoesNotExist(){
        Assertions.assertThrows(NoSuchElementException.class, ()->{
            Optional<Ingredient> result = ingredientRepository.findById((long) 1000);
            result.get();
        });
    }

    // * POST METHOD----------------------------------------------------------------------------------------------------

    // * correct
    @Test
    public void testPostNewIngredient(){
        Ingredient newIngredient = new Ingredient();
        newIngredient.setIngredientName("testPostNewIngredient");
        newIngredient.setIngredientCategory(FRUITS);
        newIngredient.setShelfLife(21);
        ingredientRepository.save(newIngredient);
        Optional<Ingredient> result = ingredientRepository.findByIngredientName("testPostNewIngredient");
        Ingredient checkIngredient = result.get();
        assertEquals(newIngredient.getIngredientId(), checkIngredient.getIngredientId());
    }

    // * name already exists
    @Test
    public void testAddIngredient_NameAlreadyExists(){
        Ingredient newIngredient = new Ingredient();
        newIngredient.setIngredientName("Flour");
        newIngredient.setIngredientCategory(FRUITS);
        newIngredient.setShelfLife(10);
        Assertions.assertThrows(DataIntegrityViolationException.class, ()-> ingredientRepository.save(newIngredient));
    }

    // * shelfLife is not valid
    @Test
    public void testAddIngredient_ShelfLifeIsNotValid(){
        Ingredient newIngredient = new Ingredient();
        newIngredient.setIngredientName("testAddIngredientWhenShelfLifeIsNotValid");
        newIngredient.setIngredientCategory(FRUITS);
        newIngredient.setShelfLife(300);
        Assertions.assertThrows(ConstraintViolationException.class, ()-> ingredientRepository.save(newIngredient));
    }

    // * any parameter is null
    @Test
    public void testAddIngredient_NotNullIsNull(){
        Ingredient newIngredient = new Ingredient();
        Assertions.assertThrows(ConstraintViolationException.class, ()-> ingredientRepository.save(newIngredient));
    }

    // * PUT METHOD-----------------------------------------------------------------------------------------------------

    // * correct
    @Test
    public void testUpdateIngredient(){
        Optional<Ingredient> result = ingredientRepository.findById((long) 1);
        Ingredient oldIngredient = result.get();
        oldIngredient.setIngredientName("testUpdateIngredient");
        ingredientRepository.save(oldIngredient);
        Optional<Ingredient> resultAfterUpdate = ingredientRepository.findById((long) 1);
        Ingredient updatedIngredient = resultAfterUpdate.get();
        assertThat(updatedIngredient.getIngredientName()).isEqualTo("testUpdateIngredient");
    }

    // * DELETE METHOD--------------------------------------------------------------------------------------------------

    // * correct
    @Test
    public void testDeleteIngredient(){
        ingredientRepository.deleteById((long) 1);
        assertThat(ingredientRepository.findById((long) 1)).isEmpty();
    }
}
