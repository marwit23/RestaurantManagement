package com.marwit23.cook._data;

import com.marwit23.cook._constants.IngredientCategory;
import com.marwit23.cook._constants.ToDoStatus;
import com.marwit23.cook.delivery.Delivery;
import com.marwit23.cook.delivery.DeliveryItem;
import com.marwit23.cook.delivery.DeliveryRepository;
import com.marwit23.cook.dish.Dish;
import com.marwit23.cook.dish.DishIngredient;
import com.marwit23.cook.dish.DishRepository;
import com.marwit23.cook.ingredient.Ingredient;
import com.marwit23.cook.ingredient.IngredientRepository;
import com.marwit23.cook.todo.ToDoDish;
import com.marwit23.cook.todo.ToDoDishRepository;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

@Service
public class ApplicationDataLoader implements ApplicationRunner {

    private IngredientRepository ingredientRepository;
    private DeliveryRepository deliveryRepository;
    private DishRepository dishRepository;
    private ToDoDishRepository toDoDishRepository;

    public ApplicationDataLoader(IngredientRepository ingredientRepository, DeliveryRepository deliveryRepository, DishRepository dishRepository, ToDoDishRepository toDoDishRepository) {
        this.ingredientRepository = ingredientRepository;
        this.deliveryRepository = deliveryRepository;
        this.dishRepository = dishRepository;
        this.toDoDishRepository = toDoDishRepository;
    }


