package com.albert.bs.dao;

import java.util.Date;
import java.util.List;

import com.albert.bs.model.Order;

public interface OrderDao extends BaseDao<Order, String> {

	//获得某用户待确认订单总数
	public int getDeliveriedOrdersCount(String userId);
	//获得某用户待确认订单
	public List<Order> getDeliveriedOrders(String userId);
	
	//获得待确认订单总数
	public int getDeliveriedOrdersCount();
	//获得待确认订单
	public List<Order> getDeliveriedOrders();
	
	//获得新订单总数
	public int getNewOrdersCount();
	//获得新订单(按购买时间升序排列)
	public List<Order> getNewOrders(int start, int count);
	
	//通过订单号查询
	public Order getOrder(String orderNumber);
	
	//获得某天的订单总数
	public int getOrdersCount(Date createTime);
	//获得某天的订单
	public List<Order> getOrders(Date createTime, int start, int count);
	
	//发货
	public void deliver(String orderId);
	
	//确认收货
	public void receive(String orderId);
	
	//获得待发货订单
	public List<Order> getUnDeliveredOrders(String userId);
	
	//获得已完成交易的订单
	public int getFinishedOrdersCount(String userId);
	public List<Order> getFinishedOrders(String userId, int start, int count);
	
	
}
