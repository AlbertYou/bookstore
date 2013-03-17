package com.albert.bs.admin.action.book;

import java.util.List;
import java.util.Map;

import com.albert.bs.admin.action.AdminAction;
import com.albert.bs.model.Book;
import com.albert.bs.service.BookService;
import com.opensymphony.xwork2.ActionContext;

/**
 * 查询安全库存以内的图书
 * @author Albert
 *
 */
public class LowStockBookListAction extends AdminAction {
	private static final long serialVersionUID = -1251812217315091606L;
	
	private BookService bookService;
	
	@SuppressWarnings("unchecked")
	public String execute() throws Exception {
		Map application = ActionContext.getContext().getApplication();
		Integer safestock = (Integer) application.get("safestock");
		if(safestock == null || safestock.equals("")) {
			safestock = Integer.parseInt(getText("book.safestock"));
			application.put("safestock", safestock);
		}
		List<Book> books = bookService.findLowStockBooks(safestock);
		Map request = (Map) ActionContext.getContext().get("request");
		request.put("books", books);
		return SUCCESS;
	}

	public BookService getBookService() {
		return bookService;
	}
	public void setBookService(BookService bookService) {
		this.bookService = bookService;
	}
	
}
