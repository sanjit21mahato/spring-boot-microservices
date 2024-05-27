package com.sam.orderservice.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.sam.orderservice.external.ProductServiceCustomErrorDecoder;

import feign.codec.ErrorDecoder;

@Configuration
public class FeignConfig {
	/*@Bean
	ErrorDecoder errorDecoder(){
		return new ProductServiceCustomErrorDecoder();
	}*/

}
