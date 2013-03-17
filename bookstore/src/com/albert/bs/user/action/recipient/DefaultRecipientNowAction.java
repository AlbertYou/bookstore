package com.albert.bs.user.action.recipient;

import java.util.List;
import java.util.Map;

import com.albert.bs.model.Book;
import com.albert.bs.model.Recipient;
import com.albert.bs.model.SessionContainer;
import com.albert.bs.service.BookService;
import com.albert.bs.service.RecipientService;
import com.albert.bs.user.action.UserAction;
import com.opensymphony.xwork2.ActionContext;

public class DefaultRecipientNowAction extends UserAction {
	private static final long serialVersionUID = -4510708794621936951L;
	
	private Integer bookCount;
	private String bookId;
	private String recipientId;
	private BookService bookService;
	private RecipientService recipientService;

	//立刻购买->确认订单的页面中的设为默认地址功能，跳转到立刻购买之后确认订单页面
	@SuppressWarnings("unchecked")
	public String execute() throws Exception {
		Map request = (Map) ActionContext.getContext().get("request");
		Map session = ActionContext.getContext().getSession();
		SessionContainer container = (SessionContainer) session.get("container");
		recipientService.setDefault(container.getUser().getUserId(), recipientId);
		Book book = bookService.findById(bookId);
		List<Recipient> recipients = recipientService.findAll(container.getUser().getUserId());
		request.put("recipients", recipients);
		request.put("book", book);
		request.put("bookCount", bookCount);
		return SUCCESS;
	}

	public Integer getBookCount() {
		return bookCount;
	}
	public void setBookCount(Integer bookCount) {
		this.bookCount = bookCount;
	}
	public String getBookId() {
		return bookId;
	}
	public void setBookId(String bookId) {
		this.bookId = bookId;
	}
	public String getRecipientId() {
		return recipientId;
	}
	public void setRecipientId(String recipientId) {
		this.recipientId = recipientId;
	}
	public RecipientService getRecipientService() {
		return recipientService;
	}
	public void setRecipientService(RecipientService recipientService) {
		this.recipientService = recipientService;
	}
	public BookService getBookService() {
		return bookService;
	}
	public void setBookService(BookService bookService) {
		this.bookService = bookService;
	}
}
