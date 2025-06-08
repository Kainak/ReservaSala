package com.historicoservice.demo.dto;

import java.io.Serializable;
import java.time.LocalDateTime;

public class HistoricoDTO implements Serializable {
    private Integer salaId;
    private Integer usuarioId;
    private LocalDateTime dataHora;

    public HistoricoDTO() {
    }

    // Getters and Setters
    public Integer getSalaId() {
        return salaId;
    }

    public void setSalaId(Integer salaId) {
        this.salaId = salaId;
    }

    public Integer getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Integer usuarioId) {
        this.usuarioId = usuarioId;
    }


    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public void setDataHora(LocalDateTime dataHora) {
        this.dataHora = dataHora;
    }
} 