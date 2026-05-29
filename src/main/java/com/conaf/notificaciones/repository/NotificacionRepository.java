package com.conaf.notificaciones.repository;

import com.conaf.notificaciones.model.Notificacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NotificacionRepository extends JpaRepository<Notificacion, Long> {
    // Proporciona los métodos CRUD estándar de persistencia
}