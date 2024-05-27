package com.sam.orderservice.service;

import java.time.Instant;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.sam.orderservice.entity.OrderEntity;
import com.sam.orderservice.external.IFeignPaymentServiceInterface;
import com.sam.orderservice.external.IFeignProductServiceInterface;
import com.sam.orderservice.external.Payment;
import com.sam.orderservice.external.Product;
import com.sam.orderservice.model.Order;
import com.sam.orderservice.repository.IOrderServiceRespository;

import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
public class OrderServceImplementation implements IOrderService{

	@Autowired
	private IOrderServiceRespository orderServiceRepository;
	
	@Autowired
	private IFeignProductServiceInterface productService;
	
	@Autowired
	private IFeignPaymentServiceInterface paymentService;
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Override
	public long placeOrder(Order order) {
		log.info("Start placeOrder of OrderServceImplementation: {}",order );
		
		//Order Srevice: Save the order enitity with order status as placed
		
		OrderEntity entity = new OrderEntity();
		BeanUtils.copyProperties(order, entity);
		entity.setOrderStatus("PLACED");
		entity.setOrderDate(Instant.now());
		entity.setPaymentMode(order.getPaymentMode().toString());
		entity =orderServiceRepository.save(entity);
		
		//Product Service: Reduce the product quantity 
		log.info("Start calling productService.reducePoductQuantity from method {} inside {}", "placeOrder","OrderServceImplementation");
		 ResponseEntity<Long> productId =productService.reducePoductQuantity(entity.getProductId(), entity.getQuantity());
		
		//Payment Service: payment success ---complete else cancelled
		 log.info("Starting saving of payment from method {} order serivce", "placeOrder");
		 Payment payment= Payment.builder().
				 amount(order.getAmount()).
				 orderId(order.getOrderId()).
				 paymentMode(order.getPaymentMode()).build();
		 try{
		 paymentService.doPayment(payment);
		 log.info("Payment Done successfully");
		 
		 }catch(Exception ex){
			 log.info("Payment failed");
			 entity.setOrderStatus("FAILED");
		 }
		 
		 //Update Order status based on payment
		 entity =orderServiceRepository.save(entity);
			
		log.info("End placeOrder of OrderServceImplementation: {}", entity.getOrderId() );
		return entity.getOrderId(); 
		
	}
	
	
	@Override
	public Order getOrderDetails(Long orderId) {
		log.info("Start of getOrderDetails inside OrderServiceImplementation");
		OrderEntity orderEntity = orderServiceRepository.getById(orderId);
		Order order = new Order();
		BeanUtils.copyProperties(orderEntity, order);

		// Now along with Order we also need Product details for that order,
		// So we need to call Product Service from Order Service, we will use
		// RESTTemplate
        log.info("Invoking product service to get Product in Order Service");
		Product product = restTemplate.getForObject(
				"http://product-services/product/getProductById/" + orderEntity.getProductId(), Product.class);
		
		order.setProduct(product);
		
		 log.info("Invoking payment service to get Payment details in Order Service");
		 Payment payment = restTemplate.getForObject(
				 "http://payment-service/payment/getPaymentDetailsByOrderId/"+ orderEntity.getOrderId(), Payment.class);
		 order.setPayment(payment);
		log.info("End of getOrderDetails inside OrderServiceImplementation");
		return order;
	}
}
