package com.vishnu.ReSTProject.ReSTDemoProject.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vishnu.ReSTProject.ReSTDemoProject.ExceptionHandling.EmployeeNotFound;
import com.vishnu.ReSTProject.ReSTDemoProject.Model.Employee;
import com.vishnu.ReSTProject.ReSTDemoProject.repository.EmployeeRepository;
import com.vishnu.ReSTProject.ReSTDemoProject.services.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService{

	private EmployeeRepository employeeRepository;
	
	@Autowired
	public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
		this.employeeRepository=employeeRepository;
	}
	
	@Override
	public Employee saveEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}

	@Override
	public List<Employee> getAllEmployee() {
		return employeeRepository.findAll();
	}

	@Override
	public Employee getEmplbyId(int id) {
		Optional<Employee> employee = employeeRepository.findById(id);
		
		if(employee.isPresent()) {
			return employee.get();
		}
		else {
			throw new EmployeeNotFound("Not a valid ID "+id);
		}
	}

	
	@Override
	public Employee updateEmployee(Employee employee, int id) {
		
		Optional<Employee> existingOptEmp = this.employeeRepository.findById(id);
		
		if(existingOptEmp.isPresent()) {
			Employee existingEmp= existingOptEmp.get();
			existingEmp.setFirstName(employee.getFirstName());
			existingEmp.setLastName(employee.getLastName());
			existingEmp.setEmail(employee.getEmail());
			
			this.employeeRepository.save(existingEmp);
			
			return existingEmp;
		}
		else {
			throw new EmployeeNotFound(id+" is not a valid ID ");
		}
		
		
	}

	@Override
	public void deleteEmployee(int id) {
		Optional<Employee> employee = employeeRepository.findById(id);
		
		if(!employee.isPresent()) {
			
			throw new EmployeeNotFound("Not a valid ID "+id);
		}
		
		this.employeeRepository.deleteById(id);
		
	}
	

	
	

}
