package com.conaf.notificaciones.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "notificaciones")
public class Notificacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String destinatario; // Email o teléfono del contacto

    @Column(nullable = false)
    private String mensaje;

    @Column(nullable = false)
    private String tipo; // EJEMPLO: EMAIL, SMS, PUSH

    @Column(name = "fecha_envio", nullable = false)
    private LocalDateTime fechaEnvio;

    // Constructor vacío requerido por JPA
    public Notificacion() {}

    // Constructor sobrecargado para inicialización de datos
    public Notificacion(String destinatario, String mensaje, String tipo, LocalDateTime fechaEnvio) {
        this.destinatario = destinatario;
        this.mensaje = mensaje;
        this.tipo = tipo;
        this.fechaEnvio = fechaEnvio;
    }

    // Getters y Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getDestinatario() { return destinatario; }
    public void setDestinatario(String destinatario) { this.destinatario = destinatario; }

    public String getMensaje() { return mensaje; }
    public void setMensaje(String mensaje) { this.mensaje = mensaje; }

    public String getTipo() { return tipo; }
    public void setTipo(String tipo) { this.tipo = tipo; }

    public LocalDateTime getFechaEnvio() { return fechaEnvio; }
    public void setFechaEnvio(LocalDateTime fechaEnvio) { this.fechaEnvio = fechaEnvio; }
}