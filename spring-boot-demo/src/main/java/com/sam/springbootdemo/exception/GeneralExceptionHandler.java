package com.sam.springbootdemo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.RestClientResponseException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.sam.springbootdemo.model.EmployeeErrorResponse;

@ControllerAdvice
public class GeneralExceptionHandler extends ResponseEntityExceptionHandler{

	@ExceptionHandler(EmployeeNotFoundException.class)
	public ResponseEntity<EmployeeErrorResponse> handleEmployeeException(EmployeeNotFoundException exception){
		EmployeeErrorResponse errorResponse = new EmployeeErrorResponse();
		errorResponse.setErrorMessage(exception.getMessage());
		errorResponse.setStatus(HttpStatus.NOT_FOUND);
		return new ResponseEntity<EmployeeErrorResponse>(errorResponse, HttpStatus.NOT_FOUND);
	}
	
	
	//general exception to handle any Runtime Exception
	@ExceptionHandler(RuntimeException.class)
	public ResponseEntity<EmployeeErrorResponse> handleEmployeeException(RuntimeException exception){
		EmployeeErrorResponse errorResponse = new EmployeeErrorResponse();
		errorResponse.setErrorMessage(exception.getMessage());
		errorResponse.setStatus(HttpStatus.INTERNAL_SERVER_ERROR);
		return new ResponseEntity<EmployeeErrorResponse>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
