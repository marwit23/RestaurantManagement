package com.marwit23.cook.delivery;

import java.util.List;

public interface DeliveryService {
    List<Delivery> findAll(Integer pageNo, Integer pageSize, String sortBy);
    Delivery findById(Long deliveryId);
    void save(Delivery theDelivery);
    void deleteById(Long deliveryId);
}