    @Override
    public void run(ApplicationArguments args) throws Exception {

        // * INGREDIENTS -----------------------------------------------------------------------------------------------

        ingredientRepository.save(new Ingredient("Flour",IngredientCategory.GRAINS, 180));
        ingredientRepository.save(new Ingredient("Bread", IngredientCategory.GRAINS, 5));
        ingredientRepository.save(new Ingredient("Pasta", IngredientCategory.GRAINS, 180));
        ingredientRepository.save(new Ingredient("Oats",IngredientCategory.GRAINS, 90));
        ingredientRepository.save(new Ingredient("Rice", IngredientCategory.GRAINS, 180));
        ingredientRepository.save(new Ingredient("Couscous", IngredientCategory.GRAINS, 180));
        ingredientRepository.save(new Ingredient("Breadcrumbs",IngredientCategory.GRAINS, 30));
        ingredientRepository.save(new Ingredient("Buckwheat", IngredientCategory.GRAINS, 180));
        ingredientRepository.save(new Ingredient("Cornmeal", IngredientCategory.GRAINS, 180));
        ingredientRepository.save(new Ingredient("Rye bread", IngredientCategory.GRAINS, 5));

        ingredientRepository.save(new Ingredient("Apple",IngredientCategory.FRUITS, 30));
        ingredientRepository.save(new Ingredient("Orange",IngredientCategory.FRUITS, 30));
        ingredientRepository.save(new Ingredient("Banana",IngredientCategory.FRUITS, 5));
        ingredientRepository.save(new Ingredient("Watermelon",IngredientCategory.FRUITS, 3));
        ingredientRepository.save(new Ingredient("Pear",IngredientCategory.FRUITS, 14));
        ingredientRepository.save(new Ingredient("Lemon",IngredientCategory.FRUITS, 60));
        ingredientRepository.save(new Ingredient("Avocado",IngredientCategory.FRUITS, 2));
        ingredientRepository.save(new Ingredient("Mango",IngredientCategory.FRUITS, 10));
        ingredientRepository.save(new Ingredient("Plum",IngredientCategory.FRUITS, 20));
        ingredientRepository.save(new Ingredient("Cherry",IngredientCategory.FRUITS, 3));

        ingredientRepository.save(new Ingredient("Milk",IngredientCategory.DAIRY, 14));
        ingredientRepository.save(new Ingredient("Cheddar cheese",IngredientCategory.DAIRY, 14));
        ingredientRepository.save(new Ingredient("Cottage cheese",IngredientCategory.DAIRY, 7));
        ingredientRepository.save(new Ingredient("Buttermilk",IngredientCategory.DAIRY, 7));
        ingredientRepository.save(new Ingredient("Yoghurt",IngredientCategory.DAIRY, 7));
        ingredientRepository.save(new Ingredient("Cream",IngredientCategory.DAIRY, 5));
        ingredientRepository.save(new Ingredient("Sour cream",IngredientCategory.DAIRY, 7));
        ingredientRepository.save(new Ingredient("Camembert",IngredientCategory.DAIRY, 3));
        ingredientRepository.save(new Ingredient("Goat cheese",IngredientCategory.DAIRY, 14));
        ingredientRepository.save(new Ingredient("Mozzarella",IngredientCategory.DAIRY, 30));

        ingredientRepository.save(new Ingredient("Tomato",IngredientCategory.VEGETABLES, 7));
        ingredientRepository.save(new Ingredient("Cucumber",IngredientCategory.VEGETABLES, 7));
        ingredientRepository.save(new Ingredient("Onion",IngredientCategory.VEGETABLES, 60));
        ingredientRepository.save(new Ingredient("Potato",IngredientCategory.VEGETABLES, 7));
        ingredientRepository.save(new Ingredient("Garlic cloves",IngredientCategory.VEGETABLES, 60));
        ingredientRepository.save(new Ingredient("Cabbage",IngredientCategory.VEGETABLES, 30));
        ingredientRepository.save(new Ingredient("Cauliflower",IngredientCategory.VEGETABLES, 7));
        ingredientRepository.save(new Ingredient("Iceberg lettuce",IngredientCategory.VEGETABLES, 3));
        ingredientRepository.save(new Ingredient("Carrot",IngredientCategory.VEGETABLES, 14));
        ingredientRepository.save(new Ingredient("Mushrooms",IngredientCategory.VEGETABLES, 7));

        ingredientRepository.save(new Ingredient("Chicken breast",IngredientCategory.MEAT, 3));
        ingredientRepository.save(new Ingredient("Ribeye steak",IngredientCategory.MEAT, 21));
        ingredientRepository.save(new Ingredient("Pork loin",IngredientCategory.MEAT, 5));
        ingredientRepository.save(new Ingredient("Sausage",IngredientCategory.MEAT, 30));
        ingredientRepository.save(new Ingredient("Pork mince",IngredientCategory.MEAT, 3));
        ingredientRepository.save(new Ingredient("Beef mince",IngredientCategory.MEAT, 3));
        ingredientRepository.save(new Ingredient("Liver",IngredientCategory.MEAT, 2));
        ingredientRepository.save(new Ingredient("Bacon",IngredientCategory.MEAT, 30));
        ingredientRepository.save(new Ingredient("Ham",IngredientCategory.MEAT, 7));
        ingredientRepository.save(new Ingredient("Salami",IngredientCategory.MEAT, 30));

        ingredientRepository.save(new Ingredient("Olive oil",IngredientCategory.FATS, 180));
        ingredientRepository.save(new Ingredient("Canola oil",IngredientCategory.FATS, 180));
        ingredientRepository.save(new Ingredient("Butter",IngredientCategory.FATS, 30));
        ingredientRepository.save(new Ingredient("Lard",IngredientCategory.FATS, 30));
        ingredientRepository.save(new Ingredient("Duck fat",IngredientCategory.FATS, 180));
        ingredientRepository.save(new Ingredient("Coconut oil",IngredientCategory.FATS, 180));
        ingredientRepository.save(new Ingredient("Margarine",IngredientCategory.FATS, 180));
        ingredientRepository.save(new Ingredient("Sunflower oil",IngredientCategory.FATS, 180));
        ingredientRepository.save(new Ingredient("Sesame oil",IngredientCategory.FATS, 180));
        ingredientRepository.save(new Ingredient("Truffle oil",IngredientCategory.FATS, 180));


        ingredientRepository.save(new Ingredient("Salt",IngredientCategory.SPICES, 180));
        ingredientRepository.save(new Ingredient("Sugar",IngredientCategory.SPICES, 180));
        ingredientRepository.save(new Ingredient("Vinegar",IngredientCategory.SPICES, 180));
        ingredientRepository.save(new Ingredient("Black pepper",IngredientCategory.SPICES, 180));
        ingredientRepository.save(new Ingredient("Garlic powder",IngredientCategory.SPICES, 180));
        ingredientRepository.save(new Ingredient("Chili powder",IngredientCategory.SPICES, 180));
        ingredientRepository.save(new Ingredient("Thyme",IngredientCategory.SPICES, 180));
        ingredientRepository.save(new Ingredient("Oregano",IngredientCategory.SPICES, 180));
        ingredientRepository.save(new Ingredient("Cinnamon powder",IngredientCategory.SPICES, 180));
        ingredientRepository.save(new Ingredient("Nutmeg",IngredientCategory.SPICES, 180));



        // * DISHES-----------------------------------------------------------------------------------------------------

        DishIngredient dishIngredient1 = new DishIngredient(ingredientRepository.findByIngredientName("Ribeye steak"), 300);
        DishIngredient dishIngredient2 = new DishIngredient(ingredientRepository.findByIngredientName("Canola Oil"), 30);
        DishIngredient dishIngredient3 = new DishIngredient(ingredientRepository.findByIngredientName("Butter"), 30);
        DishIngredient dishIngredient4 = new DishIngredient(ingredientRepository.findByIngredientName("Salt"), 10);
        DishIngredient dishIngredient5 = new DishIngredient(ingredientRepository.findByIngredientName("Pepper"), 3);
        DishIngredient dishIngredient6 = new DishIngredient(ingredientRepository.findByIngredientName("Potatoes"), 300);
        DishIngredient dishIngredient7 = new DishIngredient(ingredientRepository.findByIngredientName("Iceberg lettuce"), 100);

        List<DishIngredient> dishIngredientList1 = Arrays.asList(
                dishIngredient1,
                dishIngredient2,
                dishIngredient3,
                dishIngredient4,
                dishIngredient5,
                dishIngredient6,
                dishIngredient7
        );
        Dish dish1 = new Dish("Ribeye Steak with Mashed Potatoes", dishIngredientList1);
        for (DishIngredient dishIngredient : dishIngredientList1){
            dishIngredient.setDish(dish1);
        }
        dishRepository.save(dish1);

        DishIngredient dishIngredient11 = new DishIngredient(ingredientRepository.findByIngredientName("Pasta"), 125);
        DishIngredient dishIngredient12 = new DishIngredient(ingredientRepository.findByIngredientName("Beef mince"), 200);
        DishIngredient dishIngredient13 = new DishIngredient(ingredientRepository.findByIngredientName("Tomato"), 300);
        DishIngredient dishIngredient14 = new DishIngredient(ingredientRepository.findByIngredientName("Garlic cloves"), 10);
        DishIngredient dishIngredient15 = new DishIngredient(ingredientRepository.findByIngredientName("Olive oil"), 30);
        DishIngredient dishIngredient16 = new DishIngredient(ingredientRepository.findByIngredientName("Salt"), 10);
        DishIngredient dishIngredient17 = new DishIngredient(ingredientRepository.findByIngredientName("Sugar"), 20);
        DishIngredient dishIngredient18 = new DishIngredient(ingredientRepository.findByIngredientName("Oregano"), 5);
        List<DishIngredient> dishIngredientList2 = Arrays.asList(
                dishIngredient11,
                dishIngredient12,
                dishIngredient13,
                dishIngredient14,
                dishIngredient15,
                dishIngredient16,
                dishIngredient17,
                dishIngredient18
        );
        Dish dish2 = new Dish("Spaghetti Bolognese", dishIngredientList2);
        for (DishIngredient dishIngredient : dishIngredientList2){
            dishIngredient.setDish(dish2);
        }
        dishRepository.save(dish2);

        DishIngredient dishIngredient21 = new DishIngredient(ingredientRepository.findByIngredientName("Pasta"), 125);
        DishIngredient dishIngredient22 = new DishIngredient(ingredientRepository.findByIngredientName("Tomato"), 300);
        DishIngredient dishIngredient23 = new DishIngredient(ingredientRepository.findByIngredientName("Chili powder"), 10);
        DishIngredient dishIngredient24 = new DishIngredient(ingredientRepository.findByIngredientName("Garlic cloves"), 10);
        DishIngredient dishIngredient25 = new DishIngredient(ingredientRepository.findByIngredientName("Olive oil"), 30);
        DishIngredient dishIngredient26 = new DishIngredient(ingredientRepository.findByIngredientName("Salt"), 10);
        DishIngredient dishIngredient27 = new DishIngredient(ingredientRepository.findByIngredientName("Sugar"), 5);
        List<DishIngredient> dishIngredientList3 = Arrays.asList(
                dishIngredient21,
                dishIngredient22,
                dishIngredient23,
                dishIngredient24,
                dishIngredient25,
                dishIngredient26,
                dishIngredient27
        );
        Dish dish3 = new Dish("Penne Arrabiatta", dishIngredientList3);
        for (DishIngredient dishIngredient : dishIngredientList3){
            dishIngredient.setDish(dish3);
        }
        dishRepository.save(dish3);

        DishIngredient dishIngredient31 = new DishIngredient(ingredientRepository.findByIngredientName("Iceberg lettuce"), 100);
        DishIngredient dishIngredient32 = new DishIngredient(ingredientRepository.findByIngredientName("Chicken breast"), 100);
        DishIngredient dishIngredient33 = new DishIngredient(ingredientRepository.findByIngredientName("Tomato"), 50);
        DishIngredient dishIngredient34 = new DishIngredient(ingredientRepository.findByIngredientName("Bread"), 30);
        DishIngredient dishIngredient35 = new DishIngredient(ingredientRepository.findByIngredientName("Olive oil"), 30);
        DishIngredient dishIngredient36 = new DishIngredient(ingredientRepository.findByIngredientName("Salt"), 10);
        DishIngredient dishIngredient37 = new DishIngredient(ingredientRepository.findByIngredientName("Sugar"), 5);
        DishIngredient dishIngredient38 = new DishIngredient(ingredientRepository.findByIngredientName("Vinegar"), 5);
        List<DishIngredient> dishIngredientList4 = Arrays.asList(
                dishIngredient31,
                dishIngredient32,
                dishIngredient33,
                dishIngredient34,
                dishIngredient35,
                dishIngredient36,
                dishIngredient37,
                dishIngredient38
        );
        Dish dish4 = new Dish("Chicken salad", dishIngredientList4);
        for (DishIngredient dishIngredient : dishIngredientList4){
            dishIngredient.setDish(dish4);
        }
        dishRepository.save(dish4);

        DishIngredient dishIngredient41 = new DishIngredient(ingredientRepository.findByIngredientName("Onion"), 500);
        DishIngredient dishIngredient42 = new DishIngredient(ingredientRepository.findByIngredientName("Mozzarella"), 50);
        DishIngredient dishIngredient43 = new DishIngredient(ingredientRepository.findByIngredientName("Bread"), 30);
        DishIngredient dishIngredient44 = new DishIngredient(ingredientRepository.findByIngredientName("Butter"), 50);
        DishIngredient dishIngredient45 = new DishIngredient(ingredientRepository.findByIngredientName("Salt"), 10);
        DishIngredient dishIngredient46 = new DishIngredient(ingredientRepository.findByIngredientName("Black pepper"), 5);
        DishIngredient dishIngredient47 = new DishIngredient(ingredientRepository.findByIngredientName("Garlic cloves"), 10);
        List<DishIngredient> dishIngredientList5 = Arrays.asList(
                dishIngredient41,
                dishIngredient42,
                dishIngredient43,
                dishIngredient44,
                dishIngredient45,
                dishIngredient46,
                dishIngredient47
        );
        Dish dish5 = new Dish("French Onion Soup", dishIngredientList5);
        for (DishIngredient dishIngredient : dishIngredientList5){
            dishIngredient.setDish(dish5);
        }
        dishRepository.save(dish5);

        DishIngredient dishIngredient51 = new DishIngredient(ingredientRepository.findByIngredientName("Flour"), 100);
        DishIngredient dishIngredient52 = new DishIngredient(ingredientRepository.findByIngredientName("Potato"), 150);
        DishIngredient dishIngredient53 = new DishIngredient(ingredientRepository.findByIngredientName("Cottage cheese"), 100);
        DishIngredient dishIngredient54 = new DishIngredient(ingredientRepository.findByIngredientName("Butter"), 30);
        DishIngredient dishIngredient55 = new DishIngredient(ingredientRepository.findByIngredientName("Salt"), 10);
        DishIngredient dishIngredient56 = new DishIngredient(ingredientRepository.findByIngredientName("Black pepper"), 5);
        DishIngredient dishIngredient57 = new DishIngredient(ingredientRepository.findByIngredientName("Onion"), 30);
        List<DishIngredient> dishIngredientList6 = Arrays.asList(
                dishIngredient51,
                dishIngredient52,
                dishIngredient53,
                dishIngredient54,
                dishIngredient55,
                dishIngredient56,
                dishIngredient57
        );
        Dish dish6 = new Dish("Russian Pierogi", dishIngredientList6);
        for (DishIngredient dishIngredient : dishIngredientList6){
            dishIngredient.setDish(dish6);
        }
        dishRepository.save(dish6);

        DishIngredient dishIngredient61 = new DishIngredient(ingredientRepository.findByIngredientName("Beef mince"), 100);
        DishIngredient dishIngredient62 = new DishIngredient(ingredientRepository.findByIngredientName("Onion"), 20);
        DishIngredient dishIngredient63 = new DishIngredient(ingredientRepository.findByIngredientName("Butter"), 30);
        DishIngredient dishIngredient64 = new DishIngredient(ingredientRepository.findByIngredientName("Salt"), 5);
        DishIngredient dishIngredient65 = new DishIngredient(ingredientRepository.findByIngredientName("Black pepper"), 3);
        List<DishIngredient> dishIngredientList7 = Arrays.asList(
                dishIngredient61,
                dishIngredient62,
                dishIngredient63,
                dishIngredient64,
                dishIngredient65
        );
        Dish dish7 = new Dish("Steak Tartare", dishIngredientList7);
        for (DishIngredient dishIngredient : dishIngredientList7){
            dishIngredient.setDish(dish7);
        }
        dishRepository.save(dish7);

        DishIngredient dishIngredient71 = new DishIngredient(ingredientRepository.findByIngredientName("Pork loin"), 200);
        DishIngredient dishIngredient72 = new DishIngredient(ingredientRepository.findByIngredientName("Flour"), 50);
        DishIngredient dishIngredient73 = new DishIngredient(ingredientRepository.findByIngredientName("Breadcrumbs"), 50);
        DishIngredient dishIngredient74 = new DishIngredient(ingredientRepository.findByIngredientName("Milk"), 50);
        DishIngredient dishIngredient75 = new DishIngredient(ingredientRepository.findByIngredientName("Canola oil"), 50);
        DishIngredient dishIngredient76 = new DishIngredient(ingredientRepository.findByIngredientName("Salt"), 5);
        DishIngredient dishIngredient77 = new DishIngredient(ingredientRepository.findByIngredientName("Black pepper"), 3);
        List<DishIngredient> dishIngredientList8 = Arrays.asList(
                dishIngredient71,
                dishIngredient72,
                dishIngredient73,
                dishIngredient74,
                dishIngredient75,
                dishIngredient76,
                dishIngredient77
        );
        Dish dish8 = new Dish("Breaded Pork Chop with French Fries", dishIngredientList8);
        for (DishIngredient dishIngredient : dishIngredientList8){
            dishIngredient.setDish(dish8);
        }
        dishRepository.save(dish8);

        DishIngredient dishIngredient81 = new DishIngredient(ingredientRepository.findByIngredientName("Chicken breast"), 200);
        DishIngredient dishIngredient82 = new DishIngredient(ingredientRepository.findByIngredientName("Cream"), 100);
        DishIngredient dishIngredient83 = new DishIngredient(ingredientRepository.findByIngredientName("Mushrooms"), 100);
        DishIngredient dishIngredient84 = new DishIngredient(ingredientRepository.findByIngredientName("Garlic cloves"), 10);
        DishIngredient dishIngredient85 = new DishIngredient(ingredientRepository.findByIngredientName("Butter"), 50);
        DishIngredient dishIngredient86 = new DishIngredient(ingredientRepository.findByIngredientName("Salt"), 5);
        DishIngredient dishIngredient87 = new DishIngredient(ingredientRepository.findByIngredientName("Black pepper"), 3);
        List<DishIngredient> dishIngredientList9 = Arrays.asList(
                dishIngredient81,
                dishIngredient82,
                dishIngredient83,
                dishIngredient84,
                dishIngredient85,
                dishIngredient86,
                dishIngredient87
        );
        Dish dish9 = new Dish("Chicken Breast in Mushroom Sauce", dishIngredientList9);
        for (DishIngredient dishIngredient : dishIngredientList9){
            dishIngredient.setDish(dish9);
        }
        dishRepository.save(dish9);

        DishIngredient dishIngredient91 = new DishIngredient(ingredientRepository.findByIngredientName("Sausage"), 200);
        DishIngredient dishIngredient92 = new DishIngredient(ingredientRepository.findByIngredientName("Onion"), 200);
        DishIngredient dishIngredient93 = new DishIngredient(ingredientRepository.findByIngredientName("Canola oil"), 50);
        DishIngredient dishIngredient94 = new DishIngredient(ingredientRepository.findByIngredientName("Salt"), 2);
        List<DishIngredient> dishIngredientList10 = Arrays.asList(
                dishIngredient91,
                dishIngredient92,
                dishIngredient93,
                dishIngredient94
        );
        Dish dish10 = new Dish("Grilled Sausage with Onion", dishIngredientList10);
        for (DishIngredient dishIngredient : dishIngredientList10){
            dishIngredient.setDish(dish10);
        }
        dishRepository.save(dish10);



        // * DELIVERIES-------------------------------------------------------------------------------------------------

        Delivery delivery1 = new Delivery();
        delivery1.setOrderedDate(LocalDate.now().minusDays(12));
        delivery1.setDeliveredDate(LocalDate.now().minusDays(10));
        Delivery delivery2 = new Delivery();
        delivery2.setOrderedDate(LocalDate.now().minusDays(5));
        delivery2.setDeliveredDate(LocalDate.now().minusDays(3));
        Delivery delivery3 = new Delivery();

        DeliveryItem deliveryItem1 = new DeliveryItem(
                ingredientRepository.findByIngredientName("Flour"),
                5000,
                5000,
                1.97,
                delivery1
        );
        DeliveryItem deliveryItem2 = new DeliveryItem(
                ingredientRepository.findByIngredientName("Bread"),
                2000,
                2200,
                2.30,
                delivery1
        );
        DeliveryItem deliveryItem3 = new DeliveryItem(
                ingredientRepository.findByIngredientName("Milk"),
                2000,
                2000,
                2.50,
                delivery1
        );
        DeliveryItem deliveryItem4 = new DeliveryItem(
                ingredientRepository.findByIngredientName("Potato"),
                5000,
                5000,
                1.50,
                delivery1
        );
        DeliveryItem deliveryItem5 = new DeliveryItem(
                ingredientRepository.findByIngredientName("Tomato"),
                2000,
                2000,
                3.50,
                delivery1
        );
        DeliveryItem deliveryItem5a = new DeliveryItem(
                ingredientRepository.findByIngredientName("Cream"),
                200,
                200,
                9.50,
                delivery1
        );
        DeliveryItem deliveryItem5b = new DeliveryItem(
                ingredientRepository.findByIngredientName("Butter"),
                2000,
                2000,
                19.00,
                delivery1
        );
        DeliveryItem deliveryItem6 = new DeliveryItem(
                ingredientRepository.findByIngredientName("Pasta"),
                5000,
                5000,
                1.85,
                delivery2
        );
        DeliveryItem deliveryItem7 = new DeliveryItem(
                ingredientRepository.findByIngredientName("Canola oil"),
                3000,
                3000,
                4.99,
                delivery2
        );
        DeliveryItem deliveryItem8 = new DeliveryItem(
                ingredientRepository.findByIngredientName("Olive oil"),
                2000,
                2000,
                8.99,
                delivery2
        );
        DeliveryItem deliveryItem9 = new DeliveryItem(
                ingredientRepository.findByIngredientName("Beef mince"),
                2000,
                2000,
                28.99,
                delivery2
        );
        DeliveryItem deliveryItem10 = new DeliveryItem(
                ingredientRepository.findByIngredientName("Chicken breast"),
                2000,
                2000,
                17.99,
                delivery2
        );
        DeliveryItem deliveryItem11 = new DeliveryItem(
                ingredientRepository.findByIngredientName("Onion"),
                3000,
                3000,
                3.99,
                delivery2
        );
        DeliveryItem deliveryItem12 = new DeliveryItem(
                ingredientRepository.findByIngredientName("Garlic cloves"),
                100,
                120,
                120.0,
                delivery2
        );
        DeliveryItem deliveryItem13 = new DeliveryItem(
                ingredientRepository.findByIngredientName("Sausage"),
                2000,
                2100,
                20.99,
                delivery2
        );
        DeliveryItem deliveryItem14 = new DeliveryItem(
                ingredientRepository.findByIngredientName("Salt"),
                1000,
                1000,
                2.99,
                delivery2
        );
        DeliveryItem deliveryItem15 = new DeliveryItem(
                ingredientRepository.findByIngredientName("Black pepper"),
                100,
                100,
                20.99,
                delivery2
        );
        DeliveryItem deliveryItem16 = new DeliveryItem(
                ingredientRepository.findByIngredientName("Mozzarella"),
                1000,
                20.99,
                delivery3
        );
        DeliveryItem deliveryItem17 = new DeliveryItem(
                ingredientRepository.findByIngredientName("Oregano"),
                100,
                89.99,
                delivery3
        );
        DeliveryItem deliveryItem18 = new DeliveryItem(
                ingredientRepository.findByIngredientName("Breadcrumbs"),
                1000,
                3.99,
                delivery3
        );
        DeliveryItem deliveryItem19 = new DeliveryItem(
                ingredientRepository.findByIngredientName("Pork loin"),
                2000,
                16.99,
                delivery3
        );
        DeliveryItem deliveryItem20 = new DeliveryItem(
                ingredientRepository.findByIngredientName("Cottage cheese"),
                1000,
                12.99,
                delivery3
        );

        List<DeliveryItem> deliveryItemList1 = Arrays.asList(
                deliveryItem1,
                deliveryItem2,
                deliveryItem3,
                deliveryItem4,
                deliveryItem5,
                deliveryItem5a,
                deliveryItem5b
        );
        List<DeliveryItem> deliveryItemList2 = Arrays.asList(
                deliveryItem6,
                deliveryItem7,
                deliveryItem8,
                deliveryItem9,
                deliveryItem10,
                deliveryItem11,
                deliveryItem12,
                deliveryItem13,
                deliveryItem14,
                deliveryItem15
        );
        List<DeliveryItem> deliveryItemList3 = Arrays.asList(
                deliveryItem16,
                deliveryItem17,
                deliveryItem18,
                deliveryItem19,
                deliveryItem20
        );

        delivery1.setDeliveryItems(deliveryItemList1);
        delivery2.setDeliveryItems(deliveryItemList2);
        delivery3.setDeliveryItems(deliveryItemList3);

        deliveryRepository.save(delivery1);
        deliveryRepository.save(delivery2);
        deliveryRepository.save(delivery3);



        // * TO-DO-DISHES---------------------------------------------------------------------------------------------------

        ToDoDish toDoDish1 = new ToDoDish(
                dish10,
                LocalDate.now(),
                ToDoStatus.PENDING
        );

        toDoDishRepository.save(toDoDish1);

        ToDoDish toDoDish2 = new ToDoDish(
                dish9,
                LocalDate.now(),
                ToDoStatus.PENDING
        );

        toDoDishRepository.save(toDoDish2);

        ToDoDish toDoDish3 = new ToDoDish(
                dish7,
                LocalDate.now(),
                ToDoStatus.PENDING
        );

        toDoDishRepository.save(toDoDish3);
    }
}
