package com.personal.inventoryservice.event.event;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class InventoryEvent {
    private String nameProduct;
    private int quantity;
    private String message;
    private String reference;
}
