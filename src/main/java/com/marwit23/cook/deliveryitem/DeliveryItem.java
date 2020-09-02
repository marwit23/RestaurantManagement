package com.marwit23.cook.deliveryitem;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.marwit23.cook.ingredient.Ingredient;
import com.marwit23.cook.delivery.Delivery;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;

@Getter @Setter
@Entity
public class DeliveryItem {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long deliveryItemId;
    @OneToOne
    private Ingredient ingredient;
    private int deliveryQuantity;
    private BigDecimal pricePerKg;

    @Transient
    @JsonProperty
    private boolean isSafeToEat(){
        // ! if(getOrder().getDeliveredDate() > LocalDate.now())
        return true;
    };

    @ManyToOne
    @JoinColumn(name = "deliveryId")
    private Delivery delivery;

}
