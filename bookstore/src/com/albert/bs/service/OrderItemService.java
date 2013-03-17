package com.albert.bs.service;

import java.util.List;

import com.albert.bs.model.OrderItem;

public interface OrderItemService {

	public OrderItem findById(String itemId);
	
	public int getTodayCount();
	
	public int getCountByBook(String bookId);
	
	public int getFinishedOrdersCount(String userId);
	public List<OrderItem> getFinishedOrders(String userId);

	public void comment(String itemId);
	
}
