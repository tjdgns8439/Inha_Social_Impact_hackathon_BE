package com.example.success_tutor;

import com.example.success_tutor.global.s3.S3Config;
import env.EnvConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
@PropertySource(value = {
		"classpath:env/env.yml"
}, factory = EnvConfig.class)
public class SuccessTutorApplication {

	public static void main(String[] args) {
		SpringApplication.run(SuccessTutorApplication.class, args);
	}

}