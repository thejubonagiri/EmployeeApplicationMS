package com.test.entity;

import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
public class Employee {
	
	
	@Id
	private int employeeId;
	private String employeeName;
	private String  address;
	
	
	
	public Employee() {
		super();
	}



	public Employee(int employeeId, String employeeName, String address) {
		super();
		this.employeeId = employeeId;
		this.employeeName = employeeName;
		this.address = address;
	}



	public int getEmployeeId() {
		return employeeId;
	}



	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}



	public String getEmployeeName() {
		return employeeName;
	}



	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}



	public String getAddress() {
		return address;
	}



	public void setAddress(String address) {
		this.address = address;
	}
	
	

	
}
