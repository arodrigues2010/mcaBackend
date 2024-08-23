package com.mca.config;

import java.nio.file.Files;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.stream.Collectors;

import com.fasterxml.jackson.databind.deser.std.StringDeserializer;
import com.google.gson.Gson;
import com.mca.infrastructure.KafkaMessageProducer;
import com.mca.infrastructure.model.VideoGameEvent;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.listener.ConcurrentMessageListenerContainer;
import org.springframework.kafka.listener.ContainerProperties;
import org.springframework.util.ResourceUtils;

@EnableKafka
@Configuration
public class KafkaConfig implements CommandLineRunner {


	@Bean
    public Map<String, Object> consumerConfigs() {
        Map<String, Object> props = new HashMap<>();
        props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092"); // Ajusta según tu configuración
        props.put(ConsumerConfig.GROUP_ID_CONFIG, "group_id");
        props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        props.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");

        return props;
    }

	@Bean
    public ConsumerFactory<String, String> consumerFactory() {
        return new DefaultKafkaConsumerFactory<>(consumerConfigs());
    }

	@Autowired
	KafkaMessageProducer kafkaMessageProducer;

	@Value("classpath:events.csv")
	Resource resourceFile;

	Gson gson = new Gson();
	@Override
	public void run(String... args) throws Exception {
		try {

			List<VideoGameEvent> stocks = Files
					.readAllLines(ResourceUtils.getFile(resourceFile.getURL()).toPath()).stream()
					.map(line -> convertStock(Arrays.asList(line.trim().split(",")))).collect(Collectors.toList());
			stocks.forEach(stock -> kafkaMessageProducer.sendMessage(String.valueOf(stock.getStock_id()),gson.toJson(stock).toString()));
		} catch (Exception e) {
			new Exception("Error in producer");
		}
	}

	public VideoGameEvent convertStock(List<String> stock) {
		return VideoGameEvent.builder().stock_id(Long.parseLong(stock.get(0)))
				.availability(Boolean.parseBoolean(stock.get(1)))
				.time_update(Timestamp.valueOf(
						LocalDateTime.parse(stock.get(2), DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSSX"))))
				.build();
	}
}
