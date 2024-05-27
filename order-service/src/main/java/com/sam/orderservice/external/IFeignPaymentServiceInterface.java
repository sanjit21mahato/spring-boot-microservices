package com.sam.orderservice.external;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@FeignClient(name="payment-service/payment")
public interface IFeignPaymentServiceInterface {
	
	
	@PostMapping("/doPayment")
	public ResponseEntity<Long> doPayment(@RequestBody Payment payment);

}
