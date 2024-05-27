package com.sam.orderservice.entity;

import java.time.Instant;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.sam.orderservice.model.Order;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="ORDER_DETAILS")
public class OrderEntity {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long orderId;
	private long amount;
	private long productId;
	private String orderStatus;
	private long quantity;
	private Instant orderDate;
	private String paymentMode;
	
}
