package com.albert.bs.service;

import java.util.Date;
import java.util.List;

import com.albert.bs.model.Order;

public interface OrderService {

	public void save(Order order);
	
	public int getDeliveriedOrdersCount(String userId);
	public List<Order> getDeliveriedOrders(String userId);

	public int getDeliveriedOrdersCount();
	public List<Order> getDeliveriedOrders();
	
	public int getNewOrdersCount();
	public List<Order> getNewOrders(int start, int count);
	
	public Order getOrder(String orderNumber);
	
	public int getOrdersCount(Date createTime);
	public List<Order> getOrders(Date createTime, int start, int count);
	
	public void deliver(String orderId);
	
	public void receive(String orderId);
	
	public List<Order> getUnDeliveredOrders(String userId);
	
	public int getFinishedOrdersCount(String userId);
	public List<Order> getFinishedOrders(String userId, int start, int count);
	

}
