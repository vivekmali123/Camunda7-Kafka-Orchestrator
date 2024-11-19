package com.mbi.los;

import org.camunda.bpm.dmn.engine.DmnDecision;
import org.camunda.bpm.dmn.engine.DmnDecisionTableResult;
import org.camunda.bpm.dmn.engine.DmnEngine;
import org.camunda.bpm.dmn.engine.DmnEngineConfiguration;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.ExecutionListener;
import org.springframework.stereotype.Component;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

@Component("dmnDelegate")
public class DmnDelegate implements ExecutionListener {

    @Override
    public void notify(DelegateExecution execution) {
        try {
            // Create the DMN engine
            DmnEngine dmnEngine = DmnEngineConfiguration.createDefaultDmnEngineConfiguration().buildEngine();

            // Load the decision table from classpath
            InputStream inputStream = getClass().getClassLoader().getResourceAsStream("interest-rules.dmn");
            if (inputStream == null) {
                throw new IllegalArgumentException("DMN file not found in classpath");
            }

            // Load the decision table
            String decisionKey = "Interest_rules"; // Replace with your decision key
            // DmnDecision decision = dmnEngine.parseDecision(decisionKey,
               //     getClass().getResourceAsStream("interest-rules.dmn"));

         // Parse the DMN decision table
            DmnDecision decision = dmnEngine.parseDecision("Interest_rules", inputStream);
            
            // Prepare input variables from process variables
            Map<String, Object> variables = new HashMap<>();
            variables.put("cibil_score", execution.getVariable("cibil_score"));
            //variables.put("inputVariable2", execution.getVariable("/inputVariable2"));

            // Evaluate the decision
            DmnDecisionTableResult result = dmnEngine.evaluateDecisionTable(decision, variables);

            // Print the results to the console
            result.forEach(output -> System.out.println("Result: " + output.getEntryMap()));

            // Example: Print a specific output column
            if (!result.isEmpty()) {
                String specificResult = result.getSingleResult().getEntry("interestRate").toString();
                System.out.println("Specific Output: " + specificResult);

                // Optionally, store the result in a process variable
                execution.setVariable("interestRate", specificResult);
            }

        } catch (Exception e) {
            System.err.println("Error evaluating DMN: " + e.getMessage());
            e.printStackTrace();
        }
    }
}