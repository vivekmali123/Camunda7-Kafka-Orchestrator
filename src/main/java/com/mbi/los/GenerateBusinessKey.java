package com.mbi.los;

import java.text.SimpleDateFormat;
import java.util.Date;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.ExecutionListener;
import org.springframework.stereotype.Component;

@Component("generateBusinessKey")
public class GenerateBusinessKey implements ExecutionListener {

    @Override
    public void notify(DelegateExecution execution) throws Exception {
        String timestamp = new SimpleDateFormat("yyyyMMddHHmm").format(new Date());
        String customIdentifier = "YOUR_CUSTOM_IDENTIFIER"; // You can replace this with any other identifier you want to include
        String businessKey = "Business Key : " + customIdentifier + "-" + timestamp;
        execution.setProcessBusinessKey(businessKey);
        System.out.println(execution.getBusinessKey());
        System.out.println("Welcome to Loan Originating System...");
        System.out.println("Submit Application Form.");
    }
}
