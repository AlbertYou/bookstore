package com.albert.bs.admin.action.order;

import java.util.Map;

import com.albert.bs.admin.action.AdminAction;
import com.albert.bs.model.Order;
import com.albert.bs.service.OrderService;
import com.opensymphony.xwork2.ActionContext;

/**
 * 订单查询
 * @author Albert
 *
 */
public class QueryOrderAction extends AdminAction {
	private static final long serialVersionUID = 6440396779950342059L;

	private String orderNumber;
	private OrderService orderService;

	@SuppressWarnings("unchecked")
	public String execute() throws Exception {
		if(orderNumber != null && !orderNumber.equals("")) {
			Map request = (Map) ActionContext.getContext().get("request");
			Order order = orderService.getOrder(orderNumber);
			request.put("order", order);
		}
		return SUCCESS;
	}
	
	public String getOrderNumber() {
		return orderNumber;
	}
	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}
	public OrderService getOrderService() {
		return orderService;
	}
	public void setOrderService(OrderService orderService) {
		this.orderService = orderService;
	}
	
}
