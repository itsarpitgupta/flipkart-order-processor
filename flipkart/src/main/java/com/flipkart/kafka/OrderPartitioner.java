package com.flipkart.kafka;
import org.apache.kafka.clients.producer.Partitioner;
import org.apache.kafka.common.Cluster;

import java.util.Map;

public class OrderPartitioner implements Partitioner {
    @Override
    public int partition(String topic, Object key, byte[] keyBytes, Object value, byte[] valueBytes, Cluster cluster) {
        String orderType = (String) key;
        switch (orderType) {
            case "BOOK": return 0;
            case "MOBILE": return 1;
            case "CAR": return 2;
            default: throw new IllegalArgumentException("Unknown order type");
        }
    }

    @Override
    public void configure(Map<String, ?> configs) {}

    @Override
    public void close() {}
}
