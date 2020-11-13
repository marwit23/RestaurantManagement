package com.marwit23.cook.delivery.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DeliveryItemDTO {

    private long deliveryItemId;
    private String ingredientName;
    private int orderedQuantity;
    private int deliveredQuantity;
    private Double pricePerKg;
    private boolean isSafeToEat;
}
