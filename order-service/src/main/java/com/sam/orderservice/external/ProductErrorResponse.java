package com.sam.orderservice.external;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductErrorResponse {
	private String errorMessage;
	private String errorCode;
	private HttpStatus status;
	
	

}

