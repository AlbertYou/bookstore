package com.albert.bs.user.action.book;

import java.util.List;
import java.util.Map;

import com.albert.bs.model.Book;
import com.albert.bs.model.Recipient;
import com.albert.bs.model.SessionContainer;
import com.albert.bs.service.BookService;
import com.albert.bs.service.RecipientService;
import com.albert.bs.user.action.UserAction;
import com.opensymphony.xwork2.ActionContext;

/**
 * 立刻购买
 * @author Albert
 *
 */
public class BuyBookAction extends UserAction {
	private static final long serialVersionUID = -1745435427907652812L;
	
	private Integer bookCount;
	private String bookId;
	private BookService bookService;
	private RecipientService recipientService;
	
	@SuppressWarnings("unchecked")
	public String execute() throws Exception {
		Map session = ActionContext.getContext().getSession();
		Map request = (Map) ActionContext.getContext().get("request");
		SessionContainer container = (SessionContainer) session.get("container");
		Book book = bookService.findById(bookId);
		List<Recipient> recipients = recipientService.findAll(container.getUser().getUserId());
		int stock = bookService.getStock(bookId);
		if(bookCount > stock) {
			bookCount = stock;
		}
		request.put("recipients", recipients);
		request.put("book", book);
		request.put("bookCount", bookCount);
		return SUCCESS;
	}

	public void validate() {
		if(bookCount == null || bookCount <1) {
			this.addActionError(getText("buybook.quantity.error"));
		}
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
	public BookService getBookService() {
		return bookService;
	}
	public void setBookService(BookService bookService) {
		this.bookService = bookService;
	}
	public RecipientService getRecipientService() {
		return recipientService;
	}
	public void setRecipientService(RecipientService recipientService) {
		this.recipientService = recipientService;
	}
	
}
