package com.mca.infrastructure;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class KafkaMessageProducer {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @Value(value = "${topic}")
    private String topicName;

    private final ObjectMapper objectMapper = new ObjectMapper();

    public void sendMessage(String string, String string2) {
        try {
            // Crear un objeto JSON
            String message = objectMapper.writeValueAsString(Map.of("id", string, "stock", string2));
            this.kafkaTemplate.send(this.topicName, message);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }
}
