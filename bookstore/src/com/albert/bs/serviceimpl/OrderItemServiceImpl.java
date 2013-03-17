package com.albert.bs.serviceimpl;

import java.util.List;

import com.albert.bs.dao.OrderItemDao;
import com.albert.bs.model.OrderItem;
import com.albert.bs.service.OrderItemService;

public class OrderItemServiceImpl implements OrderItemService {

	private OrderItemDao dao;

	public OrderItem findById(String itemId) {
		return dao.findById(itemId);
	}
	
	public int getTodayCount() {
		return dao.getTodayCount();
	}

	public int getCountByBook(String bookId) {
		return dao.getCountByBook(bookId);
	}
	
	public List<OrderItem> getFinishedOrders(String userId) {
		return dao.getFinishedOrders(userId);
	}
	
	public int getFinishedOrdersCount(String userId) {
		return dao.getFinishedOrdersCount(userId);
	}
	
	public void comment(String itemId) {
		dao.comment(itemId);
	}
	
	public OrderItemDao getDao() {
		return dao;
	}
	public void setDao(OrderItemDao dao) {
		this.dao = dao;
	}

}
