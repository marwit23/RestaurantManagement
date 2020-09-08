package com.marwit23.cook.delivery;

import com.marwit23.cook._exception.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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
    public List<Delivery> findAll(Integer pageNo, Integer pageSize, String sortBy) {
        Pageable pageable = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));
        Page<Delivery> deliveryPage = deliveryRepository.findAll(pageable);
        return deliveryPage.getContent();
    }

    @Override
    public Delivery findById(Long deliveryId) {
        Optional<Delivery> result = deliveryRepository.findById(deliveryId);
        Delivery theDelivery;
        if(result.isPresent()) theDelivery = result.get();
        else throw new EntityNotFoundException("delivery", deliveryId.toString());
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
