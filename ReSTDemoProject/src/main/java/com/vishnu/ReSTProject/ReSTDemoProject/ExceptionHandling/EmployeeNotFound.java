package com.vishnu.ReSTProject.ReSTDemoProject.ExceptionHandling;

public class EmployeeNotFound extends RuntimeException {

	public EmployeeNotFound(String message, Throwable cause) {
		super(message, cause);
		
	}

	public EmployeeNotFound(String message) {
		super(message);
		
	}

	public EmployeeNotFound(Throwable cause) {
		super(cause);
		
	}

}
