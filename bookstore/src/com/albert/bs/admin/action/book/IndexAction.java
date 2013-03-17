package com.albert.bs.admin.action.book;

import java.util.Date;
import java.util.Map;

import com.albert.bs.admin.action.AdminAction;
import com.albert.bs.service.CommentService;
import com.albert.bs.service.OrderItemService;
import com.albert.bs.service.OrderService;
import com.opensymphony.xwork2.ActionContext;

public class IndexAction extends AdminAction {
	private static final long serialVersionUID = 904221352435174347L;

	private OrderService orderService;
	private CommentService commentService;
	private OrderItemService orderItemService;

	@SuppressWarnings("unchecked")
	public String execute() throws Exception {
		// 查询今天的销售量
		int bookCountSelled = orderItemService.getTodayCount();
		//今日评论总数
		int commentCount = commentService.getCommentCount(new Date());
		//新订单总数
		int orderCount = orderService.getNewOrdersCount();
		
		Map request = (Map) ActionContext.getContext().get("request");
		request.put("bookCountSelled", bookCountSelled);
		request.put("commentCount", commentCount);
		request.put("orderCount", orderCount);
		return SUCCESS;
	}

	public OrderService getOrderService() {
		return orderService;
	}
	public void setOrderService(OrderService orderService) {
		this.orderService = orderService;
	}
	public CommentService getCommentService() {
		return commentService;
	}
	public void setCommentService(CommentService commentService) {
		this.commentService = commentService;
	}
	public OrderItemService getOrderItemService() {
		return orderItemService;
	}
	public void setOrderItemService(OrderItemService orderItemService) {
		this.orderItemService = orderItemService;
	}

}
