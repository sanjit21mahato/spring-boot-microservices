package com.sam.paymentservice.service;

import com.sam.paymentservice.model.Payment;

public interface IPaymentService {

	public long doPayment(Payment payment);

	public Payment getPaymentDetailsByOrderId(long orderId);

}
