package com.albert.bs.service;

import java.util.List;

import com.albert.bs.model.Product;

public interface ProductService {

	public Product findById(String productId);
	
	public List<Product> getProducts(String userId);
	
	public void deleteProducts(String userId);
	
	public Product add(Product product);
	
	public void delete(Product product);
	
	public void changeQuantity(Product product);
	
}
