package com.marwit23.cook.delivery;

import com.marwit23.cook.ingredient.Ingredient;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.PositiveOrZero;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class DeliveryItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long deliveryItemId;

    @ManyToOne
    @JoinColumn(name = "ingredientId")
    private Ingredient ingredient;

    @PositiveOrZero
    private int orderedQuantity;

    @PositiveOrZero
    private int deliveredQuantity;

    @PositiveOrZero
    private Double pricePerKg;

    @ManyToOne
    @JoinColumn(name = "deliveryId")
    private Delivery delivery;

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
}
