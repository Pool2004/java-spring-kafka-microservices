package com.personal.inventoryservice.model.dto;

import jakarta.validation.Valid;
import lombok.Data;

@Valid
@Data
public class InventoryModelDTO {
    private String nameProduct;
    private int quantity;
    private String reference;
}
