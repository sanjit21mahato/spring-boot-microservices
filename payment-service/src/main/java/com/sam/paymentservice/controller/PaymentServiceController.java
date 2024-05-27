package com.sam.paymentservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sam.paymentservice.model.Payment;
import com.sam.paymentservice.service.IPaymentService;

@RestController
@RequestMapping("/payment")
public class PaymentServiceController {

	@Autowired
	private IPaymentService paymentService;
	
	@PostMapping("/doPayment")
	public ResponseEntity<Long> doPayment(@RequestBody Payment payment){
		
		long id= paymentService.doPayment(payment);
		return new ResponseEntity<>(id, HttpStatus.OK);
	}
	
	@GetMapping("getPaymentDetailsByOrderId/{orderId}")
	public ResponseEntity<Payment> getPaymentDetailsByOrderId(@PathVariable("orderId") Long orderId){
		
		return new ResponseEntity<>(paymentService.getPaymentDetailsByOrderId(orderId), HttpStatus.FOUND);
	}
}
