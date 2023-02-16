package com.example.kafka;

import com.example.kafka.publisher.Publisher;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.listener.ContainerProperties;
import org.springframework.kafka.listener.KafkaMessageListenerContainer;
import org.springframework.kafka.listener.MessageListener;
import org.springframework.kafka.test.EmbeddedKafkaBroker;
import org.springframework.kafka.test.context.EmbeddedKafka;
import org.springframework.kafka.test.utils.ContainerTestUtils;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;

import java.util.Map;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@EmbeddedKafka
@SpringBootTest(properties = "spring.kafka.bootstrap-servers=${spring.embedded.kafka.brokers}")
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class KafkaApplicationTests {
	private BlockingQueue<ConsumerRecord<String, String>> helloRecord, teaRecord, coffeeRecord, herbRecord;
	private KafkaMessageListenerContainer<String, String> helloContainer, teaContainer, coffeeContainer, herbContainer;
	@Autowired
	private EmbeddedKafkaBroker embeddedKafkaBroker;
	@Autowired
	private Publisher publisher;
	@Autowired
	private ObjectMapper objectMapper;
	@DynamicPropertySource
	static void kafkaProperties(DynamicPropertyRegistry registry) {
		registry.add("spring.datasource.url", () -> "jdbc:h2:mem:test");
		registry.add("spring.datasource.driverClassName", () -> "org.h2.Driver");
		registry.add("spring.datasource.username", () -> "root");
		registry.add("spring.datasource.password", () -> "secret");
		registry.add("spring.flyway.enabled", () -> "false");
	}

	private Map<String, Object> getConsumerProperties() {
		return Map.of(
				ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, embeddedKafkaBroker.getBrokersAsString(),
				ConsumerConfig.GROUP_ID_CONFIG, "consumer",
				ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG, "true",
				ConsumerConfig.AUTO_COMMIT_INTERVAL_MS_CONFIG, "10",
				ConsumerConfig.SESSION_TIMEOUT_MS_CONFIG, "60000",
				ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class,
				ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class,
				ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");
	}
	@BeforeAll
	void setUp() {
		DefaultKafkaConsumerFactory<String, String> consumerFactory = new DefaultKafkaConsumerFactory<>(getConsumerProperties());
		// hello
		helloContainer = new KafkaMessageListenerContainer<>(consumerFactory, new ContainerProperties("hello"));
		helloRecord = new LinkedBlockingQueue<>();
		helloContainer.setupMessageListener((MessageListener<String, String>) helloRecord::add);
		helloContainer.start();
		ContainerTestUtils.waitForAssignment(helloContainer, embeddedKafkaBroker.getPartitionsPerTopic());
		// car
		teaContainer = new KafkaMessageListenerContainer<>(consumerFactory, new ContainerProperties("car"));
		teaRecord = new LinkedBlockingQueue<>();
		teaContainer.setupMessageListener((MessageListener<String, String>) teaRecord::add);
		teaContainer.start();
		ContainerTestUtils.waitForAssignment(teaContainer, embeddedKafkaBroker.getPartitionsPerTopic());
		// hot
		coffeeContainer = new KafkaMessageListenerContainer<>(consumerFactory, new ContainerProperties("hot"));
		coffeeRecord = new LinkedBlockingQueue<>();
		coffeeContainer.setupMessageListener((MessageListener<String, String>) coffeeRecord::add);
		coffeeContainer.start();
		ContainerTestUtils.waitForAssignment(coffeeContainer, embeddedKafkaBroker.getPartitionsPerTopic());
		// silly
		herbContainer = new KafkaMessageListenerContainer<>(consumerFactory, new ContainerProperties("silly"));
		herbRecord = new LinkedBlockingQueue<>();
		herbContainer.setupMessageListener((MessageListener<String, String>) herbRecord::add);
		herbContainer.start();
		ContainerTestUtils.waitForAssignment(herbContainer, embeddedKafkaBroker.getPartitionsPerTopic());
	}
	@Test
	void helloKafka_PublishMessage_ShouldMessagePublished() throws InterruptedException, JsonProcessingException {
		// Given
		String expectedResult = "Hello its me -Adele";
		// When
		publisher.helloKafka();
		ConsumerRecord<String, String> result = helloRecord.poll(500, TimeUnit.MILLISECONDS);
		// Then
		assertNotNull(result);
		String actualResult = objectMapper.readValue(result.value(), String.class);
		assertEquals(expectedResult, actualResult);
	}

	@Test
	void tea_PublishMessage_ShouldMessagePublished() throws InterruptedException, JsonProcessingException {
		// Given
		String expectedResult = "Jeremy Clarkson said porsche just is just a glorified beetle";
		// When
		publisher.car();
		ConsumerRecord<String, String> result = teaRecord.poll(500, TimeUnit.MILLISECONDS);
		// Then
		assertNotNull(result);
		String actualResult = objectMapper.readValue(result.value(), String.class);
		assertEquals(expectedResult, actualResult);
	}

	@Test
	void coffee_PublishMessage_ShouldMessagePublished() throws InterruptedException, JsonProcessingException {
		// Given
		String expectedResult = "Fer D Sambo just got death sentence from the judges";
		// When
		publisher.hot();
		ConsumerRecord<String, String> result = coffeeRecord.poll(500, TimeUnit.MILLISECONDS);
		// Then
		assertNotNull(result);
		String actualResult = objectMapper.readValue(result.value(), String.class);
		assertEquals(expectedResult, actualResult);
	}

	@Test
	void herb_PublishMessage_ShouldMessagePublished() throws InterruptedException, JsonProcessingException {
		// Given
		String expectedResult = "kebodohan saya adalah takut error, dan jadinya tugas saya telat :(, maaf mba";
		// When
		publisher.silly();
		ConsumerRecord<String, String> result = herbRecord.poll(500, TimeUnit.MILLISECONDS);
		// Then
		assertNotNull(result);
		String actualResult = objectMapper.readValue(result.value(), String.class);
		assertEquals(expectedResult, actualResult);
	}

}
