package com.marwit23.cook.delivery;

import com.marwit23.cook._exception.EntityNotFoundException;
import com.marwit23.cook.delivery.dtos.DeliveryDetailsDTO;
import com.marwit23.cook.delivery.dtos.DeliverySimpleDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/deliveries")
public class DeliveryController {

    private DeliveryService deliveryService;
    private DeliveryMapper deliveryMapper;

    @Autowired
    public DeliveryController(DeliveryService deliveryService, DeliveryMapper deliveryMapper) {
        this.deliveryService = deliveryService;
        this.deliveryMapper = deliveryMapper;
    }

    @GetMapping
    public List<DeliverySimpleDTO> findAll() {
        List<Delivery> theDeliveries = deliveryService.findAll();
        return theDeliveries.stream()
                .map(delivery -> deliveryMapper.convertToDtoSimple(delivery))
                .collect(Collectors.toList());
    }

//    @GetMapping
//    public List<Delivery> findAllWithParams(
//            @RequestParam(defaultValue = "0") Integer pageNo,
//            @RequestParam(defaultValue = "25") Integer pageSize,
//            @RequestParam(defaultValue = "orderedDate") String sortBy) {
//        return deliveryService.findAll(pageNo, pageSize, sortBy);
//    }

    @PostMapping
    public DeliveryDetailsDTO addDelivery(@RequestBody DeliveryDetailsDTO deliveryDetailsDTO) {
        Delivery theDelivery = deliveryMapper.convertToEntity(deliveryDetailsDTO);
        deliveryService.save(theDelivery);
        return deliveryMapper.convertToDtoDetails(theDelivery);
    }

    @GetMapping("/{deliveryId}")
    public DeliveryDetailsDTO getDelivery(@PathVariable Long deliveryId) {
        Delivery theDelivery = deliveryService.findById(deliveryId);
        DeliveryDetailsDTO theDeliveryDetailsDTO = deliveryMapper.convertToDtoDetails(theDelivery);
        if (theDelivery == null) throw new EntityNotFoundException("delivery", deliveryId.toString());
        return theDeliveryDetailsDTO;
    }

    @PutMapping("/{deliveryId}")
    public DeliveryDetailsDTO updateDelivery(@RequestBody DeliveryDetailsDTO deliveryDetailsDTO, @PathVariable Long deliveryId) {
        Delivery theDelivery = deliveryMapper.convertToEntity(deliveryDetailsDTO);
        deliveryService.update(theDelivery, deliveryId);
        return deliveryMapper.convertToDtoDetails(theDelivery);
    }

    @DeleteMapping("/{deliveryId}")
    public String deleteById(@PathVariable Long deliveryId) {
        Delivery tempDelivery = deliveryService.findById(deliveryId);
        if (tempDelivery == null) throw new RuntimeException("Delivery id not found -" + deliveryId);
        deliveryService.deleteById(deliveryId);
        return "Deleted delivery id - " + deliveryId;
    }
}
