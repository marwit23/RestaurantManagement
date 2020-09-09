package com.marwit23.cook.delivery;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.marwit23.cook.ingredient.Ingredient;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@Entity
public class DeliveryItem {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonIgnore
    private long deliveryItemId;

    @ManyToOne
    @JoinColumn(name = "ingredientId")
    @JsonIgnoreProperties({
            "ingredientCategory",
            "dishIngredients",
            "shelfLife",
            "deliveryItems",
    })
    private Ingredient ingredient;
    private int quantityGrams;
    private BigDecimal pricePerKg;

    @ManyToOne
    @JoinColumn(name = "deliveryId")
    @JsonIgnore
    public Delivery delivery;

    @Transient
    private boolean isSafeToEat;

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
