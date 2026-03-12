package com.personal.orderservice.event.producer;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import com.personal.orderservice.event.event.OrderEvent;

@EnableKafka
@Component
public class OrderProducer {
    
    private final KafkaTemplate<String, OrderEvent> kafkaTemplate;
    
    public OrderProducer(KafkaTemplate<String, OrderEvent> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage(OrderEvent event) {
        kafkaTemplate.send("order-created", event);
    }
}
