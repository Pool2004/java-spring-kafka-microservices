package com.personal.service.imp;
import org.springframework.stereotype.Service;

import com.personal.service.NotificacionService;

@Service
public class NotificationServiceImp implements NotificacionService {

    @Override
    public void processOrderEvent(String message) {
        // Aquí puedes implementar la lógica para procesar el evento de orden
        System.out.println("Processing order event: " + message);
    }
    
}
