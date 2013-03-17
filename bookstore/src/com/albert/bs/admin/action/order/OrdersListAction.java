package com.albert.bs.admin.action.order;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.albert.bs.admin.action.AdminAction;
import com.albert.bs.model.Order;
import com.albert.bs.model.Paginate;
import com.albert.bs.service.OrderService;
import com.opensymphony.xwork2.ActionContext;

/**
 * 所有订单
 * @author Albert
 *
 */
public class OrdersListAction extends AdminAction {
	private static final long serialVersionUID = 86283257939232189L;

	private Integer page_index;
	private String createTime; //订单创建时间
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
		Date ct;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		if(createTime != null && !createTime.equals("")) {
			ct = sdf.parse(createTime);
		} else {
			ct = new Date();
			createTime = sdf.format(ct);
		}
		orders.setAllRecords(orderService.getOrdersCount(ct));
		orders.setAllPages((orders.getAllRecords() - 1) / orders.getRecordInPage() + 1);
		List<Order> list = orderService.getOrders(ct, (orders.getCurrentPage() - 1) * orders.getRecordInPage(), orders.getRecordInPage());
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
	public String getCreateTime() {
		return createTime;
	}
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	public OrderService getOrderService() {
		return orderService;
	}
	public void setOrderService(OrderService orderService) {
		this.orderService = orderService;
	}
	
}
