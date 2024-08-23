package com.mca;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.test.EmbeddedKafkaBroker;
import org.springframework.kafka.test.context.EmbeddedKafka;
import org.springframework.kafka.test.utils.KafkaTestUtils;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.mca.infrastructure.KafkaMessageProducer;

import java.util.Collections;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@DirtiesContext
@EmbeddedKafka(partitions = 1, topics = { "test-topic" })
public class KafkaMessageProducerTest {

    @Autowired
    private KafkaMessageProducer producer;

    @Autowired
    private EmbeddedKafkaBroker embeddedKafkaBroker;

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @Test
    void testSendMessage() {
        // Enviar un mensaje usando el productor
        producer.sendMessage("123", "45");

        // Configurar las propiedades del consumidor para verificar el mensaje
        Map<String, Object> consumerProps = KafkaTestUtils.consumerProps("test-group", "true", embeddedKafkaBroker);
        consumerProps.put("key.deserializer", StringDeserializer.class);
        consumerProps.put("value.deserializer", StringDeserializer.class);
        consumerProps.put("auto.offset.reset", "earliest");

        try (KafkaConsumer<String, String> consumer = new KafkaConsumer<>(consumerProps)) {
            consumer.subscribe(Collections.singletonList("test-topic"));

            // Leer el mensaje del tópico
            ConsumerRecord<String, String> record = KafkaTestUtils.getSingleRecord(consumer, "test-topic");

            // Verificar que el mensaje enviado es el correcto
            assertThat(record).isNotNull();
            assertThat(record.value()).contains("\"id\":\"123\"");
            assertThat(record.value()).contains("\"stock\":\"45\"");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
