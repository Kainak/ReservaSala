package com.reservaservice.demo.domain.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Reserva {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime dataHora;

    @JsonProperty("sala_id")
    @Column(name = "sala_id")
    private Integer salaId;
    
    @JsonProperty("usuario_id")
    @Column(name = "usuario_id")
    private Integer usuarioId;
}