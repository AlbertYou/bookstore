package com.albert.bs.user.action.comment;

import java.util.List;
import java.util.Map;

import com.albert.bs.model.OrderItem;
import com.albert.bs.model.SessionContainer;
import com.albert.bs.service.OrderItemService;
import com.albert.bs.user.action.UserAction;
import com.opensymphony.xwork2.ActionContext;

/**
 * 待评价商品列表
 * @author Albert
 *
 */
public class NoCommentAction extends UserAction {
	private static final long serialVersionUID = 3298987805306509489L;

	private OrderItemService orderItemService;
	
	@SuppressWarnings("unchecked")
	public String execute() throws Exception {
		Map session = ActionContext.getContext().getSession();
		Map request = (Map) ActionContext.getContext().get("request");
		SessionContainer container = (SessionContainer) session.get("container");
		List<OrderItem> orderItems = orderItemService.getFinishedOrders(container.getUser().getUserId());
		request.put("orderItems", orderItems);
		return SUCCESS;
	}

	public OrderItemService getOrderItemService() {
		return orderItemService;
	}
	public void setOrderItemService(OrderItemService orderItemService) {
		this.orderItemService = orderItemService;
	}

}
