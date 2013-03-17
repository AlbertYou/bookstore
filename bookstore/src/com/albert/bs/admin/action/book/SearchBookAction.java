package com.albert.bs.admin.action.book;

import java.util.List;
import java.util.Map;

import com.albert.bs.admin.action.AdminAction;
import com.albert.bs.model.Book;
import com.albert.bs.model.Paginate;
import com.albert.bs.service.BookService;
import com.opensymphony.xwork2.ActionContext;

public class SearchBookAction extends AdminAction {
	private static final long serialVersionUID = 904221352435174347L;

	private String key;
	private Integer page_index;
	private BookService bookService;
	
	@SuppressWarnings("unchecked")
	public String execute() throws Exception {
		Paginate<Book> books = new Paginate<Book>(); //使用分页
		if(page_index == null || page_index.equals("")) {
			page_index = 1;
		}
		if(key == null) {
			key = "";
		}
		books.setCurrentPage(page_index);
		books.setRecordInPage(10); //每页显示10条记录
		books.setAllRecords(bookService.findCountByName(key));
		books.setAllPages((books.getAllRecords() - 1) / books.getRecordInPage() + 1);
		List<Book> list = bookService.findByName(key, (books.getCurrentPage() - 1) * books.getRecordInPage(), books.getRecordInPage());
		books.setList(list);
		Map request = (Map) ActionContext.getContext().get("request");
		request.put("books", books);
		return SUCCESS;
	}

	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
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
