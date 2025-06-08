package com.historicoservice.demo.consumer;

import com.historicoservice.demo.dto.HistoricoDTO;
import com.historicoservice.demo.model.Historico;
import com.historicoservice.demo.repository.HistoricoRepository;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class HistoricoConsumer {

    @Autowired
    private HistoricoRepository historicoRepository;

    @RabbitListener(queues = "reserva.concluida.historico.queue")
    public void consumirMensagem(HistoricoDTO historicoDTO) {
        System.out.println("Mensagem recebida: " + historicoDTO);
        Historico historico = new Historico();
        historico.setSalaId(historicoDTO.getSalaId());
        historico.setUsuarioId(historicoDTO.getUsuarioId());
        historico.setDataHora(historicoDTO.getDataHora());

        historicoRepository.save(historico);
        System.out.println("Histórico salvo com sucesso.");
    }
} 