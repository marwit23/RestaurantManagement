//package com.marwit23.cook.delivery;
//
//import com.marwit23.cook._exception.DateNotValidException;
//import com.marwit23.cook.ingredient.Ingredient;
//import com.marwit23.cook.ingredient.IngredientRepository;
//import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
//import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
//import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
//
//import javax.validation.ConstraintViolationException;
//import java.time.LocalDate;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.NoSuchElementException;
//import java.util.Optional;
//
//import static org.assertj.core.api.Assertions.assertThat;
//import static org.mockito.Mockito.when;
//
//@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
//@DataJpaTest
//public class DeliveryRepositoryTest {
//
//    @Autowired
//    private TestEntityManager testEntityManager;
//    @Autowired
//    private DeliveryRepository deliveryRepository;
//    @Autowired
//    private IngredientRepository ingredientRepository;
//
//    private Delivery testDelivery;
//    private DeliveryItem testDeliveryItem;
//    private Ingredient testIngredient;
//
//    // * GET METHOD-----------------------------------------------------------------------------------------------------
//
//    // * correct all items
//    @Test
//    public void testFindAllDeliveries() {
//        List<Delivery> allDeliveries = deliveryRepository.findAll();
//        assertThat(allDeliveries).isNotEmpty();
//    }
//
//    // * correct single item
//    @Test
//    public void testFindById() {
//        Optional<Delivery> result = deliveryRepository.findById((long) 3);
//        assert (result).isPresent();
//    }
//
//    // * item id does not exist
//    @Test
//    public void testFindByIdDoesNotExist() {
//        Assertions.assertThrows(NoSuchElementException.class, () -> {
//            Optional<Delivery> result = deliveryRepository.findById((long) 1000);
//            result.get();
//        });
//    }
//
//    // * POST METHOD----------------------------------------------------------------------------------------------------
//
//    // * correct
//    @Test
//    public void testPostNewDelivery() {
//        testDelivery = new Delivery();
//        testDeliveryItem = new DeliveryItem();
//        List<DeliveryItem> testDeliveryItemList = new ArrayList<>();
//        testDeliveryItemList.add(testDeliveryItem);
//        testDelivery.setDeliveryItems(testDeliveryItemList);
//        deliveryRepository.save(testDelivery);
//        Assertions.assertNotNull(deliveryRepository.save(testDelivery));
//    }
//
//    // * deliveredDate is valid
//    @Test
//    public void testAddDelivery_DeliveredDateIsValid() {
//        testDelivery = new Delivery();
//        testDelivery.setDeliveredDate(LocalDate.now());
//        testDeliveryItem = new DeliveryItem();
//        List<DeliveryItem> testDeliveryItemList = new ArrayList<>();
//        testDeliveryItemList.add(testDeliveryItem);
//        testDelivery.setDeliveryItems(testDeliveryItemList);
//        deliveryRepository.save(testDelivery);
//        Assertions.assertNotNull(deliveryRepository.save(testDelivery));
//    }
//
//    // * deliveredDate is not valid
//    @Test
//    public void testSetDeliveryDate_DeliveredDateIsNotValid() {
//        Delivery newDelivery = new Delivery();
//        newDelivery.setDeliveredDate(LocalDate.of(2020, 9, 5));
//        Assertions.assertThrows(DateNotValidException.class, () -> deliveryRepository.save(newDelivery));
//    }
//
//    // * deliveryItems is null
//    @Test
//    public void testAddDelivery_DeliveryItemsIsNull() {
//        Delivery newDelivery = new Delivery();
//        Assertions.assertThrows(ConstraintViolationException.class, () -> deliveryRepository.save(newDelivery));
//    }
//
//    // * OTHER METHODS--------------------------------------------------------------------------------------------------
//
//
//    // * check is safe to eat when delivered date is null
//    @Test
//    public void testIsSafeToEat_DeliveredDateIsNull() {
//        testDelivery = new Delivery();
//        testDeliveryItem = new DeliveryItem();
//        testIngredient = new Ingredient();
//        testDeliveryItem.setDelivery(testDelivery);
//        testDeliveryItem.checkIsSafeToEat();
//        Assertions.assertFalse(testDeliveryItem.isSafeToEat());
//    }
//
//    // * check is safe to eat when true
//    @Test
//    public void testIsSafeToEat_true() {
//        testDelivery = new Delivery();
//        testDeliveryItem = new DeliveryItem();
//        testIngredient = new Ingredient();
//        testDeliveryItem.setDelivery(testDelivery);
//        testDeliveryItem.setIngredient(testIngredient);
//        testDelivery.setDeliveredDate(LocalDate.now().minusDays(5));
//        testIngredient.setShelfLife(10);
//        testDeliveryItem.checkIsSafeToEat();
//        Assertions.assertTrue(testDeliveryItem.isSafeToEat());
//    }
//
//    // * check is safe to eat when true and last day
//    @Test
//    public void testisSafeToEat_true_lastDay() {
//        testDelivery = new Delivery();
//        testDeliveryItem = new DeliveryItem();
//        testIngredient = new Ingredient();
//        testDeliveryItem.setDelivery(testDelivery);
//        testDeliveryItem.setIngredient(testIngredient);
//        testDelivery.setDeliveredDate(LocalDate.now().minusDays(5));
//        testIngredient.setShelfLife(5);
//        testDeliveryItem.checkIsSafeToEat();
//        Assertions.assertTrue(testDeliveryItem.isSafeToEat());
//    }
//
//    // * check is safe to eat when false
//    @Test
//    public void testIsSafeToEat_false() {
//        testDelivery = new Delivery();
//        testDeliveryItem = new DeliveryItem();
//        testIngredient = new Ingredient();
//        testDeliveryItem.setDelivery(testDelivery);
//        testDeliveryItem.setIngredient(testIngredient);
//        testDelivery.setDeliveredDate(LocalDate.now().minusDays(6));
//        testIngredient.setShelfLife(5);
//        testDeliveryItem.checkIsSafeToEat();
//        Assertions.assertFalse(testDeliveryItem.isSafeToEat());
//    }
//}
//
