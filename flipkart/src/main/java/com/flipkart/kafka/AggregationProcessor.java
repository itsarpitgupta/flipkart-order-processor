package com.flipkart.kafka;
import org.apache.kafka.streams.KafkaStreams;
import org.apache.kafka.streams.StreamsBuilder;
import org.apache.kafka.streams.kstream.KStream;

import java.util.Properties;

public class AggregationProcessor {
    public static void main(String[] args) {
        Properties props = new Properties();
        props.put("application.id", "order-aggregator");
        props.put("bootstrap.servers", "localhost:9092");

        StreamsBuilder builder = new StreamsBuilder();
        KStream<String, Order> stream = builder.stream("FlipkartOrdersTopic");

        stream.groupByKey()
                .aggregate(() -> 0,
                        (key, value, aggregate) -> aggregate + value.getPrice())
                .toStream()
                .to("ReportTopic");

        KafkaStreams streams = new KafkaStreams(builder.build(), props);
        streams.start();
    }
}
