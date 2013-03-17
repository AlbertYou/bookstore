package com.albert.bs.user.action.book;

import java.util.List;
import java.util.Map;

import com.albert.bs.model.Book;
import com.albert.bs.model.Comment;
import com.albert.bs.model.Paginate;
import com.albert.bs.service.BookService;
import com.albert.bs.service.CommentService;
import com.albert.bs.user.action.UserAction;
import com.opensymphony.xwork2.ActionContext;

/**
 * 查看图书更多评论
 * @author Albert
 *
 */
public class CommentsOfBookAction extends UserAction {
	private static final long serialVersionUID = 3510480545073852749L;
	
	private String bookId;
	private Integer page_index;
	private BookService bookService;
	private CommentService commentService;
	
	@SuppressWarnings("unchecked")
	public String execute() throws Exception {
		Book book = bookService.findById(bookId);
		Paginate<Comment> comments = new Paginate<Comment>();
		if(page_index == null || page_index == 0) {
			page_index = 1;
		}
		comments.setCurrentPage(page_index);
		comments.setAllRecords(commentService.getCountByBook(bookId));
		comments.setAllPages((comments.getAllRecords() - 1) / comments.getRecordInPage() + 1);
		List<Comment> list = commentService.getBookComments(bookId, (comments.getCurrentPage() - 1) * comments.getRecordInPage(), comments.getRecordInPage());
		comments.setList(list);
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
	
}
