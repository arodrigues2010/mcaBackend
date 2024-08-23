package com.mca;

import com.mca.infrastructure.KafkaMessageProducer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.kafka.test.context.EmbeddedKafka;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@DirtiesContext
@EmbeddedKafka(partitions = 1, topics = { "test-topic" }, brokerProperties = { "listeners=PLAINTEXT://localhost:9092", "port=9092" })

class KafkaMessageProducerTest {

    @Autowired
    private KafkaMessageProducer<String, String> producer;

    @Test
    void testKafkaMessageProducer() {
        // Enviar un mensaje usando el productor
        producer.sendMessage("1", "1:10");

        // Aquí podrías agregar más validaciones o impresiones si fuera necesario
        System.out.println("Mensaje enviado exitosamente al tópico MCA");
    }
}
