package com.albert.bs.admin.action.book;

import java.util.Map;

import com.albert.bs.admin.action.AdminAction;
import com.albert.bs.model.Book;
import com.albert.bs.service.BookService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ModelDriven;

public class ModifyBookAction extends AdminAction implements ModelDriven<Book> {
	private static final long serialVersionUID = -582926535055852791L;

	private Book book = new Book();
	private BookService bookService;
	
	@SuppressWarnings("unchecked")
	public String execute() throws Exception {
		bookService.update(book);
		Map request = (Map) ActionContext.getContext().get("request");
		request.put("bookId", book.getBookId());
		return SUCCESS;
	}
	
	public Book getBook() {
		return book;
	}
	public void setBook(Book book) {
		this.book = book;
	}
	public BookService getBookService() {
		return bookService;
	}
	public void setBookService(BookService bookService) {
		this.bookService = bookService;
	}
	public Book getModel() {
		return book;
	}

}
