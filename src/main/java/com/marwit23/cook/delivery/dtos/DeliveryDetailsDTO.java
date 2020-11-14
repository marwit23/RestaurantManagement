package com.marwit23.cook.delivery.dtos;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.marwit23.cook._constants.DeliveryStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DeliveryDetailsDTO {

    private long id;
    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate orderedDate;
    private DeliveryStatus deliveryStatus;
    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate deliveredDate;
    private List<DeliveryItemDTO> deliveryItems;
}
