package com.albert.bs.user.action.order;

import java.util.List;
import java.util.Map;

import com.albert.bs.model.Order;
import com.albert.bs.model.Paginate;
import com.albert.bs.model.SessionContainer;
import com.albert.bs.service.OrderService;
import com.albert.bs.user.action.UserAction;
import com.opensymphony.xwork2.ActionContext;

/**
 * 交易成功的订单
 * @author Albert
 *
 */
public class FinishedOrdersListAction extends UserAction {
	private static final long serialVersionUID = 5824154436399401390L;
	
	private Integer page_index;
	private OrderService orderService;
	
	@SuppressWarnings("unchecked")
	public String execute() throws Exception {
		Map session = ActionContext.getContext().getSession();
		Map request = (Map) ActionContext.getContext().get("request");
		SessionContainer container = (SessionContainer) session.get("container");
		Paginate<Order> orders = new Paginate<Order>();
		if(page_index == null || page_index ==0) {
			page_index = 1;
		}
		orders.setCurrentPage(page_index);
		orders.setRecordInPage(10);
		orders.setAllRecords(orderService.getFinishedOrdersCount(container.getUser().getUserId()));
		orders.setAllPages((orders.getAllRecords() - 1) / orders.getRecordInPage() + 1);
		List<Order> list = orderService.getFinishedOrders(container.getUser().getUserId(), orders.getRecordInPage() * (orders.getCurrentPage() - 1), orders.getRecordInPage());
		orders.setList(list);
		request.put("orders", orders);
		return SUCCESS;
	}

	public Integer getPage_index() {
		return page_index;
	}
	public void setPage_index(Integer pageIndex) {
		page_index = pageIndex;
	}
	public OrderService getOrderService() {
		return orderService;
	}
	public void setOrderService(OrderService orderService) {
		this.orderService = orderService;
	}

}
