package com.sam.paymentservice.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Payment {
	
	private long id;
	private long orderId;
	private long amount;
	private String referenceNumber;
	private PaymentMode paymentMode;
	

}
