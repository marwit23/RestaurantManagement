package com.marwit23.cook.ingredient;

import com.marwit23.cook._constants.IngredientCategory;
import com.marwit23.cook.delivery.DeliveryItem;
import com.marwit23.cook.dish.DishIngredient;
import com.marwit23.cook.todo.ToDoDish;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Range;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
    private int availableQuantity;

    @Transient
    private int expiredQuantity;

    @Transient
    private int usedQuantity;

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

    // * This is a fake update because all to-do's are new.
    // * Real calculations would be too big to perform on load
    // * SOLUTION: Persist into database and set a cron job to check expiration date for each item every day
    public void updateQuantity() {

        // * USED
        for (DishIngredient dishIngredient : dishIngredients) {
            for (ToDoDish toDoDish : dishIngredient.getDish().getToDoDishList()) {
                int tempDishQuantity = dishIngredient.getQuantityGrams() * toDoDish.getDishQuantity();
                usedQuantity += tempDishQuantity;
            }
        }

        // * ORDERED
        for (DeliveryItem deliveryItem : deliveryItems) {
            if (deliveryItem.getDelivery().getDeliveryStatus() == ORDERED) {
                orderedQuantity += deliveryItem.getOrderedQuantity();
            }
        }

        // *  AVAILABLE & EXPIRED
        int safeQuantity = 0;
        for (DeliveryItem deliveryItem : deliveryItems) {
            if (deliveryItem.getDelivery().getDeliveryStatus() == DELIVERED)
                if (deliveryItem.getDelivery().getDeliveredDate().plusDays(deliveryItem.getIngredient().getShelfLife()).isAfter(LocalDate.now().minusDays(1))
                ) {
                    safeQuantity += deliveryItem.getDeliveredQuantity();
                } else {
                    expiredQuantity += deliveryItem.getDeliveredQuantity();
                }
        }
        availableQuantity = safeQuantity - usedQuantity;

    }
}
