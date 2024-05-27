package com.sam.orderservice.external;

import java.io.IOException;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sam.orderservice.exception.ProductServiceCustomException;

import feign.Response;
import feign.codec.ErrorDecoder;

@Component
public class ProductServiceCustomErrorDecoder implements ErrorDecoder{
	
	@Override
	public Exception decode(String methodKey, Response errorResponse) {

        ObjectMapper mapper = new ObjectMapper();
        ProductErrorResponse productErrorResponse = new ProductErrorResponse();
        try {
			productErrorResponse =mapper.readValue(errorResponse.body().asInputStream(), ProductErrorResponse.class);
		     
			return new ProductServiceCustomException(productErrorResponse.getErrorMessage(),productErrorResponse.getErrorCode());
        
        }/* catch (RuntimeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (DatabindException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/ catch (IOException e) {
			throw new ProductServiceCustomException("Internal Server Error","INTERNAL_ERROR");
		}        
		
	}

}
