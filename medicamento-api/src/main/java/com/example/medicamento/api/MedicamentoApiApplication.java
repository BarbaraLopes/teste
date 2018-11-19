package com.example.medicamento.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class MedicamentoApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(MedicamentoApiApplication.class, args);
	}
}
