package com.albert.bs.serviceimpl;

import java.util.Date;
import java.util.List;

import com.albert.bs.dao.OrderDao;
import com.albert.bs.model.Order;
import com.albert.bs.service.OrderService;

public class OrderServiceImpl implements OrderService {

	private OrderDao dao;

	public void save(Order order) {
		dao.save(order);
	}
	public int getDeliveriedOrdersCount(String userId) {
		return dao.getDeliveriedOrdersCount(userId);
	}
	public List<Order> getDeliveriedOrders(String userId) {
		return dao.getDeliveriedOrders(userId);
	}
	public int getDeliveriedOrdersCount() {
		return dao.getDeliveriedOrdersCount();
	}
	public List<Order> getDeliveriedOrders() {
		return dao.getDeliveriedOrders();
	}
	public List<Order> getNewOrders(int start, int count) {
		return dao.getNewOrders(start, count);
	}
	public int getNewOrdersCount() {
		return dao.getNewOrdersCount();
	}
	public Order getOrder(String orderNumber) {
		return dao.getOrder(orderNumber);
	}
	public int getOrdersCount(Date createTime) {
		return dao.getOrdersCount(createTime);
	}
	public List<Order> getOrders(Date createTime, int start, int count) {
		return dao.getOrders(createTime, start, count);
	}
	public void deliver(String orderId) {
		dao.deliver(orderId);
	}
	public void receive(String orderId) {
		dao.receive(orderId);
	}
	public List<Order> getUnDeliveredOrders(String userId) {
		return dao.getUnDeliveredOrders(userId);
	}
	public int getFinishedOrdersCount(String userId) {
		return dao.getFinishedOrdersCount(userId);
	}
	
	public List<Order> getFinishedOrders(String userId, int start, int count) {
		return dao.getFinishedOrders(userId, start, count);
	}
	
	public OrderDao getDao() {
		return dao;
	}
	public void setDao(OrderDao dao) {
		this.dao = dao;
	}
	
}
