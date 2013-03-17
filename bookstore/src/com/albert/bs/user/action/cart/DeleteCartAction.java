package com.albert.bs.user.action.cart;

import java.util.List;
import java.util.Map;

import com.albert.bs.model.Product;
import com.albert.bs.model.SessionContainer;
import com.albert.bs.service.ProductService;
import com.albert.bs.user.action.UserAction;
import com.opensymphony.xwork2.ActionContext;

public class DeleteCartAction extends UserAction {
	private static final long serialVersionUID = -3429382993581128981L;
	
	private String productId;
	private ProductService productService;
	
	@SuppressWarnings("unchecked")
	public String execute() throws Exception {
		productService.delete(new Product(productId));

		Map session = ActionContext.getContext().getSession();
		SessionContainer container = (SessionContainer) session.get("container");
		List<Product> products = container.getCart().getProducts();
		for (Product p : products) {
			if(p.getProductId().equals(productId)) {
				products.remove(p);
				break;
			}
		}
		session.put("container", container);
		return SUCCESS;
	}

	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
	public ProductService getProductService() {
		return productService;
	}
	public void setProductService(ProductService productService) {
		this.productService = productService;
	}

}
