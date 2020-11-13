//package com.marwit23.cook.ingredient;
//
//import com.marwit23.cook._configuration.SecurityConfig;
//import com.marwit23.cook._exception.EntityNotFoundException;
//import org.junit.jupiter.api.*;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.security.access.AccessDeniedException;
//import org.springframework.security.test.context.support.WithMockUser;
//
//import static com.marwit23.cook._constants.IngredientCategory.FRUITS;
//import static org.assertj.core.api.Assertions.assertThat;
//
//
//@SpringBootTest
//@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
//public class IngredientControllerIT {
//
//    @Autowired
//    private SecurityConfig securityConfig;
//    @Autowired
//    private IngredientController ingredientController;
//    @Autowired
//    private IngredientRepository ingredientRepository;
//    @Autowired
//    private IngredientMapper ingredientMapper;
//
//
//    // * POST METHOD----------------------------------------------------------------------------------------------------
//
//    // * is not authorized
//    @Test
//    @Order(1)
//    @WithMockUser(roles = "USER")
//    public void testAddIngredient_NotAuthorized(){
//        IngredientDTO newIngredient = new IngredientDTO();
//        newIngredient.setIngredientName("testAddIngredient_NotAuthorized");
//        newIngredient.setIngredientCategory(FRUITS);
//        newIngredient.setShelfLife(10);
//        Assertions.assertThrows(AccessDeniedException.class, ()-> ingredientController.addIngredient(newIngredient));
//    }
//
//    // * is authorized
//    @Test
//    @Order(2)
//    @WithMockUser(roles = "ADMIN")
//    public void testAddIngredient_Authorized(){
//        IngredientDTO newIngredient = new IngredientDTO();
//        newIngredient.setIngredientName("testAddIngredient_Authorized");
//        newIngredient.setIngredientCategory(FRUITS);
//        newIngredient.setShelfLife(10);
//        ingredientController.addIngredient(newIngredient);
//        Ingredient checkIngredient = ingredientRepository.findByIngredientName("testAddIngredient_Authorized");
//        assertThat(checkIngredient.getIngredientName()).isEqualTo("testAddIngredient_Authorized");
//    }
//
//    // * UPDATE METHOD--------------------------------------------------------------------------------------------------
//
//    // * is not authorized
//    @Test
//    @Order(3)
//    @WithMockUser(roles = "USER")
//    public void testUpdateIngredient_NotAuthorized(){
//        Ingredient updateIngredient = ingredientRepository.findByIngredientName("testAddIngredient_Authorized");
//        updateIngredient.setIngredientName("testUpdateIngredient_NotAuthorized");
//        IngredientDTO ingredientDTO = ingredientMapper.convertToDto(updateIngredient);
//        Assertions.assertThrows(AccessDeniedException.class, ()-> ingredientController.updateIngredient(ingredientDTO, updateIngredient.getIngredientId()));
//    }
//
//    // * is authorized
//    @Test
//    @Order(4)
//    @WithMockUser(roles = "ADMIN")
//    public void testUpdateIngredient_Authorized(){
//        Ingredient updateIngredient = ingredientRepository.findByIngredientName("testAddIngredient_Authorized");
//        updateIngredient.setIngredientName("testUpdateIngredient_Authorized");
//        IngredientDTO ingredientDTO = ingredientMapper.convertToDto(updateIngredient);
//        ingredientController.updateIngredient(ingredientDTO, updateIngredient.getIngredientId());
//        assertThat(ingredientDTO.getIngredientName()).isEqualTo("testUpdateIngredient_Authorized");
//    }
//
//    // * DELETE METHOD--------------------------------------------------------------------------------------------------
//
//    // * is not authorized
//    @Test
//    @Order(5)
//    @WithMockUser(roles = "USER")
//    public void testDeleteIngredient_NotAuthorized(){
//        Ingredient deleteIngredient = ingredientRepository.findByIngredientName("testUpdateIngredient_Authorized");
//        Assertions.assertThrows(AccessDeniedException.class, ()-> ingredientController.deleteIngredient(deleteIngredient.getIngredientId()));
//    }
//
//    // * is authorized
//    @Test
//    @WithMockUser(roles = "ADMIN")
//    public void testDeleteIngredient_Authorized(){
//        Ingredient deleteIngredient = ingredientRepository.findByIngredientName("testUpdateIngredient_Authorized");
//        ingredientController.deleteIngredient(deleteIngredient.getIngredientId());
//        Assertions.assertThrows(EntityNotFoundException.class, () -> ingredientController.getIngredient(deleteIngredient.getIngredientId()));
//    }
//}
