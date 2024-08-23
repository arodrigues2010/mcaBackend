package com.mca;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;

@SpringBootApplication
@EnableKafka  // Habilita el soporte para Kafka en la aplicación
public class McaApplication {

    public static void main(String[] args) {
        SpringApplication.run(McaApplication.class, args); // Ejecuta la clase principal correcta
        System.out.println("Hola, mundo!"); // Mensaje después de iniciar la aplicación
    }
}
