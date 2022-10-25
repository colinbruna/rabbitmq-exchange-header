package com.brunas.projetorabbitmq.config;

import org.springframework.amqp.core.*;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class RabbitMQConfig {

    //Nas exchanges do tipo Header não são usados routingKeys para definir o roteamento.
    //São usados os cabeçalhos das mensagens para definir as regras de roteamento.
    // Basicamente o header enviado na mensagem precisa combinar com o binding(ligação) feita entre a fila e a Exchange.

    //FILAS

    @Bean //serve para exportar uma classe para o Spring, para que ele consiga carregar essa classe e fazer injeção de dependência dela em outra classes.
    public Queue fila1() {
        return new Queue("fila1", true);
    }

    @Bean
    public Queue fila2() {
        return new Queue("fila2", true);
    }

    @Bean
    public Queue fila3() {
        return new Queue("fila3", true);
    }

    //EXCHANGE DO TIPO HEADERS
    @Bean
    HeadersExchange exchange() {
        return new HeadersExchange("headers-exchange");
    }

    //BINDINGS
    //HashMap trabalha com conceito de chave-valor, cada elemento da lista possui uma chave e valor associado,
    //assim podemos realizar uma busca rápida pela chave que desejamos, sem precisar percorrer toda lista
    //ou saber o index/posição que desejamos consultar.
    @Bean
    Binding binding(Queue fila1, HeadersExchange exchange) {
        Map<String, Object> map = new HashMap<>();
        map.put("h1", "header1"); // método put para inserir um novo par de elementos
        return BindingBuilder.bind(fila1).to(exchange).where("h1").matches("header1");
    }

    @Bean
    Binding binding2(Queue fila2, HeadersExchange exchange) {
        Map<String, Object> map = new HashMap<>();
        map.put("h1", "header1");
        map.put("h3", "header3");
        return BindingBuilder.bind(fila2).to(exchange).whereAny(map).match();
    }

    @Bean
    Binding binding3(Queue fila3, HeadersExchange exchange) {
        Map<String, Object> map = new HashMap<>();
        map.put("h1", "header1");
        map.put("h2", "header2");
        map.put("h3", "header3");
        return BindingBuilder.bind(fila3).to(exchange).whereAll(map).match();
    }

    @Bean
    MessageConverter messageConverter() {
        return new Jackson2JsonMessageConverter();
    }
}
