package com.sam.orderservice.service;

import com.sam.orderservice.model.Order;

public interface IOrderService {

	public long placeOrder(Order order);

	public Order getOrderDetails(Long orderId);

}
