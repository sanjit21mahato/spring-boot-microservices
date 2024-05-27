package com.sam.productservices.service;

import java.util.List;

import com.sam.productservices.model.Product;

public interface IProductServices {

	public Product addProduct(Product product);

	public Product getProductById(long productId);

	public List<Product> getProducts();

	public long reducePoductQuantity(long productId, long quantity);

}
