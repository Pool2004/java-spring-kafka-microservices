package com.personal.inventoryservice.service.imp;
import com.personal.inventoryservice.repository.InventoryRepository;
import com.personal.inventoryservice.service.InventoryService;

import lombok.AllArgsConstructor;

import com.personal.inventoryservice.event.event.InventoryEvent;
import com.personal.inventoryservice.model.entity.InventoryModel;

import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class InventoryServiceImp implements InventoryService {

    private InventoryRepository inventoryRepository;

    @Override
    public void processOrderEvent(InventoryEvent inventoryEvent) {
        
        String referenceProduct = inventoryEvent.getReference();

        if(referenceProduct.isEmpty() || referenceProduct.isBlank()){
            inventoryEvent.setMessage("Reference is empty or blank");
        }

        // Obtener el producto del inventario utilizando el repositorio

        Optional<InventoryModel> productOptional = inventoryRepository.findByReference(referenceProduct);

        if(productOptional.isEmpty()){
            inventoryEvent.setMessage("Product not found in inventory");
            System.out.println("Product not found in inventory for reference: " + referenceProduct);
        } else {
            
            // Actualizar la cantidad del producto en el inventario
            inventoryEvent.setMessage("Inventory updated successfully");
            System.out.println("Inventory updated successfully for product reference: " + referenceProduct);
        }
        
    }
    
}
