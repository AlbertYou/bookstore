package com.albert.bs.user.action.order;

import com.albert.bs.service.OrderService;
import com.albert.bs.user.action.UserAction;

/**
 * 确认收货
 * @author Albert
 *
 */
public class ReceiveBookAction extends UserAction {
	private static final long serialVersionUID = 2168123725318491803L;
	
	private String orderId;
	private OrderService orderService;
	
	public String execute() throws Exception {
		orderService.receive(orderId);
		return SUCCESS;
	}

	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	public OrderService getOrderService() {
		return orderService;
	}
	public void setOrderService(OrderService orderService) {
		this.orderService = orderService;
	}

}
