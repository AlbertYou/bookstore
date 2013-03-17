package com.albert.bs.serviceimpl;

import java.util.List;

import com.albert.bs.dao.ProductDao;
import com.albert.bs.model.Product;
import com.albert.bs.service.ProductService;

public class ProductServiceImpl implements ProductService {

	private ProductDao dao;

	public Product findById(String productId) {
		return dao.findById(productId);
	}
	
	public Product add(Product product) {
		return dao.add(product);
	}

	public void delete(Product product) {
		dao.delete(product);
	}

	public List<Product> getProducts(String userId) {
		return dao.getProducts(userId);
	}

	public void deleteProducts(String userId) {
		dao.deleteProducts(userId);
	}
	
	public void changeQuantity(Product product) {
		dao.changeQuantity(product);
	}

	public ProductDao getDao() {
		return dao;
	}
	public void setDao(ProductDao dao) {
		this.dao = dao;
	}

}
