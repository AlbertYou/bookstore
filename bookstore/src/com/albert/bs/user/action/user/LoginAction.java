package com.albert.bs.user.action.user;

import java.util.List;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.albert.bs.constant.UserStatus;
import com.albert.bs.model.Cart;
import com.albert.bs.model.Product;
import com.albert.bs.model.SessionContainer;
import com.albert.bs.model.User;
import com.albert.bs.service.ProductService;
import com.albert.bs.service.UserService;
import com.albert.bs.user.action.UserAction;
import com.albert.bs.util.MD5Util;
import com.opensymphony.xwork2.ActionContext;

public class LoginAction extends UserAction {
	private static final long serialVersionUID = -4357525212351724516L;

	private String username;
	private String password;
	private String validcode;
	private String rememberPsw;
	private UserService userService;
	private ProductService productService;
	
	@SuppressWarnings("unchecked")
	public String execute() throws Exception {
		Map session = ActionContext.getContext().getSession();
		SessionContainer container = (SessionContainer) session.get("container");
		String vc = container.getValidationCode();
		if(vc != null && !validcode.equalsIgnoreCase(vc)) {
			this.addFieldError("validcode", getText("validationcode.error"));
			return LOGIN;
		}
		User user = userService.login(username, MD5Util.encrypt(password));
		if(user != null && user.getStatus() != null && user.getStatus() == UserStatus.STOPPED) {
			this.addActionError(getText("user.stopped"));
			return LOGIN;
		}
		if(user != null && user.getUserId() != null && !user.getUserId().equals("")) { //登录成功
			container.setUser(user);
			//获得购物车
			Cart cart = container.getCart();
			if(cart == null) {
				cart = new Cart();
			}
			List<Product> products = cart.getProducts(); //得到登录前加入购物车的商品
			
			List<Product> oldProducts = productService.getProducts(user.getUserId()); //得到以前加入购物车的商品
			if(oldProducts.size() > 0) {
				if(cart == null) {
					cart = new Cart();
				}
			}
			cart.setProducts(oldProducts); //把以前加入购物车的商品放入购物车中，同时在购物车中删除了登录前加入购物车的商品，即此时购物车中只有以前加入购物车的商品
			int flag = 0;
			if(products.size() > 0) { //登录前有把商品加入购物车
				for (Product product : products) {   //把登录前加入购物车的商品加入购物车，同时添加到数据库中
					//遍历购物车商品，判断是否有重复商品
					for (Product op : oldProducts) {
						if(product.getBook().getBookId().equals(op.getBook().getBookId())) {  //有重复，数量累加
							op.setQuantity(op.getQuantity() + product.getQuantity());
							productService.changeQuantity(op);
							cart.setProducts(oldProducts);
							flag = 1;
						}
					}
					if(flag == 0) { //没有重复
						product.setUser(container.getUser());
						productService.add(product);
						cart.getProducts().add(product);
					}
				}
			}
			container.setCart(cart);
			session.put("container", container);
			if(rememberPsw != null && rememberPsw.equals("yes")) { //记住密码，下次自动登录
				addCookie("userId", user.getUserId());
			}
			String lastUrl = (String) session.get("lastUrl");
			if(lastUrl != null && !lastUrl.equals("")) { //登录成功后，跳转到登录之前的页面
				HttpServletResponse response = ServletActionContext.getResponse();
				session.put("lastUrl", null);
				String lastUrlParam = (String) session.get("lastUrlParam");
				if(lastUrlParam != null && !lastUrlParam.equals("")) {
					session.put("lastUrlParam", null);
					response.sendRedirect(lastUrl + lastUrlParam);
				} else {
					response.sendRedirect(lastUrl);
				}
				return null;
			}
			return SUCCESS;
		} else {
			this.addActionError(getText("nameorpsw.error"));
		}
		return LOGIN;
	}

	public void addCookie(String name, String value) {
		Cookie cookie = new Cookie(name, value);
		cookie.setMaxAge(365 * 24 * 60 * 60);
		ServletActionContext.getResponse().addCookie(cookie);
	}
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getValidcode() {
		return validcode;
	}
	public void setValidcode(String validcode) {
		this.validcode = validcode;
	}
	public String getRememberPsw() {
		return rememberPsw;
	}
	public void setRememberPsw(String rememberPsw) {
		this.rememberPsw = rememberPsw;
	}
	public UserService getUserService() {
		return userService;
	}
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	public ProductService getProductService() {
		return productService;
	}
	public void setProductService(ProductService productService) {
		this.productService = productService;
	}
	
}
