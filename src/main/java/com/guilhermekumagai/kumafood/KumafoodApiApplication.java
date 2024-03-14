package com.guilhermekumagai.kumafood;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.guilhermekumagai.kumafood.infrastructure.repository.CustomJpaRepositoryImpl;

@SpringBootApplication
@EnableJpaRepositories(repositoryBaseClass = CustomJpaRepositoryImpl.class)
public class KumafoodApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(KumafoodApiApplication.class, args);
	}

}
