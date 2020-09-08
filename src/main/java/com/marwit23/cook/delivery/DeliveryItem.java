package com.marwit23.cook.delivery;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.marwit23.cook.ingredient.Ingredient;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Parent;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Getter @Setter
@Entity
public class DeliveryItem {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long deliveryItemId;

    @ManyToOne
    @JoinColumn (name = "ingredientId")
    @JsonIgnoreProperties("dishIngredients")
    private Ingredient ingredient;
    private int deliveryQuantityGrams;
    private BigDecimal pricePerKg;

    @ManyToOne
    @JoinColumn(name = "deliveryId")
    @JsonIgnore
    public Delivery delivery;

    @Transient
    private boolean isSafeToEat;

    @PostLoad
    protected void onLoad(){
        checkIsSafeToEat();
    }

    protected void checkIsSafeToEat(){
        if(delivery.getDeliveredDate().plusDays(ingredient.getShelfLife()).isAfter(LocalDate.now().plusDays(1))) {
            isSafeToEat = true;
        } else {
            isSafeToEat = false;
        }
    }
}
