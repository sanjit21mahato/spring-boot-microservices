package com.sam.orderservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.sam.orderservice.external.ProductErrorResponse;

@ControllerAdvice
public class GlobalOrderServiceExceptionHandler extends ResponseEntityExceptionHandler{

	@ExceptionHandler(ProductServiceCustomException.class)
	public ResponseEntity<ProductErrorResponse> exceptionHandler(ProductServiceCustomException exception){
		ProductErrorResponse errorResponse = ProductErrorResponse.builder()
				                            .errorMessage(exception.getMessage())
				                            .errorCode(exception.getErrorCode()).build();
				return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
		
	}
}
