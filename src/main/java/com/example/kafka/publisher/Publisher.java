package com.example.kafka.publisher;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class Publisher {
    private final KafkaTemplate<String, Object> kafkaTemplate;

    public Publisher(KafkaTemplate<String, Object> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void helloKafka() {
        kafkaTemplate.send("hello", "Hello its me -Adele");
    }

    public void car(){
        kafkaTemplate.send("car", "Jeremy Clarkson said porsche just is just a glorified beetle");
    }

    public void hot(){kafkaTemplate.send("hot", "Fer D Sambo just got death sentence from the judges"); }

    public void silly(){
        kafkaTemplate.send("silly", "kebodohan saya adalah takut error, dan jadinya tugas saya telat :(, maaf mba");
    }

}
