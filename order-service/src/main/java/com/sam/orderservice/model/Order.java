package com.sam.orderservice.model;

import java.time.Instant;

import com.sam.orderservice.external.Payment;
import com.sam.orderservice.external.Product;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Order {

	private long orderId;
	private long amount;
	private long productId;
	private String orderStatus;
	private long quantity;
	private Instant orderDate;
	private PaymentMode paymentMode;
	private Product product;
	private Payment payment; 
	
}
