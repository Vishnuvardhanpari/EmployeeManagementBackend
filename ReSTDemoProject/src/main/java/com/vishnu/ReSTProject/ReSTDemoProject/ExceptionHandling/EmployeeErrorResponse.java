package com.vishnu.ReSTProject.ReSTDemoProject.ExceptionHandling;

public class EmployeeErrorResponse {	
	private int Status;
	private String message;
	private long timeStamp;	
	
	public EmployeeErrorResponse() {
		
	}
	public EmployeeErrorResponse(int status, String message, long timeStamp) {
		
		this.Status = status;
		this.message = message;
		this.timeStamp = timeStamp;
	}
	public int getStatus() {
		return Status;
	}
	public void setStatus(int status) {
		Status = status;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public long getTimeStamp() {
		return timeStamp;
	}
	public void setTimeStamp(long timeStamp) {
		this.timeStamp = timeStamp;
	}
	
}
