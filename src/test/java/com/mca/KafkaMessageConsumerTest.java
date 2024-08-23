package com.mca;

import com.mca.infrastructure.KafkaMessageConsumer;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.kafka.test.context.EmbeddedKafka;
import org.springframework.kafka.test.utils.KafkaTestUtils;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.context.WebApplicationContext;

import java.util.Collections;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@WebAppConfiguration
@DirtiesContext
@EmbeddedKafka(partitions = 1, topics = { "MCA" })
class KafkaMessageConsumerTest {

    @Autowired
	private WebApplicationContext webApplicationContext;
    private org.springframework.kafka.test.EmbeddedKafkaBroker embeddedKafkaBroker;
    private KafkaMessageConsumer consumer;

    @Test
    void testKafkaMessageConsumer() {
        // Configurar las propiedades del consumidor para verificación
        Map<String, Object> consumerProps = KafkaTestUtils.consumerProps("test-group", "true", embeddedKafkaBroker);
        consumerProps.put("auto.offset.reset", "earliest");
        consumerProps.put("key.deserializer", StringDeserializer.class);
        consumerProps.put("value.deserializer", StringDeserializer.class);

        try (KafkaConsumer<String, String> consumer = new KafkaConsumer<>(consumerProps)) {
            consumer.subscribe(Collections.singletonList("MCA"));

            ConsumerRecord<String, String> record = KafkaTestUtils.getSingleRecord(consumer, "MCA");

            // Verificar que el mensaje recibido es el correcto
            assertThat(record).isNotNull();
            assertThat(record.value()).isEqualTo("1:10");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
