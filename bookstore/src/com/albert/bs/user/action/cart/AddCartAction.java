package com.albert.bs.user.action.cart;

import java.util.List;
import java.util.Map;

import com.albert.bs.model.Book;
import com.albert.bs.model.Cart;
import com.albert.bs.model.Product;
import com.albert.bs.model.SessionContainer;
import com.albert.bs.service.ProductService;
import com.albert.bs.user.action.UserAction;
import com.opensymphony.xwork2.ActionContext;

public class AddCartAction extends UserAction {
	private static final long serialVersionUID = -3429382993581128981L;
	
	private String bookId;
	private ProductService productService;
	
	@SuppressWarnings("unchecked")
	public String execute() throws Exception {
		SessionContainer container = null;
		Map session = ActionContext.getContext().getSession();
		if(session.get("container") == null) {
			container = new SessionContainer();
		} else {
			container = (SessionContainer) session.get("container");
		}
		Cart cart = container.getCart();
		if(cart == null) {
			cart = new Cart();
		}
		List<Product> products = cart.getProducts();
		int flag = 0;
		for (Product product : products) {   //判断之前有没有添加过该书到购物车中,否则会出现重复
			if(product.getBook().getBookId().equals(bookId)) { //重复了，把该商品数量加1
				product.setQuantity(product.getQuantity() + 1);
				if(container.getUser() != null && container.getUser().getUserId() != null) { //用户已登录
					 productService.changeQuantity(product);
				}
				cart.setProducts(products);
				flag = 1;
				break;
			}
		}
		if(flag == 0) { //没有重复
			Product p = new Product();
			p.setBook(new Book(bookId));
			if(container.getUser() != null && container.getUser().getUserId() != null) { //用户已登录
				p.setUser(container.getUser());
				p = productService.add(p);
			}
			cart.getProducts().add(p);
		}
		container.setCart(cart);
		session.put("container", container);
		
		if(container.getUser() == null || container.getUser().getUserId() == null || container.getUser().getUserId().equals("")) { //用户未登录
			Map request = (Map) ActionContext.getContext().get("request");
			request.put("bookId", bookId);
			return "bookinfo";
		}
		return SUCCESS;
	}

	public String getBookId() {
		return bookId;
	}
	public void setBookId(String bookId) {
		this.bookId = bookId;
	}
	public ProductService getProductService() {
		return productService;
	}
	public void setProductService(ProductService productService) {
		this.productService = productService;
	}

}
