package com.personal.notificationservice.event.consumer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import com.personal.service.NotificacionService;

import lombok.AllArgsConstructor;



@AllArgsConstructor
@Component
public class NotificationConsumer {


    private final NotificacionService notificationService;

    @KafkaListener(topics = "order-created", groupId = "notification-group")
    public void consume(String message) {
        notificationService.processOrderEvent("Order created event received: " + message);
    }
    
}
