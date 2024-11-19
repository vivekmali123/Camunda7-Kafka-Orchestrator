package com.mbi.los;

import org.camunda.bpm.engine.delegate.BpmnError;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;

@Component("errorHandling")
public class ErrorHandingRejection implements JavaDelegate {

	@Override
	public void execute(DelegateExecution execution) throws Exception {

		long cibilScore = (long) execution.getVariable("cibil_score");
		if (cibilScore >= 300) {
			System.out.println("you are eligible for Loan");
		} else {
			throw new BpmnError("You are not eligible for loan, so your loan application is rejected.");
		}
	}

}