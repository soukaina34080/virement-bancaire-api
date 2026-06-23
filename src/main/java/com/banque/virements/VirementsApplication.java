package com.banque.virements;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(
		basePackages = "com.banque.virements.transaction.infrastructure.jpa"
)

public class VirementsApplication {

	public static void main(String[] args) {
		SpringApplication.run(VirementsApplication.class, args);
	}

}
