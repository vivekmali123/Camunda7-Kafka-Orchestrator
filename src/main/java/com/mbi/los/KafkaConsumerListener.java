package com.mbi.los;

import org.camunda.bpm.engine.RuntimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumerListener {

    @Autowired
    private RuntimeService runtimeService;

    @KafkaListener(topics = "bpmn-topic", groupId = "bpmn-group")
    public void listen(String message) {
        System.out.println("Message received from Kafka: " + message);

        if ("LoanOriginatingSystemProcess".equals(message)) {
            runtimeService.startProcessInstanceByKey("LoanOriginatingSystemProcess");
            System.out.println("ConsumerProcess started.");
        }
    }
}
