package com.marwit23.cook.delivery;

import com.marwit23.cook.delivery.DeliveryItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DeliveryItemRepository extends JpaRepository<DeliveryItem, Long> {
}
