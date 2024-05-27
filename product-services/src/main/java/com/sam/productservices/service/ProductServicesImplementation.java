package com.sam.productservices.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sam.productservices.entity.ProductEntity;
import com.sam.productservices.exception.ProductServiceCustomException;
import com.sam.productservices.model.Product;
import com.sam.productservices.repository.IProductRepository;

import lombok.Builder;
import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
public class ProductServicesImplementation implements IProductServices{

	@Autowired
	private IProductRepository productRepository;

	@Override
	public Product addProduct(Product product) {
		log.info("Entering add product() of ProductServicesImplementation");

		ProductEntity productEntity = ProductEntity.builder().price(product.getPrice())
				.productName(product.getProductName()).quantity(product.getQuantity()).build();

		productEntity = productRepository.save(productEntity);
		BeanUtils.copyProperties(productEntity, product);
		return product;
	}
	
	@Override
	public Product getProductById(long productId) {
		log.info("inside get productById()");
		Product product = new Product();
		ProductEntity productEntity = productRepository.findById(productId).
				 orElseThrow(()->new ProductServiceCustomException("Product is not found for the id:"+productId , "PRODUCT_NOT_FOUND"));
		
		BeanUtils.copyProperties(productEntity, product);
		return product;
	}
	
	
	@Override
	public List<Product> getProducts() {
		List<Product> productList = new ArrayList<>();
		List<ProductEntity> productEntityList = productRepository.findAll();
		productList =productEntityList.stream().map(productEntity->{
			Product product = new Product();
			BeanUtils.copyProperties(productEntity, product);
			return product;
		}).collect(Collectors.toList());
	
		return productList;
	}
	
	@Override
	public long reducePoductQuantity(long productId, long quantity) {

		log.info("Reduce Qunatity of Product Id: {} by {} ", productId, quantity);
		ProductEntity productEntity = productRepository.findById(productId)
				.orElseThrow(() -> new ProductServiceCustomException("Product is not found for the id:" + productId,
						"PRODUCT_NOT_FOUND"));

		long currentQuantity = productEntity.getQuantity();
		if (currentQuantity < quantity) {
			throw new ProductServiceCustomException("Product does not have sufficient quantity",
					"INSUFFICIENT_QUANTITY");
		}
		long reducedQuantity = currentQuantity - quantity;
		productEntity.setQuantity(reducedQuantity);

		productRepository.save(productEntity);
		log.info("Reduce Qunatity of Product is successful");
		return productEntity.getProductId();
	}
}
