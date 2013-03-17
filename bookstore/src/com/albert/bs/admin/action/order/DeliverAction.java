package com.albert.bs.admin.action.order;

import com.albert.bs.admin.action.AdminAction;
import com.albert.bs.service.OrderService;

/**
 * 发货
 * @author Albert
 *
 */
public class DeliverAction extends AdminAction {
	private static final long serialVersionUID = -2286828951916013939L;
	
	private String orderId;
	private OrderService orderService;

	public String execute() throws Exception {
		orderService.deliver(orderId);
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
