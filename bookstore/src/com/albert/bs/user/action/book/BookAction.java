package com.albert.bs.user.action.book;

import java.util.List;
import java.util.Map;

import com.albert.bs.model.Book;
import com.albert.bs.model.BookStatistics;
import com.albert.bs.model.Comment;
import com.albert.bs.service.BookService;
import com.albert.bs.service.CollectService;
import com.albert.bs.service.CommentService;
import com.albert.bs.service.OrderItemService;
import com.albert.bs.user.action.UserAction;
import com.opensymphony.xwork2.ActionContext;

public class BookAction extends UserAction {
	private static final long serialVersionUID = 3237892528772683342L;
	
	private String bookId;
	private BookService bookService;
	private CollectService collectService;
	private CommentService commentService;
	private OrderItemService orderItemService;
	
	@SuppressWarnings("unchecked")
	public String execute() throws Exception {
		Book book = bookService.findById(bookId);
		BookStatistics bs = new BookStatistics();
		bs.setCollectCount(collectService.getCountByBook(bookId));
		bs.setSellCount(orderItemService.getCountByBook(bookId));
		bs.setCommentCount(commentService.getCountByBook(bookId));
		bs.setAvgCommentScore(commentService.getAvgScoreByBook(bookId));
		book.setBookStatistics(bs);
		List<Comment> comments = commentService.getBookComments(bookId, 0, 5);
		Map request = (Map) ActionContext.getContext().get("request");
		request.put("book", book);
		request.put("comments", comments);
		return SUCCESS;
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
	public CollectService getCollectService() {
		return collectService;
	}
	public void setCollectService(CollectService collectService) {
		this.collectService = collectService;
	}
	public CommentService getCommentService() {
		return commentService;
	}
	public void setCommentService(CommentService commentService) {
		this.commentService = commentService;
	}
	public OrderItemService getOrderItemService() {
		return orderItemService;
	}
	public void setOrderItemService(OrderItemService orderItemService) {
		this.orderItemService = orderItemService;
	}
	
}
