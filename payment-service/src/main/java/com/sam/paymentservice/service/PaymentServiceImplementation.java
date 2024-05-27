package com.sam.paymentservice.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sam.paymentservice.entity.PaymentEntity;
import com.sam.paymentservice.model.Payment;
import com.sam.paymentservice.repository.IPaymentServiceRepository;

import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
public class PaymentServiceImplementation implements IPaymentService{

	@Autowired
	private IPaymentServiceRepository paymentRepository;
	
	@Override
	public long doPayment(Payment payment) {
		
	  log.info("Start of doPayment inside PaymentServiceImplementation");
	  PaymentEntity entity = PaymentEntity.builder().
			  orderId(payment.getOrderId()).
			  referenceNumber(payment.getReferenceNumber()).
			  amount(payment.getAmount()).
			  paymentMode(payment.getPaymentMode().name())
			  .status("SUCCESS").build();
	     entity = paymentRepository.save(entity);
	     
	     log.info("End of doPayment inside PaymentServiceImplementation");
	     return entity.getId();
	}
	
	@Override
	public Payment getPaymentDetailsByOrderId(long orderId) {
		log.info("Start of getPaymentDetailsByOrderId");
		PaymentEntity paymentEntity = new PaymentEntity();
		paymentEntity = paymentRepository.findByOrderId(orderId);
		Payment payment = new Payment();
		BeanUtils.copyProperties(paymentEntity, payment);
		return payment;
	}
}
