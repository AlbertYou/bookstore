package com.albert.bs.user.action.comment;

import java.util.Map;

import com.albert.bs.model.OrderItem;
import com.albert.bs.service.OrderItemService;
import com.albert.bs.user.action.UserAction;
import com.opensymphony.xwork2.ActionContext;

/**
 * 跳转到添加评论页面
 * @author Albert
 *
 */
public class ToAddCommentAction extends UserAction {
	private static final long serialVersionUID = -928758594486793611L;
	
	private String itemId;
	private OrderItemService orderItemService;
	
	@SuppressWarnings("unchecked")
	public String execute() throws Exception {
		Map request = (Map) ActionContext.getContext().get("request");
		OrderItem orderItem = orderItemService.findById(itemId);
		request.put("orderItem", orderItem);
		return SUCCESS;
	}

	public String getItemId() {
		return itemId;
	}
	public void setItemId(String itemId) {
		this.itemId = itemId;
	}
	public OrderItemService getOrderItemService() {
		return orderItemService;
	}
	public void setOrderItemService(OrderItemService orderItemService) {
		this.orderItemService = orderItemService;
	}
	
}
