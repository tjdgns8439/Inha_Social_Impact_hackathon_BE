package com.example.success_tutor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class SuccessTutorApplication {

	public static void main(String[] args) {
		SpringApplication.run(SuccessTutorApplication.class, args);
	}

}
