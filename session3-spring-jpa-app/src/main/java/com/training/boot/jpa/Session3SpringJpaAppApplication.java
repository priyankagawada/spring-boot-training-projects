package com.training.boot.jpa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
public class Session3SpringJpaAppApplication {

	public static void main(String[] args) {
		System.out.println("ApplicationContext loaded...");
		SpringApplication.run(Session3SpringJpaAppApplication.class, args);
	}

}
