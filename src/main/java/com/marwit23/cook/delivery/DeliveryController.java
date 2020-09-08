package com.marwit23.cook.delivery;

import com.marwit23.cook._exception.EntityNotFoundException;
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
    public List<Delivery> findAll(
            @RequestParam(defaultValue = "0") Integer pageNo,
            @RequestParam(defaultValue = "10") Integer pageSize,
            @RequestParam(defaultValue = "orderedDate") String sortBy) {
        return deliveryService.findAll(pageNo, pageSize, sortBy);
    }

    @PostMapping
    public Delivery addDelivery(@RequestBody Delivery theDelivery) {
        deliveryService.save(theDelivery);
        return theDelivery;
    }

    @GetMapping("/{deliveryId}")
    public Delivery getDelivery(@PathVariable Long deliveryId) {
        Delivery theDelivery = deliveryService.findById(deliveryId);
        if (theDelivery == null) throw new EntityNotFoundException("delivery", deliveryId.toString());
        return theDelivery;
    }

    @PutMapping("/{deliveryId}")
    public Delivery updateDelivery(@RequestBody Delivery theDelivery, @PathVariable Long deliveryId) {
        theDelivery.setDeliveryId(deliveryId);
        deliveryService.save(theDelivery);
        return theDelivery;
    }

    @DeleteMapping("/{deliveryId}")
    public String deleteById(@PathVariable Long deliveryId) {
        Delivery tempDelivery = deliveryService.findById(deliveryId);
        if (tempDelivery == null) throw new RuntimeException("Delivery id not found -" + deliveryId);
        deliveryService.deleteById(deliveryId);
        return "Deleted delivery id - " + deliveryId;
    }
}
