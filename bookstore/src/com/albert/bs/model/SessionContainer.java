package com.albert.bs.model;

/**
 * the session container
 * 
 * @author Albert
 * @version V1.0 2012-03-25
 * @since JDK5.0
 */
public class SessionContainer {

	private User user; //当前用户
	private Admin admin; //当前管理员
	private Cart cart; //购物车
//	private Recipient recipient; //收货地址
	private String validationCode; //验证码

	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Admin getAdmin() {
		return admin;
	}
	public void setAdmin(Admin admin) {
		this.admin = admin;
	}
	public Cart getCart() {
		return cart;
	}
	public void setCart(Cart cart) {
		this.cart = cart;
	}
//	public Recipient getRecipient() {
//		return recipient;
//	}
//	public void setRecipient(Recipient recipient) {
//		this.recipient = recipient;
//	}
	public String getValidationCode() {
		return validationCode;
	}
	public void setValidationCode(String validationCode) {
		this.validationCode = validationCode;
	}

}
