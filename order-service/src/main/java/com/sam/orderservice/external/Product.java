package com.sam.orderservice.external;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Product {
	private long productId;
	private String productName;
	private long price;
	private long quantity;
	

}
