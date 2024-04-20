package com.sam.orderservice.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sam.orderservice.entity.OrderEntity;
import com.sam.orderservice.model.Order;
import com.sam.orderservice.repository.IOrderServiceRespository;

@Service
public class OrderServceImplementation implements IOrderService{

	@Autowired
	private IOrderServiceRespository orderServiceRepository;
	
	@Override
	public Order placeOrder(Order order) {
		OrderEntity entity = new OrderEntity();
		BeanUtils.copyProperties(order, entity);
		entity =orderServiceRepository.save(entity);
		BeanUtils.copyProperties(entity, order);
		return order;
	}
}
