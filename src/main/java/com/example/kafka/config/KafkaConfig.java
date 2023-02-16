package com.example.kafka.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;

@Configuration
@EnableKafka
public class KafkaConfig {
    @Value("${spring.kafka.topic.hello}")
    private String helloTopic;
    @Value("${spring.kafka.replication.factor:1}")
    private int replicationFactor;
    @Value("${spring.kafka.partition.number:1}")
    private int partitionNumber;
    @Bean
    public NewTopic helloTopic() {
        return new NewTopic(helloTopic, partitionNumber, (short) replicationFactor);
    }
    @Bean
    public NewTopic carTopic() {
        String carTopic = "car";
        return new NewTopic(carTopic, partitionNumber, (short) replicationFactor);
    }
    @Bean
    public NewTopic hotTopic() {
        String hotTopic = "hot";
        return new NewTopic(hotTopic, partitionNumber, (short) replicationFactor);
    }
    @Bean
    public NewTopic sillyTopic() {
        String sillyTopic = "silly";
        return new NewTopic(sillyTopic, partitionNumber, (short) replicationFactor);
    }
}
