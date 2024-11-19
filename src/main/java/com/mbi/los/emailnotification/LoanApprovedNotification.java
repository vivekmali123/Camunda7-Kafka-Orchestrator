package com.mbi.los.emailnotification;

import java.util.logging.Logger;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;

import java.lang.Long;

@Component("Approved")

public class LoanApprovedNotification implements JavaDelegate {

	private final Logger LOGGER = Logger.getLogger(LoanApprovedNotification.class.getName());
	 
	 @Override
		public void execute(DelegateExecution execution) throws Exception {
		 
		 
	        // Setting the default email variables
	        String to = "malivivek217@gmail.com";
	        String from = "q2292803@gmail.com";
	        String subject = "Loan Approval";
	       
	        // Sending email notification
	        String approvalnotification =(String)execution.getVariable("approvalstatus");
	        String text="Congrats!! Loan approved... ";
	        
	        
	       
	        GmailSender gEmailSender = new GmailSender();
	        boolean b = gEmailSender.sendEmail(to, from, subject, text);
	        
	        // Checking if email sent successfully
	        if (b) {
	            System.out.println("Email notification sent successfully.");
	        } else {
	            System.out.println("There was a problem sending the email notification.");
	        }

	      
		 
	 }
}