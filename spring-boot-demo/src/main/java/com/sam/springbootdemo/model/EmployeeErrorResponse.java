package com.sam.springbootdemo.model;

import org.springframework.http.HttpStatus;

public class EmployeeErrorResponse {
	
	private String errorMessage;
    private HttpStatus status;
	public String getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	public HttpStatus getStatus() {
		return status;
	}
	public void setStatus(HttpStatus status) {
		this.status = status;
	}
    
    
}
