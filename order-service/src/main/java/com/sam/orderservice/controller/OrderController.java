package com.sam.orderservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sam.orderservice.model.Order;
import com.sam.orderservice.service.IOrderService;

@RestController
@RequestMapping("/order")
public class OrderController {
	
	@Autowired
	private IOrderService orderService;
	
	@GetMapping("/placeOrder")
	public ResponseEntity<Order> placeOrder(@RequestBody Order order){
		
		order =orderService.placeOrder(order);
		return new ResponseEntity<Order>(order,HttpStatus.OK);
	}

}
