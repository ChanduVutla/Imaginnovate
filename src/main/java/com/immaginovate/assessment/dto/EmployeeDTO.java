package com.immaginovate.assessment.dto;

import java.util.Date;
import java.util.List;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;


public class EmployeeDTO {
	
	@Override
	public String toString() {
		return "EmployeeDTO [employeeId=" + employeeId + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", email=" + email + ", phNumber=" + phNumber + ", doj=" + doj + ", salary=" + salary + ", taxAmount="
				+ taxAmount + ", cessAmount=" + cessAmount + "]";
	}
	@NotNull(message= "employeeId shouldn't be empty")
	private long employeeId;
	@NotBlank(message = "firstName shouldn't be empty")
	private String firstName;
	@NotBlank(message = "lastName shouldn't be empty")
	private String lastName;
	@Email(message = "email shouldn't be empty")
	private String email;
	@NotNull
	private List<String> phNumber;
	@NotNull(message = "doj shouldn't be empty")
	private Date doj;
	@NotNull(message = "salary shouldn't be empty")
	private double salary;

	private double taxAmount;
	 
	private double cessAmount;

	public long getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(long employeeId) {
		this.employeeId = employeeId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<String> getPhNumber() {
		return phNumber;
	}

	public void setPhNumber(List<String> phNumber) {
		this.phNumber = phNumber;
	}

	public Date getDoj() {
		return doj;
	}

	public void setDoj(Date doj) {
		this.doj = doj;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public double getTaxAmount() {
		return taxAmount;
	}

	public void setTaxAmount(double taxAmount) {
		this.taxAmount = taxAmount;
	}

	public double getCessAmount() {
		return cessAmount;
	}

	public void setCessAmount(double cessAmount) {
		this.cessAmount = cessAmount;
	}

	
}
