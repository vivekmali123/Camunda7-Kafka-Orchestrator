package com.mbi.los;

import org.camunda.bpm.engine.RuntimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import java.util.HashMap;
import java.util.Map;

@Service
public class KafkaCamundaConsumer {

    @Autowired
	private final RuntimeService runtimeService;

    public KafkaCamundaConsumer(RuntimeService runtimeService) {
        this.runtimeService = runtimeService;
    }

    @KafkaListener(topics = "external-camunda-process", groupId = "camunda-consumer")
    public void consume(String message) {
        try {
            // Log the received message
            System.out.println("Received message: " + message);

            // Parse message or map it to variables
            Map<String, Object> processVariables = new HashMap<>();
            processVariables.put("messagePayload", message);

            // Start the Camunda BPMN process
            runtimeService.startProcessInstanceByKey("LoanOriginatingSystemProcess", processVariables);

            System.out.println("Second BPMN process started successfully for message: " + message);
        } catch (Exception e) {
            System.err.println("Error starting BPMN process: " + e.getMessage());
        }
    }
}

