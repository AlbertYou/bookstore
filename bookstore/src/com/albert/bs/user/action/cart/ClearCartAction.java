package com.albert.bs.user.action.cart;

import java.util.Map;

import com.albert.bs.model.SessionContainer;
import com.albert.bs.service.ProductService;
import com.albert.bs.user.action.UserAction;
import com.opensymphony.xwork2.ActionContext;

public class ClearCartAction extends UserAction {
	private static final long serialVersionUID = -1103455461606978894L;
	
	private ProductService productService;
	
	@SuppressWarnings("unchecked")
	public String execute() throws Exception {
		Map session = ActionContext.getContext().getSession();
		SessionContainer container = (SessionContainer) session.get("container");
		container.getCart().setProducts(null);
		session.put("container", container);
		productService.deleteProducts(container.getUser().getUserId());
		return SUCCESS;
	}

	public ProductService getProductService() {
		return productService;
	}
	public void setProductService(ProductService productService) {
		this.productService = productService;
	}

}
