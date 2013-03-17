package com.albert.bs.admin.action.order;

import java.util.List;
import java.util.Map;

import com.albert.bs.model.Order;
import com.albert.bs.model.Paginate;
import com.albert.bs.service.OrderService;
import com.albert.bs.user.action.UserAction;
import com.opensymphony.xwork2.ActionContext;

/**
 * 所有待确认订单
 * @author Albert
 *
 */
public class DeliveredOrdersListAction extends UserAction {
	private static final long serialVersionUID = 4419641557185971504L;
	
	private Integer page_index;
	private OrderService orderService;
	
	@SuppressWarnings("unchecked")
	public String execute() throws Exception {
		Map request = (Map) ActionContext.getContext().get("request");
		Paginate<Order> orders = new Paginate<Order>();
		if(page_index == null || page_index == 0) {
			page_index = 1;
		}
		orders.setCurrentPage(page_index);
		orders.setRecordInPage(10);
		orders.setAllRecords(orderService.getDeliveriedOrdersCount());
		orders.setAllPages((orders.getAllRecords() - 1) / orders.getRecordInPage() + 1);
		List<Order> list = orderService.getDeliveriedOrders();
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
