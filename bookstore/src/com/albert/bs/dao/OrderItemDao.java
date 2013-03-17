package com.albert.bs.dao;

import java.util.List;

import com.albert.bs.model.OrderItem;

public interface OrderItemDao extends BaseDao<OrderItem, String> {

	//获得今天卖出的书的总数
	public int getTodayCount();

	//获得某本书的购买人气
	public int getCountByBook(String bookId);
	
	//获得待评价订单总数
	public int getFinishedOrdersCount(String userId);
	//获得待评价订单
	public List<OrderItem> getFinishedOrders(String userId);
	
	//评价
	public void comment(String itemId);
	
}
