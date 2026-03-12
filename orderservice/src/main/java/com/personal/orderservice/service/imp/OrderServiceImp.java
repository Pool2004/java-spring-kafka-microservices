package com.personal.orderservice.service.imp;
import org.springframework.stereotype.Service;
import com.personal.orderservice.service.IOrderService;

import lombok.RequiredArgsConstructor;

import com.personal.orderservice.repository.IOrderRepository;

import com.personal.orderservice.model.entity.OrderModel;
import com.personal.orderservice.event.event.OrderEvent;
import com.personal.orderservice.event.producer.OrderProducer;
import com.personal.orderservice.model.dto.OrderModelDTO;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class OrderServiceImp implements IOrderService {
    
    private final IOrderRepository orderRepository;
    private final OrderProducer orderProducer;

    @Override
    public String createOrder(String nameProduct, int quantity, String reference) {
        // Lógica para crear una orden
        // El orderId se genera automáticamente por Hibernate
        OrderModel order = new OrderModel();
        order.setNameProduct(nameProduct);
        order.setQuantity(quantity);
        order.setReference(reference);
        OrderModel savedOrder = orderRepository.save(order);

        final OrderEvent orderEvent = new OrderEvent();
        orderEvent.setReference(reference);
        orderEvent.setMessage("Order created with ID: " + savedOrder.getOrderId());

        // Enviar un evento a Kafka después de crear la orden
        orderProducer.sendMessage(orderEvent);

        return "Order created with ID: " + savedOrder.getOrderId();
    }

    @Override
    public List<OrderModelDTO> listOrders() {
        // Lógica para listar todas las órdenes
        List<OrderModel> orders = orderRepository.findAll();

        return orders.stream().map(order -> {
            OrderModelDTO orderDTO = new OrderModelDTO();
            orderDTO.setNameProduct(order.getNameProduct());
            orderDTO.setQuantity(order.getQuantity());
            return orderDTO;
        }).toList();
    }

    @Override
    public Optional<OrderModelDTO> getOrder(String orderId) {
        // Lógica para obtener una orden por su ID
        Optional<OrderModel> orderOpt = orderRepository.findById(orderId);
        if (orderOpt.isPresent()) {
            OrderModel order = orderOpt.get();
            OrderModelDTO orderDTO = new OrderModelDTO();
            orderDTO.setNameProduct(order.getNameProduct());
            orderDTO.setQuantity(order.getQuantity());
            return Optional.of(orderDTO);
        }
        return Optional.empty();
    }

        
    @Override
    public String updateOrder(String orderId, String nameProduct, int quantity) {
        // Lógica para actualizar una orden
        OrderModel order = orderRepository.findById(orderId).orElse(null);
        if (order != null) {
            order.setNameProduct(nameProduct);
            order.setQuantity(quantity);
            orderRepository.save(order);
            return "Order updated with ID: " + orderId;
        } else {
            return "Order not found with ID: " + orderId;
        }
    }

    @Override
    public String deleteOrder(String orderId) {
        // Lógica para eliminar una orden
        if (orderRepository.existsById(orderId)) {
            orderRepository.deleteById(orderId);
            return "Order deleted with ID: " + orderId;
        } else {
            return "Order not found with ID: " + orderId;
        }
    }
}
