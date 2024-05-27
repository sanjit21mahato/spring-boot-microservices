package com.sam.gateway.apigateway.fallback;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/fallback")
public class FallBackController {
	
	@GetMapping("/fallbackOrderService")
	public String fallbackOrderService(Exception ex){
		
		return "Order Service is down";
		
	}

}
