package com.sam.orderservice.external;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;

@FeignClient(name="product-services/product")
public interface IFeignProductServiceInterface {
	
	@PutMapping("/reducePoductQuantity/{productId}/{quantity}")
	public ResponseEntity<Long> reducePoductQuantity(@PathVariable("productId") long productId,
			@PathVariable("quantity") long quantity);
	

}
