package com.marwit23.cook.ingredient;

import com.marwit23.cook._configuration.SecurityConfig;
import com.marwit23.cook._exception.EntityNotFoundException;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.test.context.support.WithMockUser;

import static com.marwit23.cook._constants.IngredientCategory.FRUITS;
import static org.assertj.core.api.Assertions.assertThat;


@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class IngredientControllerIT {

    @Autowired
    private SecurityConfig securityConfig;
    @Autowired
    private IngredientController ingredientController;
    @Autowired
    private IngredientService ingredientService;


    // * POST METHOD----------------------------------------------------------------------------------------------------

    // * is not authorized
    @Test
    @Order(1)
    @WithMockUser(roles = "USER")
    public void testAddIngredient_NotAuthorized(){
        Ingredient newIngredient = new Ingredient();
        newIngredient.setIngredientName("testAddIngredient_NotAuthorized");
        newIngredient.setIngredientCategory(FRUITS);
        newIngredient.setShelfLife(10);
        Assertions.assertThrows(AccessDeniedException.class, ()-> ingredientController.addIngredient(newIngredient));
    }

    // * is authorized
    @Test
    @Order(2)
    @WithMockUser(roles = "ADMIN")
    public void testAddIngredient_Authorized(){
        Ingredient newIngredient = new Ingredient();
        newIngredient.setIngredientName("testAddIngredient_Authorized");
        newIngredient.setIngredientCategory(FRUITS);
        newIngredient.setShelfLife(10);
        ingredientController.addIngredient(newIngredient);
        Ingredient checkIngredient = ingredientService.findByName("testAddIngredient_Authorized");
        assertThat(checkIngredient.getIngredientName()).isEqualTo("testAddIngredient_Authorized");
    }

    // * UPDATE METHOD--------------------------------------------------------------------------------------------------

    // * is not authorized
    @Test
    @Order(3)
    @WithMockUser(roles = "USER")
    public void testUpdateIngredient_NotAuthorized(){
        Ingredient updateIngredient = ingredientService.findByName("testAddIngredient_Authorized");
        updateIngredient.setIngredientName("testUpdateIngredient_NotAuthorized");
        Assertions.assertThrows(AccessDeniedException.class, ()-> ingredientController.updateIngredient(updateIngredient, updateIngredient.getIngredientId()));
    }

    // * is authorized
    @Test
    @Order(4)
    @WithMockUser(roles = "ADMIN")
    public void testUpdateIngredient_Authorized(){
        Ingredient updateIngredient = ingredientService.findByName("testAddIngredient_Authorized");
        updateIngredient.setIngredientName("testUpdateIngredient_Authorized");
        ingredientController.updateIngredient(updateIngredient, updateIngredient.getIngredientId());
        assertThat(updateIngredient.getIngredientName()).isEqualTo("testUpdateIngredient_Authorized");
    }

    // * DELETE METHOD--------------------------------------------------------------------------------------------------

    // * is not authorized
    @Test
    @Order(5)
    @WithMockUser(roles = "USER")
    public void testDeleteIngredient_NotAuthorized(){
        Ingredient deleteIngredient = ingredientService.findByName("testUpdateIngredient_Authorized");
        Assertions.assertThrows(AccessDeniedException.class, ()-> ingredientController.deleteIngredient(deleteIngredient.getIngredientId()));
    }

    // * is authorized
    @Test
    @WithMockUser(roles = "ADMIN")
    public void testDeleteIngredient_Authorized(){
        Ingredient deleteIngredient = ingredientService.findByName("testUpdateIngredient_Authorized");
        ingredientController.deleteIngredient(deleteIngredient.getIngredientId());
        Assertions.assertThrows(EntityNotFoundException.class, () -> ingredientService.findByName("testUpdateIngredient_Authorized"));
    }
}
