package com.mca.infrastructure;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaMessageConsumer {

    // @Autowired
    // private VideojuegoRepository repository;

    @KafkaListener(topics = "MCA", groupId = "group_id")
    public void listen(ConsumerRecord<String, String> record) {
        String mensaje = record.value();
        // Parsear el mensaje y actualizar el stock
        // Suponiendo que el mensaje es del tipo "id:stock"
        String[] partes = mensaje.split(":");
        Long id = Long.parseLong(partes[0]);
        Integer nuevoStock = Integer.parseInt(partes[1]);

        // Videojuego videojuego = repository.findById(id).orElseThrow(() -> new RuntimeException("Videojuego no encontrado"));
        // videojuego.setStock(nuevoStock);
        // repository.save(videojuego);
    }
}
