package com.sam.paymentservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sam.paymentservice.entity.PaymentEntity;

@Repository
public interface IPaymentServiceRepository extends JpaRepository<PaymentEntity, Long>{

	public PaymentEntity findByOrderId(long orderId);

	
}
