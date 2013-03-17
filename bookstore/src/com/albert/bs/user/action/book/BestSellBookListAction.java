package com.albert.bs.user.action.book;

import java.util.List;
import java.util.Map;

import com.albert.bs.model.Book;
import com.albert.bs.model.Paginate;
import com.albert.bs.service.BookService;
import com.albert.bs.user.action.UserAction;
import com.opensymphony.xwork2.ActionContext;

/**
 * 查看畅销书
 * @author Albert
 *
 */
public class BestSellBookListAction extends UserAction {
	private static final long serialVersionUID = -4673882240257122482L;

	private Integer page_index;
	private BookService bookService;
	
	@SuppressWarnings("unchecked")
	public String execute() throws Exception {
		Map request = (Map) ActionContext.getContext().get("request");
		Paginate<Book> books = new Paginate<Book>();
		if(page_index == null || page_index == 0) {
			page_index = 1;
		}
		books.setCurrentPage(page_index);
		books.setAllRecords(bookService.findBooksCount());
		books.setAllPages((books.getAllRecords() - 1) / books.getRecordInPage() + 1);
		List<Book> list = bookService.findBestSellBooks((page_index - 1) * books.getRecordInPage(), books.getRecordInPage());
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
