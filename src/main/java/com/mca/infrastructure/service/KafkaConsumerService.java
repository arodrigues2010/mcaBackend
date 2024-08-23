package com.mca.infrastructure.service;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumerService {

    @KafkaListener(topics = "MCA", groupId = "group_id")
    public void consume(ConsumerRecord<String, String> record) {
        // Procesar el mensaje recibido
        System.out.printf("Offset = %d, Key = %s, Value = %s%n",
                          record.offset(),
                          record.key(),
                          record.value());

        // AQUI PODEMOS ACTUALIZAR EL STOCK
    }
}
