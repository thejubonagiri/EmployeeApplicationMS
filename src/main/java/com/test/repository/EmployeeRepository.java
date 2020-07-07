package com.test.repository;


import org.springframework.data.repository.CrudRepository;

import com.test.entity.Employee;

public interface EmployeeRepository extends CrudRepository<Employee , Integer> {
	
	
}
