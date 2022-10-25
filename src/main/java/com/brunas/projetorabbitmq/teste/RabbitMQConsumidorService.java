package com.brunas.projetorabbitmq.teste;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
public class RabbitMQConsumidorService {

    //método que vai escutar a fila
    @RabbitListener(queues = "fila1")
    public void consumidor(@Payload String mensagem) {
        System.out.println("Consumer1: " + mensagem);
    }

    @RabbitListener(queues = "fila2")
    public void consumidor2(@Payload String mensagem) {
        System.out.println("Consumer2: " + mensagem);
    }

    @RabbitListener(queues = "fila3")
    public void consumidor3(@Payload String mensagem) {
        System.out.println("Consumer3: " + mensagem);
    }
}
