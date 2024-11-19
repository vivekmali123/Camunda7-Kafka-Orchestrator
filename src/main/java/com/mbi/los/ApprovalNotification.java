package com.mbi.los;

import java.util.logging.Logger;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;


@Component("approvalNotification")
public class ApprovalNotification implements JavaDelegate{
	private final Logger LOGGER = Logger.getLogger(ApprovalNotification.class.getName());
    
	public void execute(DelegateExecution execution) throws Exception {

		LOGGER.info("Congrats!! Loan approved...");
		
		String approvalnotification ="Auto Approved";
		execution.setVariable("approvalnotification", approvalnotification);		
		
	   

		
	}
}