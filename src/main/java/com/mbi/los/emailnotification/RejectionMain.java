package com.mbi.los.emailnotification;

import java.util.logging.Logger;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;

import java.lang.Long;

@Component("rejectionMain")

public class RejectionMain implements JavaDelegate {

	private final Logger LOGGER = Logger.getLogger(RejectionMain.class.getName());
	 
	 @Override
		public void execute(DelegateExecution execution) throws Exception {
		 
		 
	        // Setting the default email variables
	        String to = "malivivek217@gmail.com";
	        String from = "q2292803@gmail.com";
	        String subject = "Loan Rejected";
	       
	        
	        String rejectionNotification =(String)execution.getVariable("approvalstatus");
	        String text="Oops!! Loan rejected..." + "\n Your cibil score is less as per our expectations.." +execution.getVariable("approvalstatus");
	        // Sending email notification
	       
	        
	       
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