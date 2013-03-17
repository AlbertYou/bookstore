package com.albert.bs.daoimpl;

import java.util.List;

import org.hibernate.criterion.Property;
import org.hibernate.criterion.Restrictions;

import com.albert.bs.dao.ProductDao;
import com.albert.bs.model.Book;
import com.albert.bs.model.Product;

public class ProductDaoImpl extends BaseDaoImpl<Product, String> implements ProductDao {
	
	@SuppressWarnings("unchecked")
	public List<Product> getProducts(String userId) {
		return getSession(false).createCriteria(Product.class).add(Restrictions.eq("user.userId", userId)).list();
	}

	@SuppressWarnings("unchecked")
	public void deleteProducts(String userId) {
		List<String> productIds = getSession(false).createCriteria(Product.class).setProjection(Property.forName("productId")).add(Restrictions.eq("user.userId", userId)).list();
		for (String id : productIds) {
			getHibernateTemplate().delete(new Product(id));
		}
	}
	
	public Product add(Product product) {
		String productId = (String) getHibernateTemplate().save(product);
		product.setProductId(productId);
		Book book = (Book) getSession(false).createCriteria(Book.class).add(Restrictions.eq("bookId", product.getBook().getBookId())).list().get(0);
		product.setBook(book);
		return product;
	}
	
	public void delete(Product product) {
		product = (Product) getHibernateTemplate().load(Product.class, product.getProductId());
		getHibernateTemplate().delete(product);
	}
	
	public void changeQuantity(Product product) {
		Product p  = (Product) getHibernateTemplate().load(Product.class, product.getProductId());
		p.setQuantity(product.getQuantity());
		getHibernateTemplate().update(p);
	}
	
}
