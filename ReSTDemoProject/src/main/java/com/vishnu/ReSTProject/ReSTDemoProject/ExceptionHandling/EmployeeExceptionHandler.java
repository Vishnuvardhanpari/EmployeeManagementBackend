package com.vishnu.ReSTProject.ReSTDemoProject.ExceptionHandling;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class EmployeeExceptionHandler {
	
	@ExceptionHandler
	public ResponseEntity<EmployeeErrorResponse> handleException (EmployeeNotFound employeeNotFound){
		EmployeeErrorResponse error = new EmployeeErrorResponse();
		
		error.setMessage(employeeNotFound.getMessage());
		
		error.setStatus(HttpStatus.NOT_ACCEPTABLE.value());
		
		error.setTimeStamp(System.currentTimeMillis());
		
		return new ResponseEntity<EmployeeErrorResponse>(error,HttpStatus.NOT_ACCEPTABLE);
		
	}
	
	@ExceptionHandler
	public ResponseEntity<EmployeeErrorResponse> handleException (Exception exc){
		EmployeeErrorResponse error = new EmployeeErrorResponse();
		
		error.setMessage(exc.getMessage());
		
		error.setStatus(HttpStatus.NOT_ACCEPTABLE.value());
		
		error.setTimeStamp(System.currentTimeMillis());
		
		return new ResponseEntity<EmployeeErrorResponse>(error,HttpStatus.NOT_ACCEPTABLE);
		
	}
	
	
}
