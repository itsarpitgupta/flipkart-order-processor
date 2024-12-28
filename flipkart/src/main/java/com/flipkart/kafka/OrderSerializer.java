package com.flipkart.kafka;

import java.util.Map;

import org.apache.kafka.common.serialization.Serializer;

import com.fasterxml.jackson.databind.ObjectMapper;

public class OrderSerializer implements Serializer<Order> {

	private final ObjectMapper objectMapper = new ObjectMapper();

	@Override
	public void configure(Map<String, ?> configs, boolean isKey) {
		// No additional configuration required
	}

	@Override
	public byte[] serialize(String topic, Order data) {
		try {
			if (data == null) {
				return null;
			}
			return objectMapper.writeValueAsBytes(data);
		} catch (Exception e) {
			throw new RuntimeException("Failed to serialize Order object", e);
		}
	}

	@Override
	public void close() {
		// Nothing to close
	}
}
