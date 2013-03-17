package com.albert.bs.user.action.order;

import java.util.Map;

import com.albert.bs.model.Book;
import com.albert.bs.model.Order;
import com.albert.bs.model.OrderItem;
import com.albert.bs.model.Recipient;
import com.albert.bs.model.SessionContainer;
import com.albert.bs.service.BookService;
import com.albert.bs.service.OrderService;
import com.albert.bs.user.action.UserAction;
import com.albert.bs.util.OrderNumberCreator;
import com.opensymphony.xwork2.ActionContext;

/**
 * 立刻购买->确认订单->提交订单
 * @author Albert
 *
 */
public class FinishOrderNowAction extends UserAction {
	private static final long serialVersionUID = -3993846012849364557L;
	
	private String recipientId;
	private String bookId;
	private Integer bookCount;
	private BookService bookService;
	private OrderService orderService;
	
	@SuppressWarnings("unchecked")
	public String execute() throws Exception {
		Map session = ActionContext.getContext().getSession();
		Map request = (Map) ActionContext.getContext().get("request");
		SessionContainer container = (SessionContainer) session.get("container");
		Book book = bookService.findById(bookId);
		if(bookCount <= book.getStock()) {
			Order order = new Order();
			String orderNumber = new OrderNumberCreator().produce();
			order.setOrderNumber(orderNumber);
			order.setUser(container.getUser());
			order.setRecipient(new Recipient(recipientId));
			order.setTotalPrice(book.getPrice() * bookCount);
			order.setCount(1);
			
			OrderItem oi = new OrderItem();
			oi.setBook(book);
			oi.setQuantity(bookCount);
			oi.setOrder(order);
			oi.setPrice(book.getPrice());
			oi.setDiscount(book.getDiscount());
			order.getOrderItems().add(oi);
			
			//修改库存
			bookService.modifyStock(book.getBookId(), book.getStock() - bookCount);
			orderService.save(order);
			request.put("orderNumber", orderNumber);
		}
		return SUCCESS;
	}

	public String getRecipientId() {
		return recipientId;
	}
	public void setRecipientId(String recipientId) {
		this.recipientId = recipientId;
	}
	public String getBookId() {
		return bookId;
	}
	public void setBookId(String bookId) {
		this.bookId = bookId;
	}
	public Integer getBookCount() {
		return bookCount;
	}
	public void setBookCount(Integer bookCount) {
		this.bookCount = bookCount;
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
