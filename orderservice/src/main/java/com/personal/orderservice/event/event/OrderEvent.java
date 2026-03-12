package com.personal.orderservice.event.event;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class OrderEvent {
    private String message;
    private String reference;
}
