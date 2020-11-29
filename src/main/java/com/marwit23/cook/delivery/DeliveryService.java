package com.marwit23.cook.delivery;

import java.util.List;

public interface DeliveryService {
    List<Delivery> findAll();
    List<Delivery> findAllWithParams(Integer pageNo, Integer pageSize, String sortBy);
    Delivery findById(Long deliveryId);
    void save(Delivery theDelivery);
    void update(Delivery theDelivery, long deliveryId);
    void deleteById(Long deliveryId);
}
