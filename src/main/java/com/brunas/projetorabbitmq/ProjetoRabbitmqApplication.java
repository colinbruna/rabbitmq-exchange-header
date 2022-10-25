package com.brunas.projetorabbitmq;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableRabbit
@SpringBootApplication
public class ProjetoRabbitmqApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjetoRabbitmqApplication.class, args);
	}

}
