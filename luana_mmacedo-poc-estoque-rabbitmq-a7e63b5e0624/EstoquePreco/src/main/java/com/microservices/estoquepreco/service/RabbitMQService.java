package com.microservices.estoquepreco.service;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RabbitMQService {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void enviarMensagem(String nomeFila, Object menssagem){
        this.rabbitTemplate.convertAndSend(nomeFila, menssagem);
    }

}
