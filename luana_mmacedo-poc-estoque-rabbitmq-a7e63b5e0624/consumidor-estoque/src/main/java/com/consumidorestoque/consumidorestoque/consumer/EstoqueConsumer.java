package com.consumidorestoque.consumidorestoque.consumer;

import constantes.RabbitMQConstantes;
import dto.EstoqueDTO;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class EstoqueConsumer {

    @RabbitListener(queues = RabbitMQConstantes.FILA_ESTOQUE)
    private void consumidor(EstoqueDTO estoqueDTO){
        System.out.println("Codigo do produto: " + estoqueDTO.codigoProduto);
        System.out.println("Quantidade: "+estoqueDTO.quantidade);
        System.out.println("--------------------------------------");
    }
}
