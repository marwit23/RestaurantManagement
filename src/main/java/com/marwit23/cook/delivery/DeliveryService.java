package com.marwit23.cook.delivery;

import java.util.List;

public interface DeliveryService {
    public List<Delivery> findAll();
    public List<Delivery> findAllWithParams(Integer pageNo, Integer pageSize, String sortBy);
    public Delivery findById(Long deliveryId);
    public void save(Delivery theDelivery);
    public void deleteById(Long deliveryId);
}
