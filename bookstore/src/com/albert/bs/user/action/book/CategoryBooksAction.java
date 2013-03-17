package com.albert.bs.user.action.book;

import java.util.List;
import java.util.Map;

import com.albert.bs.model.Book;
import com.albert.bs.model.BookStatistics;
import com.albert.bs.model.LowCategory;
import com.albert.bs.model.Paginate;
import com.albert.bs.model.TopCategory;
import com.albert.bs.service.BookService;
import com.albert.bs.service.CommentService;
import com.albert.bs.service.LowCategoryService;
import com.albert.bs.service.TopCategoryService;
import com.albert.bs.user.action.UserAction;
import com.opensymphony.xwork2.ActionContext;

public class CategoryBooksAction extends UserAction {
	private static final long serialVersionUID = 3237892528772683342L;
	
	private String categoryId;
	private Integer page_index;
	private BookService bookService;
	private CommentService commentService;
	private TopCategoryService topCategoryService;
	private LowCategoryService lowCategoryService;
	
	@SuppressWarnings("unchecked")
	public String execute() throws Exception {
		Paginate<Book> books = new Paginate<Book>();
		if(page_index == null || page_index == 0) {
			page_index = 1;
		}
		books.setCurrentPage(page_index);
		books.setAllRecords(bookService.findCountByCategory(categoryId));
		books.setAllPages((books.getAllRecords() - 1) / books.getRecordInPage() + 1);
		List<Book> list = bookService.findByCategory(categoryId, (books.getCurrentPage() - 1) * books.getRecordInPage(), books.getRecordInPage());
		for (Book book : list) {
			BookStatistics bs = new BookStatistics();
			bs.setCommentCount(commentService.getCountByBook(book.getBookId()));
			bs.setAvgCommentScore(commentService.getAvgScoreByBook(book.getBookId()));
			book.setBookStatistics(bs);
		}
		books.setList(list);
		List<TopCategory> categories = topCategoryService.findAll();
		LowCategory category = lowCategoryService.findById(categoryId);

		Map request = (Map) ActionContext.getContext().get("request");
		request.put("books", books);
		request.put("categories", categories);
		request.put("category", category);
		return SUCCESS;
	}

	public String getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
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
	public CommentService getCommentService() {
		return commentService;
	}
	public void setCommentService(CommentService commentService) {
		this.commentService = commentService;
	}
	public TopCategoryService getTopCategoryService() {
		return topCategoryService;
	}
	public void setTopCategoryService(TopCategoryService topCategoryService) {
		this.topCategoryService = topCategoryService;
	}
	public LowCategoryService getLowCategoryService() {
		return lowCategoryService;
	}
	public void setLowCategoryService(LowCategoryService lowCategoryService) {
		this.lowCategoryService = lowCategoryService;
	}
	
}
