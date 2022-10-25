package com.brunas.projetorabbitmq.teste;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Service;

@Service
@EnableAutoConfiguration
public class RabbitMQProdutorService {

    private final RabbitTemplate rabbitTemplate;
    private final Jackson2JsonMessageConverter converter;

    public RabbitMQProdutorService(RabbitTemplate rabbitTemplate, Jackson2JsonMessageConverter converter) {
        this.rabbitTemplate = rabbitTemplate;
        this.converter = converter;
    }

    public void enviarHeaderFila1(String mensagem) {

        MessageProperties properties = new MessageProperties();
        properties.setHeader("h1", "header1");

        Message message = converter.toMessage(mensagem, properties);
        rabbitTemplate.convertAndSend("headers-exchange", "", message);

        System.out.println("Enviando mensagem: " + mensagem);
    }

    public void enviarHeaderFila2(String mensagem) {

        MessageProperties properties = new MessageProperties();
        properties.setHeader("h1", "header1");
        properties.setHeader("h3", "header3");

        Message message = converter.toMessage(mensagem, properties);
        rabbitTemplate.convertAndSend("headers-exchange", "", message);

        System.out.println("Enviando mensagem: " + mensagem);
    }

    public void enviarHeaderFila3(String mensagem) {

        MessageProperties properties = new MessageProperties();
        properties.setHeader("h1", "header1");
        properties.setHeader("h2", "header2");
        properties.setHeader("h3", "header3");

        Message message = converter.toMessage(mensagem, properties);
        rabbitTemplate.convertAndSend("headers-exchange", "", message);

        System.out.println("Enviando mensagem: " + mensagem);
    }
}

