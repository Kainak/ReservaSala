package com.reservaservice.demo.application.service;

import com.reservaservice.demo.domain.model.Reserva;
import com.reservaservice.demo.infrastructure.repository.ReservaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReservaService {
    @Autowired
    private ReservaRepository repository;

    public List<Reserva> listar() {
        return repository.findAll();
    }

    public Reserva salvar(Reserva reserva) {
        Optional<Reserva> reservaExistente = repository.findBySalaIdAndDataHora(reserva.getSalaId(), reserva.getDataHora());

        if (reservaExistente.isPresent()) {
            throw new IllegalStateException("Já existe uma reserva para esta sala neste horário.");
            
        }
        
        return repository.save(reserva);
    }
}