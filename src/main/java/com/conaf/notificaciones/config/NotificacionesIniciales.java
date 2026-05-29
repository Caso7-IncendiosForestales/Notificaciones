package com.conaf.notificaciones.config;

import com.conaf.notificaciones.model.Notificacion;
import com.conaf.notificaciones.repository.NotificacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class NotificacionesIniciales implements CommandLineRunner {

    @Autowired
    private NotificacionRepository notificacionRepository;

    @Override
    public void run(String... args) throws Exception {
        // Valida la base de datos para cargar registros de auditoría iniciales
        if (notificacionRepository.count() == 0) {
            notificacionRepository.save(new Notificacion("contacto@conaf.cl", "Alerta de incendio activa en Sector Placilla", "EMAIL", LocalDateTime.now()));
            notificacionRepository.save(new Notificacion("+56912345678", "Brigada despachada a Sector Chiguayante", "SMS", LocalDateTime.now().minusMinutes(30)));
            System.out.println(">>> Persistencia: Datos iniciales de notificaciones cargados exitosamente.");
        }
    }
}