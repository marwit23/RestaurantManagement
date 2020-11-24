package com.marwit23.cook.delivery;

import com.marwit23.cook.delivery.dtos.DeliveryDetailsDTO;
import com.marwit23.cook.delivery.dtos.DeliveryItemDTO;
import com.marwit23.cook.delivery.dtos.DeliverySimpleDTO;
import com.marwit23.cook.ingredient.IngredientRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class DeliveryMapper {

    private ModelMapper modelMapper;
    private IngredientRepository ingredientRepository;

    public DeliveryMapper(ModelMapper modelMapper, IngredientRepository ingredientRepository) {
        this.modelMapper = modelMapper;
        this.ingredientRepository = ingredientRepository;
    }

    DeliverySimpleDTO convertToDtoSimple(Delivery delivery) {
        DeliverySimpleDTO deliverySimpleDTO = modelMapper.map(delivery, DeliverySimpleDTO.class);
        return deliverySimpleDTO;
    }

    DeliveryDetailsDTO convertToDtoDetails(Delivery delivery) {
        DeliveryDetailsDTO deliveryDetailsDTO = modelMapper.map(delivery, DeliveryDetailsDTO.class);
        deliveryDetailsDTO.setDeliveryItems(
                delivery.getDeliveryItems().stream()
                .map(deliveryItem -> modelMapper.map(deliveryItem, DeliveryItemDTO.class))
                .collect(Collectors.toList())
        );
        return deliveryDetailsDTO;
    }

    Delivery convertToEntity(DeliveryDetailsDTO deliveryDetailsDTO) {
        Delivery delivery = new Delivery();
        delivery.setDeliveredDate(deliveryDetailsDTO.getDeliveredDate());
        List<DeliveryItem> deliveryItems = new ArrayList<>();
        for (int i = 0; i < deliveryDetailsDTO.getDeliveryItems().size(); i++) {
            DeliveryItem tempDeliveryItem = new DeliveryItem();
            DeliveryItemDTO tempDeliveryItemDto = deliveryDetailsDTO.getDeliveryItems().get(i);
            tempDeliveryItem.setIngredient(ingredientRepository.findByIngredientName(tempDeliveryItemDto.getIngredientName()));
            tempDeliveryItem.setOrderedQuantity(tempDeliveryItemDto.getOrderedQuantity());
            tempDeliveryItem.setDeliveredQuantity(tempDeliveryItemDto.getDeliveredQuantity());
            tempDeliveryItem.setPricePerKg(tempDeliveryItemDto.getPricePerKg());
            deliveryItems.add(tempDeliveryItem);
        }
        delivery.setDeliveryItems(deliveryItems);
        return delivery;
    }
}
