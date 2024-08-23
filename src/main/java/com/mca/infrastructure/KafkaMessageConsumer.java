package com.mca.infrastructure;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class KafkaMessageConsumer {

    private final ObjectMapper objectMapper = new ObjectMapper();

    @KafkaListener(topics = "MCA", groupId = "group_id")
    public void listen(ConsumerRecord<String, String> record) {
        try {
            String message = record.value();
            JsonNode jsonNode = objectMapper.readTree(message);
            Long id = jsonNode.get("id").asLong();
            Integer stock = jsonNode.get("stock").asInt();

            // Aquí puedes actualizar el stock en la base de datos o realizar otras operaciones
            System.out.println("ID: " + id + ", Stock: " + stock);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
