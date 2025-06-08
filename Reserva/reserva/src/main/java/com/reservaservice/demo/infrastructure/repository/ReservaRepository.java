package com.reservaservice.demo.infrastructure.repository;

import com.reservaservice.demo.domain.model.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.Optional;

public interface ReservaRepository extends JpaRepository<Reserva, Long> {
    Optional<Reserva> findBySalaIdAndDataHora(Integer salaId, LocalDateTime dataHora);
}