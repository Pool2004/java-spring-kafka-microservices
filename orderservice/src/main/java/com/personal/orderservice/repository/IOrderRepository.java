package com.personal.orderservice.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.personal.orderservice.model.entity.OrderModel;

@Repository
public interface IOrderRepository extends JpaRepository<OrderModel, String> {
    
}

