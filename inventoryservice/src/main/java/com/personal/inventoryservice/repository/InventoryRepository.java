package com.personal.inventoryservice.repository;
import com.personal.inventoryservice.model.entity.InventoryModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;
import java.util.List;

@Repository
public interface InventoryRepository extends JpaRepository<InventoryModel, String> {

    public Optional<InventoryModel> findByReference(String reference);
    public List<InventoryModel> findAll();
    
}
