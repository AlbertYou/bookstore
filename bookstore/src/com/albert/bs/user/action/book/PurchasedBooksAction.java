package com.albert.bs.user.action.book;

import java.util.List;
import java.util.Map;

import com.albert.bs.model.Book;
import com.albert.bs.model.Paginate;
import com.albert.bs.model.SessionContainer;
import com.albert.bs.service.BookService;
import com.albert.bs.user.action.UserAction;
import com.opensymphony.xwork2.ActionContext;

/**
 * 已购商品
 * @author Albert
 *
 */
public class PurchasedBooksAction extends UserAction {
	private static final long serialVersionUID = -7004114761093686742L;
	
	private Integer page_index;
	private BookService bookService;
	
	@SuppressWarnings("unchecked")
	public String execute() throws Exception {
		Map session = (Map) ActionContext.getContext().getSession();
		Map request = (Map) ActionContext.getContext().get("request");
		SessionContainer container = (SessionContainer) session.get("container");
		Paginate<Book> books = new Paginate<Book>(); //使用分页
		if(page_index == null || page_index == 0) {
			page_index = 1;
		}
		books.setRecordInPage(12);
		books.setAllRecords(bookService.getPurchasedBooksCount(container.getUser().getUserId()));
		books.setAllPages((books.getAllRecords() - 1) / books.getRecordInPage() + 1);
		books.setCurrentPage(page_index);
		List<Book> list = bookService.getPurchasedBooks(container.getUser().getUserId(), (books.getCurrentPage() - 1) * books.getRecordInPage(), books.getRecordInPage());
		books.setList(list);
		request.put("books", books);
		return SUCCESS;
	}

	public Integer getPage_index() {
		return page_index;
	}
	public void setPage_index(Integer pageIndex) {
		page_index = pageIndex;
	}
	public BookService getBookService() {
		return bookService;
	}
	public void setBookService(BookService bookService) {
		this.bookService = bookService;
	}
	
}
