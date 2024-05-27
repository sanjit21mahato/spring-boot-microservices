package com.sam.productservices.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sam.productservices.model.Product;
import com.sam.productservices.service.IProductServices;


@RestController
@RequestMapping("/product")
public class ProductController {
	
	@Autowired
	private IProductServices productServices;

	@PostMapping("/addProduct")
	public ResponseEntity<Product> addProduct(@RequestBody Product product){
		
		product =productServices.addProduct(product);
		return new ResponseEntity<Product>(product, HttpStatus.CREATED);
		
	}
	
	@GetMapping("/getProductById/{productId}")
	public ResponseEntity<Product> getProductById(@PathVariable("productId") long productId){
		Product product = new Product();
		product= productServices.getProductById(productId);
		return new ResponseEntity<Product>(product, HttpStatus.FOUND);
		
	}
	
	@GetMapping("/getProducts")
	public ResponseEntity <List<Product>> getProducts(){
		List<Product> productList = new ArrayList<>();
		productList= productServices.getProducts();
		return new ResponseEntity<List<Product>>(productList, HttpStatus.FOUND);
		
	}
	
	@PutMapping("/reducePoductQuantity/{productId}/{quantity}")
	public ResponseEntity<Long> reducePoductQuantity(@PathVariable("productId") long productId,
			@PathVariable("quantity") long quantity){
		productId= productServices.reducePoductQuantity(productId, quantity);
		return new ResponseEntity<Long>(productId, HttpStatus.OK);
		
	}
	
}
