package com.Springboot;

import javax.persistence.EntityManager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

//@EnableJpaRepositories("com.Springboot.repositories")
@SpringBootApplication
public class SpringApiTestApplication {


	public static void main(String[] args) {
		SpringApplication.run(SpringApiTestApplication.class, args);
	}
}
