package com.marwit23.cook.delivery;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.marwit23.cook._constants.DeliveryStatus;
import com.marwit23.cook._exception.DateNotValidException;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.List;

import static com.marwit23.cook._constants.DeliveryStatus.DELIVERED;
import static com.marwit23.cook._constants.DeliveryStatus.ORDERED;

@Getter
@Setter
@Entity
@EntityListeners(AuditingEntityListener.class)
public class Delivery {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long deliveryId;

    @CreatedDate
    @Column(updatable = false)
    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate orderedDate;

    @Transient
    @Enumerated(EnumType.STRING)
    private DeliveryStatus deliveryStatus;

    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate deliveredDate;

    @OneToMany(mappedBy = "delivery", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<DeliveryItem> deliveryItems;

    @PrePersist
    protected void onCreate() {
        setOrderedDate(LocalDate.now());
        checkDeliveredDate();
    }

    @PostLoad
    protected void onLoad() {
        getDeliveryStatus();
    }

    public DeliveryStatus getDeliveryStatus() {
        DeliveryStatus deliveryStatus;
        if (deliveredDate == null){
            deliveryStatus = ORDERED;
        } else {
            deliveryStatus = DELIVERED;
        }
        return deliveryStatus;
    }

    public void checkDeliveredDate() {

        if (deliveredDate!= null && deliveredDate.isBefore(orderedDate)) throw new DateNotValidException();
    }

    public void setDeliveryItems(List<DeliveryItem> deliveryItems) {
        this.deliveryItems = deliveryItems;
        for(DeliveryItem deliveryItem: this.deliveryItems) {
            deliveryItem.setDelivery(this);
        }
    }
}
