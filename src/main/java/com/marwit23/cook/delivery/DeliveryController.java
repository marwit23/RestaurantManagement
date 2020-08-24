package com.marwit23.cook.delivery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/deliveries")
public class DeliveryController {

    private DeliveryService deliveryService;

    @Autowired
    public DeliveryController(DeliveryService deliveryService) {
        this.deliveryService = deliveryService;
    }

    @GetMapping
    public List<Delivery> findAll() {
        return deliveryService.findAll();
    }

    @GetMapping("/{deliveryId}")
    public Delivery findById(@PathVariable Long deliveryId) {
        Delivery theDelivery = deliveryService.findById(deliveryId);

        if(theDelivery == null){
            throw new RuntimeException("Delivery id not found - " + deliveryId);
        }
        return theDelivery;
    }

    @PostMapping
    public Delivery addDelivery(@RequestBody Delivery theDelivery) {
        theDelivery.setDeliveryId(0);
        deliveryService.save(theDelivery);
        return theDelivery;
    }

    @PutMapping
    public Delivery updateDelivery(@RequestBody Delivery theDelivery) {
        deliveryService.save(theDelivery);
        return theDelivery;
    }

    @DeleteMapping("/{deliveryId}")
    public String deleteById(@PathVariable Long deliveryId) {
        Delivery tempDelivery = deliveryService.findById(deliveryId);

        if(tempDelivery == null){
            throw new RuntimeException("Delivery id not found -" + deliveryId);
        }
        deliveryService.deleteById(deliveryId);
        return "Deleted delivery id - " + deliveryId;
    }
}
