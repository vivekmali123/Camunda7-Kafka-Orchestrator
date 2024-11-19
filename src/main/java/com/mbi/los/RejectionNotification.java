package com.mbi.los;

import java.util.logging.Logger;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;

@Component("rejectionNotification")
public class RejectionNotification implements JavaDelegate{

	private final Logger LOGGER = Logger.getLogger(ApprovalNotification.class.getName());
    
	public void execute(DelegateExecution execution) throws Exception {

		LOGGER.info("Oops!! Loan rejected...");
		
		String rejectionNotification ="Rejected";
		execution.setVariable("rejectionNotification", rejectionNotification);		
		
		
	}
}