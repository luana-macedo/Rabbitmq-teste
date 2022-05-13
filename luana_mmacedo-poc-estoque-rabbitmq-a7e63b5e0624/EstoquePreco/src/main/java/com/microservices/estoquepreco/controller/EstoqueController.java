package com.microservices.estoquepreco.controller;
import constantes.RabbitMQConstantes;
import dto.EstoqueDTO;
import com.microservices.estoquepreco.service.RabbitMQService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "estoque")
public class EstoqueController {
    @Autowired
   private RabbitMQService rabbitMQService;

    @PostMapping
    private ResponseEntity adicionarEstoque(@RequestBody EstoqueDTO estoque){
        this.rabbitMQService.enviarMensagem(RabbitMQConstantes.FILA_ESTOQUE, estoque);
        System.out.println(estoque.codigoProduto);
        return new ResponseEntity(HttpStatus.OK);
    }
}
