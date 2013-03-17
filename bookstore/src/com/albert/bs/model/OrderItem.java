package com.albert.bs.model;

import java.io.Serializable;

import com.albert.bs.constant.OrderItemStatus;

/**
 * 订单详细
 * 
 * @author Albert
 * @version V1.0 2012-03-25
 * @since JDK5.0
 */
public class OrderItem implements Serializable{
	private static final long serialVersionUID = -7474123606099738191L;
	
	private String itemId;
	private Order order; //订单
	private Book book; //图书
	private Integer discount; //折扣(例如：76折)
	private Double price; //销售价格
	private Integer quantity; //数量
	private Integer isCommented = OrderItemStatus.NOT_COMMENTED; //是否被评论了(1：是；0：否）
	
	public OrderItem() {
		
	}
	public OrderItem(String itemId) {
		this.itemId = itemId;
	}
	public OrderItem(String itemId, Order order, Book book, Integer discount,
			Double price, Integer quantity, Integer isCommented) {
		super();
		this.itemId = itemId;
		this.order = order;
		this.book = book;
		this.discount = discount;
		this.price = price;
		this.quantity = quantity;
		this.isCommented = isCommented;
	}
	public String getItemId() {
		return itemId;
	}
	public void setItemId(String itemId) {
		this.itemId = itemId;
	}
	public Order getOrder() {
		return order;
	}
	public void setOrder(Order order) {
		this.order = order;
	}
	public Book getBook() {
		return book;
	}
	public void setBook(Book book) {
		this.book = book;
	}
	public Integer getDiscount() {
		return discount;
	}
	public void setDiscount(Integer discount) {
		this.discount = discount;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	public Integer getIsCommented() {
		return isCommented;
	}
	public void setIsCommented(Integer isCommented) {
		this.isCommented = isCommented;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((book == null) ? 0 : book.hashCode());
		result = prime * result
				+ ((discount == null) ? 0 : discount.hashCode());
		result = prime * result
				+ ((isCommented == null) ? 0 : isCommented.hashCode());
		result = prime * result + ((itemId == null) ? 0 : itemId.hashCode());
		result = prime * result + ((order == null) ? 0 : order.hashCode());
		result = prime * result + ((price == null) ? 0 : price.hashCode());
		result = prime * result
				+ ((quantity == null) ? 0 : quantity.hashCode());
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
		OrderItem other = (OrderItem) obj;
		if (book == null) {
			if (other.book != null)
				return false;
		} else if (!book.equals(other.book))
			return false;
		if (discount == null) {
			if (other.discount != null)
				return false;
		} else if (!discount.equals(other.discount))
			return false;
		if (isCommented == null) {
			if (other.isCommented != null)
				return false;
		} else if (!isCommented.equals(other.isCommented))
			return false;
		if (itemId == null) {
			if (other.itemId != null)
				return false;
		} else if (!itemId.equals(other.itemId))
			return false;
		if (order == null) {
			if (other.order != null)
				return false;
		} else if (!order.equals(other.order))
			return false;
		if (price == null) {
			if (other.price != null)
				return false;
		} else if (!price.equals(other.price))
			return false;
		if (quantity == null) {
			if (other.quantity != null)
				return false;
		} else if (!quantity.equals(other.quantity))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "OrderItem [book=" + book + "]";
	}
	
}
