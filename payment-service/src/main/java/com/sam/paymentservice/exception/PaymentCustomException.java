package com.sam.paymentservice.exception;

public class PaymentCustomException extends RuntimeException{
	
	private String errorCode;
	PaymentCustomException(String message, String errorCode){
	 super(message);
	 this.errorCode=errorCode;
	}

}
