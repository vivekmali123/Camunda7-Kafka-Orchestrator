package com.mbi.los;

import org.camunda.bpm.engine.delegate.DelegateTask;
import org.camunda.bpm.engine.delegate.TaskListener;
import org.springframework.stereotype.Component;

@Component("assignExpert")
public class AssignExpert implements TaskListener{

	@Override
	public void notify(DelegateTask delegateTask) {
		
		delegateTask.setAssignee("demo");
		System.out.println("Please Review all documents :"+ delegateTask.getAssignee());
		
		
	}

}