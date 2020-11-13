//package com.marwit23.cook.ingredient;
//
//import com.marwit23.cook._exception.EntityNotFoundException;
//import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.MockitoAnnotations;
//
//import java.util.Optional;
//
//import static org.mockito.ArgumentMatchers.anyLong;
//import static org.mockito.ArgumentMatchers.anyString;
//import static org.mockito.Mockito.when;
//
//public class IngredientServiceTest {
//
//    @InjectMocks
//    private IngredientServiceImpl ingredientService;
//    @Mock
//    private IngredientRepository ingredientRepository;
//
//    @BeforeEach
//    void setUp() throws Exception {
//        MockitoAnnotations.initMocks(this);
//    }
//
//    // * GET METHOD-----------------------------------------------------------------------------------------------------
//
//    // * item id does not exist
//    @Test
//    public void testFindById_DoesNotExist(){
//        when(ingredientRepository.findById(anyLong())).thenReturn(Optional.empty());
//        Assertions.assertThrows(EntityNotFoundException.class, ()-> ingredientService.findById((long) 1000));
//    }
//}
