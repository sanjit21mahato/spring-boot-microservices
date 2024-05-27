package com.sam.gateway.apigateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;



@SpringBootApplication
/*@CircuitBreaker(name="order-service", fallbackMethod="fallbackOrderService")*/
public class ApiGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiGatewayApplication.class, args);
	}
	
	@GetMapping("/fallbackOrderService")
	public String fallbackOrderService(Exception ex){
		
		return "Order Service is down";
		
	}

}
