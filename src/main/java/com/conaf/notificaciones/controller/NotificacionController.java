package com.conaf.notificaciones.controller;

import com.conaf.notificaciones.model.Notificacion;
import com.conaf.notificaciones.repository.NotificacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/notificaciones")
@CrossOrigin(origins = "*") // Habilita el intercambio de recursos de origen cruzado (CORS)
public class NotificacionController {

    @Autowired
    private NotificacionRepository notificacionRepository;

    // Obtener el historial de todas las notificaciones
    @GetMapping
    public List<Notificacion> getAllNotificaciones() {
        return notificacionRepository.findAll();
    }

    // Registrar el envío de una nueva notificación
    @PostMapping
    public ResponseEntity<Notificacion> createNotificacion(@RequestBody Notificacion notificacion) {
        Notificacion nuevaNotificacion = notificacionRepository.save(notificacion);
        return ResponseEntity.ok(nuevaNotificacion);
    }
}