package com.mbi.los;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Service;

import java.util.Properties;

@Service
public class KafkaProducerService  {
    private KafkaProducer<String, String> producer;

    public KafkaProducerService() {
        Properties props = new Properties();
        props.put("bootstrap.servers", "localhost:9092");
        props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");

        producer = new KafkaProducer<>(props);
    }

    public void sendMessage(String topic, String message) {
        producer.send(new ProducerRecord<>(topic, message));
        System.out.println("Message sent to Kafka: " + message);
    }

}
