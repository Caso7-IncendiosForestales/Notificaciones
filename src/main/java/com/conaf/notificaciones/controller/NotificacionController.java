package com.conaf.notificaciones.controller;

import com.conaf.notificaciones.model.Notificacion;
import com.conaf.notificaciones.repository.NotificacionRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;

import java.util.List;

@RestController
@RequestMapping("/api/notificaciones")
@Tag(name = "Alertas y Notificaciones")
public class NotificacionController {

    @Autowired
    private NotificacionRepository notificacionRepository;

    @Operation(summary = "Obtener el historial de alertas")
    @ApiResponse(responseCode = "200", description = "Historial de notificaciones despachadas obtenido exitosamente")
    @GetMapping
    public List<Notificacion> obtenerTodas() {
        return notificacionRepository.findAll();
    }

    @Operation(summary = "Despachar una nueva notificación de emergencia")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "201", description = "Notificación registrada y enviada exitosamente",
            content = @Content(mediaType = "application/json", 
            schema = @Schema(implementation = Notificacion.class),
            examples = @ExampleObject(
                name = "Ejemplo de Alerta Despachada",
                value = "{\"destinatario\": \"brigada.central@conaf.cl\", \"mensaje\": \"Alerta: Nuevo foco activo detectado en Sector Valparaíso.\", \"tipo\": \"EMAIL\", \"estado\": \"ENVIADO\"}"
            ))),
        @ApiResponse(responseCode = "400", description = "Falta de parámetros obligatorios o formato de destino incorrecto")
    })
    @PostMapping
    public ResponseEntity<Notificacion> crearNotificacion(@RequestBody Notificacion notificacion) {
        try {
            Notificacion nuevaNotificacion = notificacionRepository.save(notificacion);
            return new ResponseEntity<>(nuevaNotificacion, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}