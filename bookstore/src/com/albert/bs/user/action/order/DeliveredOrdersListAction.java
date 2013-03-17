package com.albert.bs.user.action.order;

import java.util.List;
import java.util.Map;

import com.albert.bs.model.Order;
import com.albert.bs.model.SessionContainer;
import com.albert.bs.service.OrderService;
import com.albert.bs.user.action.UserAction;
import com.opensymphony.xwork2.ActionContext;

/**
 * 待确认订单
 * @author Albert
 *
 */
public class DeliveredOrdersListAction extends UserAction {
	private static final long serialVersionUID = -6258632879830886950L;

	private OrderService orderService;
	
	@SuppressWarnings("unchecked")
	public String execute() throws Exception {
		Map session = ActionContext.getContext().getSession();
		Map request = (Map) ActionContext.getContext().get("request");
		SessionContainer container = (SessionContainer) session.get("container");
		List<Order> orders = orderService.getDeliveriedOrders(container.getUser().getUserId());
		request.put("orders", orders);
		return SUCCESS;
	}

	public OrderService getOrderService() {
		return orderService;
	}
	public void setOrderService(OrderService orderService) {
		this.orderService = orderService;
	}
	
}
