package com.albert.bs.user.action.user;

import java.util.Map;

import com.albert.bs.model.SessionContainer;
import com.albert.bs.service.OrderItemService;
import com.albert.bs.service.OrderService;
import com.albert.bs.user.action.UserAction;
import com.opensymphony.xwork2.ActionContext;

public class ToEditUserAction extends UserAction {
	private static final long serialVersionUID = 2725450628124085908L;
	
	private OrderItemService orderItemService;
	private OrderService orderService;
	
	@SuppressWarnings("unchecked")
	public String execute() throws Exception {
		Map session = ActionContext.getContext().getSession();
		Map request = (Map) ActionContext.getContext().get("request");
		SessionContainer container = (SessionContainer) session.get("container");
		int deliveriedOrderCount = orderService.getDeliveriedOrdersCount(container.getUser().getUserId());
		int finishedOrdersCount = orderItemService.getFinishedOrdersCount(container.getUser().getUserId());
		request.put("deliveriedOrderCount", deliveriedOrderCount);
		request.put("finishedOrdersCount", finishedOrdersCount);
		return SUCCESS;
	}

	public OrderItemService getOrderItemService() {
		return orderItemService;
	}
	public void setOrderItemService(OrderItemService orderItemService) {
		this.orderItemService = orderItemService;
	}
	public OrderService getOrderService() {
		return orderService;
	}
	public void setOrderService(OrderService orderService) {
		this.orderService = orderService;
	}
	
}
