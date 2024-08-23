package com.mca;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.springframework.kafka.test.EmbeddedKafkaBroker;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

public class KafkaTestUtils {

    public static Map<String, Object> consumerProps(String groupId, String autoCommit, EmbeddedKafkaBroker embeddedKafkaBroker) {
        Map<String, Object> props = new HashMap<>();
        props.put("bootstrap.servers", embeddedKafkaBroker.getBrokersAsString());
        props.put("group.id", groupId);
        props.put("enable.auto.commit", autoCommit);
        props.put("auto.commit.interval.ms", "1000");
        props.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        props.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        return props;
    }

    public static ConsumerRecord<String, String> getSingleRecord(KafkaConsumer<String, String> consumer, String topic) {
        ConsumerRecords<String, String> records = consumer.poll(Duration.ofSeconds(10));
        for (ConsumerRecord<String, String> record : records) {
            if (record.topic().equals(topic)) {
                return record;
            }
        }
        return null; // Si no se encuentra el registro en el tema, devolver null o lanzar una excepción
    }
}
