package com.personal.orderservice.model.dto;

import jakarta.validation.Valid;
import lombok.Data;

@Valid
@Data
public class OrderModelDTO {
    private String nameProduct;
    private int quantity;
}

