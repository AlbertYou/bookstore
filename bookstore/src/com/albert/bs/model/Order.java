package com.albert.bs.model;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import com.albert.bs.constant.OrderStatus;

/**
 * 订单
 * 
 * @author Albert
 * @version V1.0 2012-03-25
 * @since JDK5.0
 */
public class Order implements Serializable {
	private static final long serialVersionUID = -3391593795451310637L;
	
	private String orderId;
	private String orderNumber; //订单号
	private User user; //用户
	private Integer count; //订单条目数量
	private Double totalPrice; //订单总额
	private Recipient recipient; //收货人
	private Date createTime; //订单生成时间
	private Date deliveryTime; //发货时间
	private Integer status = OrderStatus.UNDELIVERIED; //订单状态（1：未发货；2：已发货；3：已完成）
	private Set<OrderItem> orderItems = new HashSet<OrderItem>();; //订单详细
	
	public Order() {
		
	}
	public Order(String orderId) {
		this.orderId = orderId;
	}
	public Order(String orderId, String orderNumber, User user, Integer count,
			Double totalPrice, Recipient recipient, Date createTime,
			Date deliveryTime, Integer status, Set<OrderItem> orderItems) {
		super();
		this.orderId = orderId;
		this.orderNumber = orderNumber;
		this.user = user;
		this.count = count;
		this.totalPrice = totalPrice;
		this.recipient = recipient;
		this.createTime = createTime;
		this.deliveryTime = deliveryTime;
		this.status = status;
		this.orderItems = orderItems;
	}
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	public String getOrderNumber() {
		return orderNumber;
	}
	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}
	public Double getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(Double totalPrice) {
		this.totalPrice = totalPrice;
	}
	public Recipient getRecipient() {
		return recipient;
	}
	public void setRecipient(Recipient recipient) {
		this.recipient = recipient;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public Date getDeliveryTime() {
		return deliveryTime;
	}
	public void setDeliveryTime(Date deliveryTime) {
		this.deliveryTime = deliveryTime;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public Set<OrderItem> getOrderItems() {
		return orderItems;
	}
	public void setOrderItems(Set<OrderItem> orderItems) {
		this.orderItems = orderItems;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((count == null) ? 0 : count.hashCode());
		result = prime * result
				+ ((createTime == null) ? 0 : createTime.hashCode());
		result = prime * result
				+ ((deliveryTime == null) ? 0 : deliveryTime.hashCode());
		result = prime * result + ((orderId == null) ? 0 : orderId.hashCode());
		result = prime * result
				+ ((recipient == null) ? 0 : recipient.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result
				+ ((totalPrice == null) ? 0 : totalPrice.hashCode());
		result = prime * result + ((user == null) ? 0 : user.hashCode());
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
		Order other = (Order) obj;
		if (count == null) {
			if (other.count != null)
				return false;
		} else if (!count.equals(other.count))
			return false;
		if (createTime == null) {
			if (other.createTime != null)
				return false;
		} else if (!createTime.equals(other.createTime))
			return false;
		if (deliveryTime == null) {
			if (other.deliveryTime != null)
				return false;
		} else if (!deliveryTime.equals(other.deliveryTime))
			return false;
		if (orderId == null) {
			if (other.orderId != null)
				return false;
		} else if (!orderId.equals(other.orderId))
			return false;
		if (recipient == null) {
			if (other.recipient != null)
				return false;
		} else if (!recipient.equals(other.recipient))
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		if (totalPrice == null) {
			if (other.totalPrice != null)
				return false;
		} else if (!totalPrice.equals(other.totalPrice))
			return false;
		if (user == null) {
			if (other.user != null)
				return false;
		} else if (!user.equals(other.user))
			return false;
		return true;
	}
	@Override
	public String toString() {
		StringBuffer str = new StringBuffer("Order [orderItems=");
		for (OrderItem orderItem : orderItems) {
			str.append(orderItem.toString() + ",");
		}
		str.append(" recipient=" + recipient + "]");
		return str.toString();
	}
	
}
