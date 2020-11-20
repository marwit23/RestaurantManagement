package com.marwit23.cook.delivery;

import com.marwit23.cook._constants.DeliveryStatus;
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
    private DeliveryItemRepository deliveryItemRepository;

    @Autowired
    public DeliveryServiceImpl(DeliveryRepository deliveryRepository, DeliveryItemRepository deliveryItemRepository) {
        this.deliveryRepository = deliveryRepository;
        this.deliveryItemRepository = deliveryItemRepository;
    }

    @Override
    public List<Delivery> findAll() {
        return deliveryRepository.findAll(Sort.by(Sort.Direction.DESC, "deliveryId"));
    }

    @Override
    public List<Delivery> findAllWithParams(Integer pageNo, Integer pageSize, String sortBy) {
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
    public void save(Delivery theDelivery) { deliveryRepository.save(theDelivery); }

    @Override
    public void update(Delivery theDelivery, long deliveryId) {
        Optional<Delivery> result = deliveryRepository.findById(deliveryId);
        Delivery tempDelivery = null;
        if(result.isPresent()) tempDelivery = result.get();
        theDelivery.setDeliveryId(deliveryId);
        theDelivery.setOrderedDate(tempDelivery.getOrderedDate());
        deliveryRepository.save(theDelivery);
    }

    @Override
    public void deleteById(Long deliveryId) {
        Optional <Delivery> result = deliveryRepository.findById(deliveryId);
        Delivery theDelivery = new Delivery();
        if(result.isPresent()) theDelivery = result.get();
        if(theDelivery.getDeliveryStatus() == DeliveryStatus.ORDERED) {
            for(DeliveryItem deliveryItem : theDelivery.getDeliveryItems()){
                deliveryItem.setDelivery(null);
                deliveryItem.setIngredient(null);
                deliveryItemRepository.delete(deliveryItem);
            }
            deliveryRepository.deleteById(deliveryId);
        } else {
            throw new RuntimeException("Cannot delete Delivery with status: delivered");
        }


    }
}
