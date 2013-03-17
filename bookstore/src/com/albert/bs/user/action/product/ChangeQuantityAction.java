package com.albert.bs.user.action.product;

import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

import org.apache.struts2.ServletActionContext;

import net.sf.json.JSONObject;

import com.albert.bs.model.Product;
import com.albert.bs.model.SessionContainer;
import com.albert.bs.service.BookService;
import com.albert.bs.service.ProductService;
import com.albert.bs.user.action.UserAction;
import com.opensymphony.xwork2.ActionContext;

public class ChangeQuantityAction extends UserAction {
	private static final long serialVersionUID = 1586028529641935715L;
	
	private String productId;
	private Integer quantity;
	private ProductService productService;
	private BookService bookService;
	
	@SuppressWarnings("unchecked")
	public String execute() throws Exception {
		Product product = new Product(productId);
		Map session = ActionContext.getContext().getSession();
		SessionContainer container = (SessionContainer) session.get("container");
		List<Product> products = container.getCart().getProducts();
		JSONObject json = new JSONObject();
		for (Product p : products) {
			if(p.getProductId().equals(productId)) {
				//判断库存
				if(quantity <= p.getBook().getStock()) {
					p.setQuantity(quantity);
					product.setQuantity(quantity);
					productService.changeQuantity(product);
				} else {					
					json.put("stock", p.getBook().getStock());
				}
				break;
			}
		}
		session.put("container", container);
		PrintWriter writer = ServletActionContext.getResponse().getWriter();
		try {
			writer.write(json.toString());
		} finally {
			writer.flush();
			writer.close();
		}
		return null;
	}

	public void validate() {
		if(quantity == null || quantity <1) {
			this.addActionError(getText("buybook.quantity.error"));
		}
	}
	
	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	public ProductService getProductService() {
		return productService;
	}
	public void setProductService(ProductService productService) {
		this.productService = productService;
	}
	public BookService getBookService() {
		return bookService;
	}
	public void setBookService(BookService bookService) {
		this.bookService = bookService;
	}

}
