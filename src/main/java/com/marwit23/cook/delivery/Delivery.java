package com.marwit23.cook.delivery;

import com.marwit23.cook._constants.DeliveryStatus;
import com.marwit23.cook.deliveryitem.DeliveryItem;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Getter @Setter
@Entity
public class Delivery {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long deliveryId;

    @Enumerated(EnumType.STRING)
    private DeliveryStatus deliveryStatus;
    private LocalDate deliveredDate;

    @OneToMany(mappedBy = "delivery")
    private List<DeliveryItem> deliveryItems;

}
