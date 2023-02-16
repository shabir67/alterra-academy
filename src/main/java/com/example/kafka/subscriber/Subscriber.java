package com.example.kafka.subscriber;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class Subscriber {
    @KafkaListener(topics = "hello", concurrency = "${spring.kafka.consumer.level.concurrency:3}")
    public void subscribeHello(@Payload String message){
        log.info("[hello] received message: " + message);
    }

    @KafkaListener(topics = "car", concurrency = "${spring.kafka.consumer.level.concurrency:3}")
    public void subscribeCar(@Payload String message){
        log.info("[car] received message: " + message);
    }

    @KafkaListener(topics = "hot", concurrency = "${spring.kafka.consumer.level.concurrency:3}")
    public void subscribeHot(@Payload String message){
        log.info("[hot] received message: " + message);
    }

    @KafkaListener(topics = "silly", concurrency = "${spring.kafka.consumer.level.concurrency:3}")
    public void subscribeSilly(@Payload String message){
        log.info("[silly] received message: " + message);
    }

}
