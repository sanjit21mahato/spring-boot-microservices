package com.sam.productservices.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.sam.productservices.model.ProductErrorResponse;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler{

	@ExceptionHandler(ProductServiceCustomeException.class)
	public ResponseEntity<ProductErrorResponse> handleException(ProductServiceCustomeException exception){
		ProductErrorResponse productErrorResponse = ProductErrorResponse.builder()
				.errorMessage(exception.getMessage())
				.status(HttpStatus.NOT_FOUND)
				.errorCode(exception.getErrorCode()).build() ;
		
		return new ResponseEntity<ProductErrorResponse>(productErrorResponse, HttpStatus.NOT_FOUND);
	} 
}
