package com.conaf.notificaciones;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@OpenAPIDefinition(
    info = @Info(
        title = "MS-10 Sistema de Notificaciones",
        version = "1.0.0",
        description = "Microservicio para el envío de alertas automáticas y mensajería en tiempo real a las brigadas y comunas afectadas - CONAF"
    )
)
@SpringBootApplication
public class NotificacionesApplication {

    public static void main(String[] args) {
        SpringApplication.run(NotificacionesApplication.class, args);
    }
}
