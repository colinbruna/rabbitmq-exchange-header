package com.brunas.projetorabbitmq.controller;

import com.brunas.projetorabbitmq.teste.RabbitMQProdutorService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/header")
public class RabbitMQController {

    private final RabbitMQProdutorService produtorService;

    public RabbitMQController(RabbitMQProdutorService produtorConfig) {
        this.produtorService = produtorConfig;
    }

    @GetMapping("/fila1")
    public void enviarFila1(@RequestBody String mensagem) {
        produtorService.enviarHeaderFila1(mensagem);
    }

    @GetMapping("/fila2")
    public void enviarFila2(@RequestBody String mensagem) { produtorService.enviarHeaderFila2(mensagem); }

    @GetMapping("/fila3")
    public void enviarFila3(@RequestBody String mensagem) { produtorService.enviarHeaderFila3(mensagem); }

}
