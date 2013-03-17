package com.albert.bs.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * 购物车
 * 
 * @author Albert
 * @version V1.0 2012-03-25
 * @since JDK5.0
 */
public class Cart implements Serializable {
	private static final long serialVersionUID = -3813401432021916603L;
	
	private List<Product> products;
	
	public List<Product> getProducts() {
		if(products == null) {
			products = new ArrayList<Product>();
		}
		return products;
	}
	public void setProducts(List<Product> products) {
		this.products = products;
	}

}
