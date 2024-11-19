package com.mbi.los.dao;


import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "customer")
public class LoanApplication {

	@jakarta.persistence.Id
	@jakarta.persistence.GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
	private Long id;

	private String name;
	private String address;
	private long contactNumber;
	private String currentEmployee;
	private long salary;
	private long loanAmount;
	private String loanType;

	public LoanApplication() {
		// TODO Auto-generated constructor stub
	}

	public long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public long getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(long contactNumber) {
		this.contactNumber = contactNumber;
	}

	public String getCurrentEmployee() {
		return currentEmployee;
	}

	public void setCurrentEmployee(String currentEmployee) {
		this.currentEmployee = currentEmployee;
	}

	public long getSalary() {
		return salary;
	}

	public void setSalary(long salary) {
		this.salary =   salary;
	}

	public long getLoanAmount() {
		return loanAmount;
	}

	public void setLoanAmount(long d) {
		this.loanAmount = d;
	}

	public String getLoanType() {
		return loanType;
	}

	public void setLoanType(String loanType) {
		this.loanType = loanType;
	}

	@Override
	public String toString() {
		return "LoanApplication [id=" + id + ", name=" + name + ", address=" + address + ", contactNumber="
				+ contactNumber + ", currentEmployee=" + currentEmployee + ", salary=" + salary + ", loanAmount="
				+ loanAmount + ", loanType=" + loanType + "]";
	}

	public boolean isProcessed() {
		// TODO Auto-generated method stub
		return false;
	}

	public void setProcessed(boolean b) {
		// TODO Auto-generated method stub
		
	}
}
