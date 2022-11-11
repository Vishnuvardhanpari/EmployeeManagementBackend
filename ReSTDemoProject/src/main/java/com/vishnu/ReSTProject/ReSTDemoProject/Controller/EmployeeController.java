package com.vishnu.ReSTProject.ReSTDemoProject.Controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.vishnu.ReSTProject.ReSTDemoProject.ExceptionHandling.EmployeeErrorResponse;
import com.vishnu.ReSTProject.ReSTDemoProject.ExceptionHandling.EmployeeNotFound;
import com.vishnu.ReSTProject.ReSTDemoProject.Model.Employee;
import com.vishnu.ReSTProject.ReSTDemoProject.services.EmployeeService;

@RestController
public class EmployeeController {
	
	public EmployeeService employeeService;
	
	public EmployeeController (EmployeeService employeeService) {
		this.employeeService=employeeService;
	}
	
	@GetMapping("/getall")
	public List<Employee> getAll(){
		return this.employeeService.getAllEmployee();
	}
	
	@PostMapping("/saveempl")
	public ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee){
		
		if(employee.isNull()) {
			throw new EmployeeNotFound("Please enter a valid Employee");
		}
		
		return new ResponseEntity<Employee>(this.employeeService.saveEmployee(employee),HttpStatus.CREATED);
	}
	
	@GetMapping("/get/{id}")
	public ResponseEntity<Employee> getbyId(@PathVariable("id") int id){
		return new ResponseEntity<Employee>(this.employeeService.getEmplbyId(id),HttpStatus.CREATED);
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<Employee> updatebyId(@RequestBody Employee employee,@PathVariable("id") int id){
		return new ResponseEntity<Employee>(this.employeeService.updateEmployee(employee,id), HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{id}")
	public  ResponseEntity<String> deletebyId(@PathVariable("id") int id){
		this.employeeService.deleteEmployee(id);
		
		return new ResponseEntity<String>("Deleted Successfully",HttpStatus.OK);
	}
	
	
	
	
	
}
