package com.marwit23.cook.delivery;

import com.marwit23.cook._constants.DeliveryStatus;

import java.time.LocalDate;
import java.util.List;

public class DeliveryDTO {
    private long deliveryId;
    private LocalDate orderedDate;
    private DeliveryStatus deliveryStatus;
    private LocalDate deliveredDate;
    private List<String> items;

}
