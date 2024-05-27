package com.sam.orderservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.sam.orderservice.model.Order;
import com.sam.orderservice.service.IOrderService;

import lombok.extern.log4j.Log4j2;

@RestController
@Log4j2
@RequestMapping("/order")
public class OrderController {
	
	@Autowired
	private IOrderService orderService;
	
	@PostMapping("/placeOrder")
	public ResponseEntity<Long> placeOrder(@RequestBody Order order){
		
		long orderId =orderService.placeOrder(order);
		log.info("Order id: {} "+orderId);
		return new ResponseEntity<Long>(orderId,HttpStatus.OK);
	}
	
	@GetMapping("/getOrderDetails/{orderId}")
	public ResponseEntity<Order> getOrderDetails(@PathVariable("orderId") Long orderId){
		log.info("Start of getOrderDetails");
		Order order = new Order();
		order= orderService.getOrderDetails(orderId);
		return new ResponseEntity<Order>(order,HttpStatus.FOUND);
	}
	
	/*@Bean
	public RestTemplate restTemplate(){
		return new RestTemplate();
	}*/

}
