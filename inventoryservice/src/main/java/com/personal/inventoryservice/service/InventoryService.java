package com.personal.inventoryservice.service;

import com.personal.inventoryservice.event.event.InventoryEvent;
import com.personal.inventoryservice.model.dto.InventoryModelDTO;
import java.util.Optional;

public interface InventoryService {

    public void processOrderEvent(InventoryEvent inventoryEvent);


}