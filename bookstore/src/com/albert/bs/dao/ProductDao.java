package com.albert.bs.dao;

import java.util.List;

import com.albert.bs.model.Product;

public interface ProductDao extends BaseDao<Product, String> {
	
	//获得某用户的购物车内容
	public List<Product> getProducts(String userId);
	
	//获得某用户的购物车内容
	public void deleteProducts(String userId);
	
	public Product add(Product product);
	
	public void changeQuantity(Product product);
	
}
