package com.albert.bs.user.action.collect;

import java.util.List;
import java.util.Map;

import com.albert.bs.model.Cart;
import com.albert.bs.model.Collect;
import com.albert.bs.model.Product;
import com.albert.bs.model.SessionContainer;
import com.albert.bs.service.CollectService;
import com.albert.bs.service.ProductService;
import com.albert.bs.user.action.UserAction;
import com.opensymphony.xwork2.ActionContext;

/**
 * 从购物车中移入收藏
 * @author Albert
 *
 */
public class MoveToCollectAction extends UserAction {
	private static final long serialVersionUID = 8464023015430268952L;

	private String productId;
	private ProductService productService;
	private CollectService collectService;
	
	@SuppressWarnings("unchecked")
	public String execute() throws Exception {
		Map session = ActionContext.getContext().getSession();
		SessionContainer container = (SessionContainer) session.get("container");
		Cart cart = container.getCart();
		List<Product> products = cart.getProducts();
		Product product = productService.findById(productId);
		product.setUser(container.getUser()); //因为user使用了懒加载
		
		//判断收藏中是否已有该商品
		boolean exist = collectService.isCollected(container.getUser().getUserId(), product.getBook().getBookId());
		if(!exist) { //加入收藏
			Collect collect = new Collect();
			collect.setUser(container.getUser());
			collect.setBook(product.getBook());
			collectService.save(collect);
		}
		productService.delete(product);  //在购物车中删除该商品
		Product pr = null;
		for (Product p : products) {
			if(p.getProductId().equals(product.getProductId())) {
				pr = p;
				break;
			}
		}
		if(pr != null) {
			products.remove(pr);				
		}
		cart.setProducts(products);
		container.setCart(cart);
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
	public CollectService getCollectService() {
		return collectService;
	}
	public void setCollectService(CollectService collectService) {
		this.collectService = collectService;
	}
	
}
