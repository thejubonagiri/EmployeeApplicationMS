package com.test.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.test.entity.Employee;
import com.test.model.EmployeePOJO;
import com.test.model.EmployeeRequest;
import com.test.model.EmployeeResponse;
import com.test.service.EmployeeService;

@RestController
public class EmployeeController {
	
	@Autowired
	private EmployeeService service;
	
	
	@GetMapping(value = "/employees" )
	public EmployeeResponse getAllEmployeeDetails ()
	{
		List<Employee> employees = service.getAllEmployeeDetails();
		
		List<EmployeePOJO> employeePojos = new ArrayList<>();
		
		for( Employee emp : employees )
		{
			EmployeePOJO employeePojo = new EmployeePOJO(emp.getEmployeeId(), emp.getEmployeeName(), emp.getAddress());
			employeePojos.add(employeePojo);
		}
		
		return new EmployeeResponse(employeePojos);
	}
	
	@PostMapping(value = "/employees" )
	public EmployeeResponse createEmployeeDetails (@RequestBody EmployeeRequest request)
	{
		Employee employee = new Employee(request.getEmployeePojo().getEmployeeId(), request.getEmployeePojo().getEmployeeName(), request.getEmployeePojo().getAddress());
		Employee createdEmployee = service.createEmployeeDetails(employee);
		if( createdEmployee != null )
		{
			EmployeePOJO employeePojo = new EmployeePOJO(createdEmployee.getEmployeeId(), createdEmployee.getEmployeeName(), createdEmployee.getAddress());
			return new EmployeeResponse( Arrays.asList(employeePojo) );
		}
		return null;
	}
	
	@GetMapping(value = "/employees/{id}" )
	public EmployeeResponse getEmployeebasedonId(@PathVariable("id")int employeeId)
	{
		Employee employee = service.getEmployeebasedonId(employeeId);
		EmployeePOJO employeePojo = new EmployeePOJO(employee.getEmployeeId(), employee.getEmployeeName(), employee.getAddress());
		return new EmployeeResponse( Arrays.asList(employeePojo) );
		
	}
	
	@PutMapping(value = "/employees" )
	public EmployeeResponse updateEmployeeDetails(@RequestBody EmployeeRequest request)
	{
		Employee employee = new Employee(request.getEmployeePojo().getEmployeeId(), request.getEmployeePojo().getEmployeeName(), request.getEmployeePojo().getAddress());
		Employee updatedEmployee = service.updateEmployeeDetails(employee);
		EmployeePOJO employeePojo = new EmployeePOJO(updatedEmployee.getEmployeeId(), updatedEmployee.getEmployeeName(), updatedEmployee.getAddress());
		return new EmployeeResponse(Arrays.asList( employeePojo));
	}
	
	@DeleteMapping(value = "/employees/{id}" )
	public EmployeeResponse deleteEmployeeDetails(@PathVariable("id")int employeeId)
	{
		Employee employee = service.deleteEmployeeDetails(employeeId);
		EmployeePOJO employeePojo = new EmployeePOJO(employee.getEmployeeId(), employee.getEmployeeName(), employee.getAddress());
		return new EmployeeResponse(Arrays.asList(employeePojo));
	}

}
