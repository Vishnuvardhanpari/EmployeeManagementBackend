package com.vishnu.ReSTProject.ReSTDemoProject.services;

import java.util.List;

import com.vishnu.ReSTProject.ReSTDemoProject.Model.Employee;

public interface EmployeeService {

	Employee saveEmployee(Employee employee);
	
	List<Employee> getAllEmployee();
	
	Employee getEmplbyId(int id);
	
	Employee updateEmployee(Employee employee, int id);
	
	void deleteEmployee(int id);
}
