package com.flipkart.kafka;

import java.util.Properties;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;

public class OrderProducer {
	public static void main(String[] args) {
		// Kafka producer properties
		Properties props = new Properties();
		props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
		props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
		props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, OrderSerializer.class.getName()); // Correct reference

		KafkaProducer<String, Order> producer = new KafkaProducer<>(props);

		// Example usage
		Order order = new Order("BOOK", "Harry Potter", 500);
		producer.send(new ProducerRecord<>("FlipkartOrdersTopic", order.getOrderType(), order));
		producer.close();
	}
}
