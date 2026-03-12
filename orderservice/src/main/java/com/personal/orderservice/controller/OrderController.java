package com.personal.orderservice.controller;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;
import java.util.List;
import java.util.Optional;

// Importamos el modelo
import com.personal.orderservice.model.entity.OrderModel;
import com.personal.orderservice.model.dto.OrderModelDTO;

// Importar la interfaz de la implementación del servicio
import com.personal.orderservice.service.IOrderService;

import lombok.RequiredArgsConstructor;









@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class OrderController {

    private final IOrderService orderService;

    @GetMapping("/test")
    public ResponseEntity<String> testEndPoint(){
        return ResponseEntity.status(HttpStatus.OK).body("message: Order Service is up and running");
    }

    @PostMapping("/create/order")
    public ResponseEntity<String> createOrder(@RequestBody OrderModel order) {
        return ResponseEntity.status(HttpStatus.CREATED).body(orderService.createOrder(order.getNameProduct(), order.getQuantity(), order.getReference()));
    }

    @GetMapping("/get/orders")
    public ResponseEntity<List<OrderModelDTO>> getOrders() {
        return ResponseEntity.status(HttpStatus.OK).body(orderService.listOrders());
    }

    @GetMapping("/get/order/{id}")
    public ResponseEntity<Optional<OrderModelDTO>> getOrderById(@PathVariable String id) {
        return ResponseEntity.status(HttpStatus.OK).body(orderService.getOrder(id));
    }
    
    
    
    
}
