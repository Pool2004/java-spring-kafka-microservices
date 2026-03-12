package com.personal.inventoryservice.event.consumer;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import com.personal.inventoryservice.service.InventoryService;
import com.personal.inventoryservice.event.event.InventoryEvent;

import jakarta.persistence.criteria.CriteriaBuilder.In;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class InventoryConsumer {

    private final InventoryService inventoryService;


    @KafkaListener(topics = "order-created", groupId = "inventory-group")
    public void consume(String message) {
        inventoryService.processOrderEvent(InventoryEvent.builder()
            .nameProduct(message.split(",")[0])
            .quantity(Integer.parseInt(message.split(",")[1]))
            .message("Order created event received")
            .build());
    }
}
