package com.albert.bs.user.action.user;

import java.util.List;
import java.util.Map;

import com.albert.bs.model.Book;
import com.albert.bs.model.SessionContainer;
import com.albert.bs.service.BookService;
import com.albert.bs.service.OrderItemService;
import com.albert.bs.service.OrderService;
import com.albert.bs.user.action.UserAction;
import com.opensymphony.xwork2.ActionContext;

public class HomePageAction extends UserAction {
	private static final long serialVersionUID = 7030167140966541702L;
	
	private OrderItemService orderItemService;
	private BookService bookService;
	private OrderService orderService;
	
	@SuppressWarnings("unchecked")
	public String execute() throws Exception {
		Map session = ActionContext.getContext().getSession();
		Map request = (Map) ActionContext.getContext().get("request");
		SessionContainer container = (SessionContainer) session.get("container");
		int deliveriedOrderCount = orderService.getDeliveriedOrdersCount(container.getUser().getUserId());
		int finishedOrdersCount = orderItemService.getFinishedOrdersCount(container.getUser().getUserId());
		
		//重点图书推荐：根据用户之前购买图书较多的类别查找销量较高的图书  ,如没有或不够12本，则添加畅销书
		List<Book> books = bookService.getEmphasisBooks(container.getUser().getUserId(), 0, 12);
		if(books.size() < 12) {
			int count = 12 - books.size();
			List<Book> bestSellBooks = bookService.findBestSellBooks(0, count);
			books.addAll(bestSellBooks);
		}
		request.put("deliveriedOrderCount", deliveriedOrderCount);
		request.put("finishedOrdersCount", finishedOrdersCount);
		request.put("books", books);
		return SUCCESS;
	}

	public OrderItemService getOrderItemService() {
		return orderItemService;
	}
	public void setOrderItemService(OrderItemService orderItemService) {
		this.orderItemService = orderItemService;
	}
	public BookService getBookService() {
		return bookService;
	}
	public void setBookService(BookService bookService) {
		this.bookService = bookService;
	}
	public OrderService getOrderService() {
		return orderService;
	}
	public void setOrderService(OrderService orderService) {
		this.orderService = orderService;
	}
	
}
