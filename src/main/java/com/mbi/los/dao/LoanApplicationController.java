package com.mbi.los.dao;

import org.camunda.bpm.engine.delegate.DelegateExecution;

import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@RestController

@Component("saveCustomerDelegate")
@RequestMapping("/loanApplication")
public class LoanApplicationController implements JavaDelegate {

	@Autowired
	private CustomerService customerService;
	// @Autowired
	// private CustomerRespository customerRespository;

	// Create a new loan application
	@PostMapping
	@Override

	public void execute(DelegateExecution execution) throws Exception {
		long id = 101;
		String name = (String) execution.getVariable("name");
		String address = (String) execution.getVariable("address");
		long contactNumber = (int) execution.getVariable("contactNumber");
		String currentEmployee = (String) execution.getVariable("currentEmployee");
		long salary = (int) execution.getVariable("salary");
		long loanAmount = (int) execution.getVariable("loanAmount");
		String loanType = (String) execution.getVariable("loanType");

		LoanApplication customer = new LoanApplication();
		customer.setId(id);
		customer.setName(name);
		customer.setAddress(address);
		customer.setContactNumber(contactNumber);
		customer.setCurrentEmployee(currentEmployee);
		customer.setSalary(salary);
		customer.setLoanAmount(loanAmount);
		customer.setLoanType(loanType);

		customerService.saveCustomerDetails(customer);
	}

	/*
	 * // Get all loan applications
	 * 
	 * @GetMapping public ResponseEntity<List<LoanApplication>>
	 * getAllLoanApplications() { List<LoanApplication> loanApplications =
	 * customerRespository.findAll(); return new ResponseEntity<>(loanApplications,
	 * HttpStatus.OK); }
	 * 
	 * // Get a single loan application by ID
	 * 
	 * @GetMapping("/{id}") public ResponseEntity<LoanApplication>
	 * getLoanApplicationById(@PathVariable Long id) { LoanApplication
	 * loanApplication = customerRespository.findById(id) .orElseThrow(() -> new
	 * ResourceNotFoundException("Loan Application not found with id: " + id));
	 * return new ResponseEntity<>(loanApplication, HttpStatus.OK); }
	 * 
	 * // Update an existing loan application
	 * 
	 * @PutMapping("/{id}") public ResponseEntity<LoanApplication>
	 * updateLoanApplication(@PathVariable Long id,
	 * 
	 * @RequestBody LoanApplication loanApplicationDetails) { LoanApplication
	 * loanApplication = customerRespository.findById(id) .orElseThrow(() -> new
	 * ResourceNotFoundException("Loan Application not found with id: " + id));
	 * loanApplication.setName(loanApplicationDetails.getName());
	 * loanApplication.setAddress(loanApplicationDetails.getAddress());
	 * loanApplication.setContactNumber(loanApplicationDetails.getContactNumber());
	 * loanApplication.setCurrentEmployee(loanApplicationDetails.getCurrentEmployee(
	 * )); loanApplication.setSalary(loanApplicationDetails.getSalary());
	 * loanApplication.setLoanAmount(loanApplicationDetails.getLoanAmount());
	 * loanApplication.setLoanType(loanApplicationDetails.getLoanType());
	 * 
	 * LoanApplication updatedLoanApplication =
	 * customerRespository.save(loanApplication); return new
	 * ResponseEntity<>(updatedLoanApplication, HttpStatus.OK); }
	 * 
	 * 
	 * // Delete a loan application
	 * 
	 * @DeleteMapping("/{id}") public ResponseEntity<?>
	 * deleteLoanApplication(@PathVariable Long id) { LoanApplication
	 * loanApplication = customerRespository.findById(id) .orElseThrow(() -> new
	 * ResourceNotFoundException("Loan Application not found with id: " + id));
	 * customerRespository.delete(loanApplication); return
	 * ResponseEntity.ok().build(); }
	 */
}
