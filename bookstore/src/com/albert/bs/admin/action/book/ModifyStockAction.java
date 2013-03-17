package com.albert.bs.admin.action.book;

import com.albert.bs.admin.action.AdminAction;
import com.albert.bs.service.BookService;

public class ModifyStockAction extends AdminAction {
	private static final long serialVersionUID = 6513966358636078022L;
	
	private String bookId;
	private String stock;
	private String key;
	private BookService bookService;
	
	public String execute() throws Exception {
		bookService.modifyStock(bookId, Integer.parseInt(stock));
		if(key != null && !key.equals("")) {
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
	public String getStock() {
		return stock;
	}
	public void setStock(String stock) {
		this.stock = stock;
	}
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public BookService getBookService() {
		return bookService;
	}
	public void setBookService(BookService bookService) {
		this.bookService = bookService;
	}

}
