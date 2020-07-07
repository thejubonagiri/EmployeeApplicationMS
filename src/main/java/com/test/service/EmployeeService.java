package com.test.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.entity.Employee;
import com.test.repository.EmployeeRepository;



@Service
public class EmployeeService {
	
	@Autowired
	private EmployeeRepository repository;
	
	/*
	 * private static List<Employee> employees; static { employees = new
	 * ArrayList<>(); Employee emp = new Employee(1, "Theja" , "Hyderabad");
	 * Employee emp1 = new Employee(2, "Deepak" , "Chennai"); Employee emp2 = new
	 * Employee(3, "Atharv" , "Bangalore"); employees.add(emp); employees.add(emp1);
	 * employees.add(emp2); }
	 */
	
	
	public List<Employee> getAllEmployeeDetails()
	{
		List<Employee> employees = new ArrayList<>();
		Iterator<Employee> it = repository.findAll().iterator();
		
		while( it.hasNext() )
		{
			employees.add(it.next());
		}
		
		return employees;
	}
	
	public Employee createEmployeeDetails(Employee employee)
	{
		return  repository.save(employee);
		
	}
	
	
	public Employee getEmployeebasedonId(int employeeId)
	{
		return repository.findById(employeeId).orElse(null);
					
	}
	
	public Employee updateEmployeeDetails(Employee employee)
	{
		
		return repository.save(employee);
		
	}
	
	public Employee deleteEmployeeDetails(int employeeId)
	{
		Employee employee = getEmployeebasedonId(employeeId);
		repository.deleteById(employeeId);
		return employee;
		
	}
	
	@PostConstruct
	public void fillEmployeeTable()
	{
		Employee emp1 = new Employee(1, "theju", "chennai");
		Employee emp2 = new Employee(2, "Deepu", "hyderabad");
		
		repository.save(emp1);
		repository.save(emp2);
	}

}
