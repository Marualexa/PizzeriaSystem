package com.example.pizzarest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class PizzaRestApplication {

	public static void main(String[] args) {
		SpringApplication.run(PizzaRestApplication.class, args);
	}

}
