package com.mbi.los;


import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component("kafkaProducerDelegate")
public class KafkaProducerDelegate implements JavaDelegate {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @Override
    public void execute(DelegateExecution execution) throws Exception {
        String topic = "bpmn-topic";
        String message = "LoanOriginatingSystemProcess"; // Trigger message for second BPMN
        kafkaTemplate.send(topic, message);

        System.out.println("Message sent to Kafka: " + message);
    }
}

