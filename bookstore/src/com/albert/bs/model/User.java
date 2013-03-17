package com.albert.bs.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * 用户
 * 
 * @author Albert
 * @version V1.0 2012-03-25
 * @since JDK5.0
 */
public class User implements Serializable {
	private static final long serialVersionUID = -5342578716911937065L;
	
	private String userId;
	private String username; //用户名
	private String email; //邮箱
	private String password; //密码
	private Integer sex; //性别
	private String phone; //手机
	private Integer status; //状态(0：正常;1：封杀)
	private Set<Recipient> recipients = new HashSet<Recipient>(); //收货地址
	private Set<Collect> collects = new HashSet<Collect>(); //用户收藏
	private Set<Comment> comments = new HashSet<Comment>(); //用户收藏
	private Set<Order> orders = new HashSet<Order>(); //用户订单
	
	public User() {
		
	}
	public User(String userId) {
		this.userId = userId;
	}
	public User(String userId, String username, String email, String password,
			Integer sex, String phone, Integer status,
			Set<Recipient> recipients, Set<Collect> collects,
			Set<Comment> comments, Set<Order> orders) {
		super();
		this.userId = userId;
		this.username = username;
		this.email = email;
		this.password = password;
		this.sex = sex;
		this.phone = phone;
		this.status = status;
		this.recipients = recipients;
		this.collects = collects;
		this.comments = comments;
		this.orders = orders;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Integer getSex() {
		return sex;
	}
	public void setSex(Integer sex) {
		this.sex = sex;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public Set<Recipient> getRecipients() {
		return recipients;
	}
	public void setRecipients(Set<Recipient> recipients) {
		this.recipients = recipients;
	}
	public Set<Collect> getCollects() {
		return collects;
	}
	public void setCollects(Set<Collect> collects) {
		this.collects = collects;
	}
	public Set<Comment> getComments() {
		return comments;
	}
	public void setComments(Set<Comment> comments) {
		this.comments = comments;
	}
	public Set<Order> getOrders() {
		return orders;
	}
	public void setOrders(Set<Order> orders) {
		this.orders = orders;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result
				+ ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((phone == null) ? 0 : phone.hashCode());
		result = prime * result + ((sex == null) ? 0 : sex.hashCode());
		result = prime * result + ((userId == null) ? 0 : userId.hashCode());
		result = prime * result
				+ ((username == null) ? 0 : username.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (phone == null) {
			if (other.phone != null)
				return false;
		} else if (!phone.equals(other.phone))
			return false;
		if (sex == null) {
			if (other.sex != null)
				return false;
		} else if (!sex.equals(other.sex))
			return false;
		if (userId == null) {
			if (other.userId != null)
				return false;
		} else if (!userId.equals(other.userId))
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "User [username=" + username + "]";
	}
	
}
