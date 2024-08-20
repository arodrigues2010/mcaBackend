package com.mca;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;

@SpringBootApplication
@EnableKafka  // Habilita el soporte para Kafka si estás utilizando Kafka en tu aplicación
public class McaApplication {

    public static void main(String[] args) {
        SpringApplication.run(McaApplication.class, args);
        System.out.println("Hola, mundo!");
    }
}
