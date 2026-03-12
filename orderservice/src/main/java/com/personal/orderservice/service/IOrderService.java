package com.personal.orderservice.service;

import java.util.List;
import com.personal.orderservice.model.entity.OrderModel;
import com.personal.orderservice.model.dto.OrderModelDTO;
import java.util.Optional;

public interface IOrderService {
    // Definir métodos para la lógica de negocio relacionada con las órdenes


    public String createOrder(String nameProduct, int quantity, String reference);

    public Optional<OrderModelDTO> getOrder(String orderId);

    public String updateOrder(String orderId, String nameProduct, int quantity);

    public String deleteOrder(String orderId);

    public List<OrderModelDTO> listOrders();

}
