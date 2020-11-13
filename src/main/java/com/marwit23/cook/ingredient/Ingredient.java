package com.marwit23.cook.ingredient;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.marwit23.cook._constants.IngredientCategory;
import com.marwit23.cook.delivery.DeliveryItem;
import com.marwit23.cook.dish.Dish;
import com.marwit23.cook.dish.DishIngredient;
import com.marwit23.cook.todo.ToDoDish;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Range;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

import static com.marwit23.cook._constants.DeliveryStatus.DELIVERED;
import static com.marwit23.cook._constants.DeliveryStatus.ORDERED;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Ingredient {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long ingredientId;

    @Column(unique = true)
    @NotNull(message = "ingredient name cannot be null")
    private String ingredientName;

    @Enumerated(EnumType.STRING)
    @NotNull(message = "ingredient category cannot be null")
    private IngredientCategory ingredientCategory;

    @NotNull(message = "shelf life cannot be null")
    @Range(min = 1, max = 180, message = "shelf life must be between 1 and 180 days")
    private int shelfLife;

    @OneToMany(mappedBy = "ingredient")
    private List<DishIngredient> dishIngredients;

    @OneToMany(mappedBy = "ingredient", cascade = CascadeType.ALL)
    private List<DeliveryItem> deliveryItems;

    @Transient
    private int totalQuantity;

    @Transient
    private int safeQuantity;

    @Transient
    private int expiredQuantity;

    @Transient
    private int orderedQuantity;


    public Ingredient(String ingredientName, IngredientCategory ingredientCategory, int shelfLife) {
        this.ingredientName = ingredientName;
        this.ingredientCategory = ingredientCategory;
        this.shelfLife = shelfLife;
    }

    @PostLoad
    protected void onLoad() {
        updateQuantity();
    }


    public void updateQuantity() {
        for (DeliveryItem deliveryItem : deliveryItems) {
            if (deliveryItem.delivery.getDeliveryStatus() == ORDERED) {
                orderedQuantity = orderedQuantity + deliveryItem.getOrderedQuantity();
            } else if (deliveryItem.delivery.getDeliveryStatus() == DELIVERED) {
                totalQuantity = totalQuantity + deliveryItem.getDeliveredQuantity();
            }
        }
        for (DeliveryItem deliveryItem : deliveryItems) {
            if (deliveryItem.isSafeToEat()) {
                safeQuantity = safeQuantity + deliveryItem.getDeliveredQuantity();
            }
        }

        for(DishIngredient dishIngredient: dishIngredients){
            for (ToDoDish toDoDish : dishIngredient.getDish().getToDoDishList()){
                    safeQuantity -= dishIngredient.getQuantityGrams();
            }
        }

        expiredQuantity = (orderedQuantity - safeQuantity);

    }
}
