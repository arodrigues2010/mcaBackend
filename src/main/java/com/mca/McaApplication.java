package com.mca;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;

@SuppressWarnings("unused")
@SpringBootApplication
public class McaApplication {

	public static void main(String[] args) {
		System.out.println("Hola, mundo!");
		SpringApplication.run(McaApplication.class, args);
	}

}