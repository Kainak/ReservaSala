package com.reservaservice.demo.application.service;

import com.reservaservice.demo.config.RabbitMQConfig;
import com.reservaservice.demo.domain.model.Reserva;
import com.reservaservice.demo.dto.HistoricoDTO;
import com.reservaservice.demo.infrastructure.repository.ReservaRepository;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReservaService {
    @Autowired
    private ReservaRepository repository;
    
    @Autowired
    private RabbitTemplate rabbitTemplate;

    public List<Reserva> listar() {
        return repository.findAll();
    }

    public Reserva salvar(Reserva reserva) {
        Optional<Reserva> reservaExistente = repository.findBySalaIdAndDataHora(reserva.getSalaId(), reserva.getDataHora());

        if (reservaExistente.isPresent()) {
            throw new IllegalStateException("Já existe uma reserva para esta sala neste horário.");
        }

        Reserva reservaSalva = repository.save(reserva);

        // Enviar mensagem para o RabbitMQ
        HistoricoDTO historicoDTO = new HistoricoDTO();
        historicoDTO.setSalaId(reservaSalva.getSalaId());
        historicoDTO.setUsuarioId(reservaSalva.getUsuarioId());
        historicoDTO.setDataHora(reservaSalva.getDataHora());

        rabbitTemplate.convertAndSend(RabbitMQConfig.EXCHANGE_NAME, RabbitMQConfig.ROUTING_KEY, historicoDTO);
        
        return reservaSalva;
    }
}