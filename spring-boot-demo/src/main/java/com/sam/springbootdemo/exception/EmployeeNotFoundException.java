package com.sam.springbootdemo.exception;

public class EmployeeNotFoundException extends RuntimeException{

	public EmployeeNotFoundException(String errorMessage){
		super(errorMessage);
	}
}
