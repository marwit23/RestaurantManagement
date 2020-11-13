package com.marwit23.cook.delivery;

import com.marwit23.cook.ingredient.Ingredient;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class DeliveryItem {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long deliveryItemId;

    @ManyToOne
    @JoinColumn(name = "ingredientId")
    private Ingredient ingredient;
    private int orderedQuantity;
    private int deliveredQuantity;
    private Double pricePerKg;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "deliveryId")
    public Delivery delivery;

    @Transient
    private boolean isSafeToEat;

    public DeliveryItem(Ingredient ingredient, int orderedQuantity, Double pricePerKg, Delivery delivery) {
        this.ingredient = ingredient;
        this.orderedQuantity = orderedQuantity;
        this.pricePerKg = pricePerKg;
        this.delivery = delivery;
    }

    public DeliveryItem(Ingredient ingredient, int orderedQuantity, int deliveredQuantity, Double pricePerKg, Delivery delivery) {
        this.ingredient = ingredient;
        this.orderedQuantity = orderedQuantity;
        this.deliveredQuantity = deliveredQuantity;
        this.pricePerKg = pricePerKg;
        this.delivery = delivery;
    }


    @PostLoad
    protected void onLoad() {
        checkIsSafeToEat();
    }

    protected void checkIsSafeToEat() {
        if (delivery.getDeliveredDate() != null) {
            if (delivery.getDeliveredDate().plusDays(ingredient.getShelfLife()).isAfter(LocalDate.now().minusDays(1))) {
                isSafeToEat = true;
            } else {
                isSafeToEat = false;
            }
        }
    }
}
