package com.albert.bs.admin.action.book;

import com.albert.bs.admin.action.AdminAction;
import com.albert.bs.service.BookService;

public class DownShelfAction extends AdminAction {
	private static final long serialVersionUID = 904221352435174347L;

	private String bookId;
	private String type;
	private BookService bookService;
	
	public String execute() throws Exception {
		bookService.downShelf(bookId);
		if(type != null && !type.equals("")) {
			return "searchbook";
		}
		return SUCCESS;
	}

	public String getBookId() {
		return bookId;
	}
	public void setBookId(String bookId) {
		this.bookId = bookId;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public BookService getBookService() {
		return bookService;
	}
	public void setBookService(BookService bookService) {
		this.bookService = bookService;
	}

}
