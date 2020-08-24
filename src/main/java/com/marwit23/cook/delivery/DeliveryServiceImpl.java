package com.marwit23.cook.delivery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DeliveryServiceImpl implements DeliveryService{

    private DeliveryRepository deliveryRepository;

    @Autowired
    public DeliveryServiceImpl(DeliveryRepository deliveryRepository) {
        this.deliveryRepository = deliveryRepository;
    }

    @Override
    public List<Delivery> findAll() {
        return deliveryRepository.findAll() ;
    }

    @Override
    public Delivery findById(Long deliveryId) {
        Optional<Delivery> result = deliveryRepository.findById(deliveryId);

        Delivery theDelivery = null;

        if(result.isPresent()){
            theDelivery = result.get();
        } else {
            throw new RuntimeException("Didn't find Id - " + deliveryId);
        }
        return theDelivery;
    }

    @Override
    public void save(Delivery theDelivery) {
        deliveryRepository.save(theDelivery);
    }

    @Override
    public void deleteById(Long deliveryId) {
        deliveryRepository.deleteById(deliveryId);
    }
}
