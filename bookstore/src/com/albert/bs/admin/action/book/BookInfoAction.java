package com.albert.bs.admin.action.book;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.albert.bs.admin.action.AdminAction;
import com.albert.bs.model.Book;
import com.albert.bs.model.BookStatistics;
import com.albert.bs.model.LowCategory;
import com.albert.bs.model.Publisher;
import com.albert.bs.model.TopCategory;
import com.albert.bs.service.BookService;
import com.albert.bs.service.CollectService;
import com.albert.bs.service.CommentService;
import com.albert.bs.service.OrderItemService;
import com.albert.bs.service.PublisherService;
import com.albert.bs.service.TopCategoryService;
import com.opensymphony.xwork2.ActionContext;

public class BookInfoAction extends AdminAction {
	private static final long serialVersionUID = -2082634175998967294L;
	
	private String bookId;
	private BookService bookService;
	private CollectService collectService;
	private CommentService commentService;
	private OrderItemService orderItemService;
	private TopCategoryService topCategoryService;
	private PublisherService publisherService;
	
	@SuppressWarnings("unchecked")
	public String execute() throws Exception {
		Book book = bookService.findById(bookId);
		BookStatistics bs = new BookStatistics();
		bs.setCollectCount(collectService.getCountByBook(bookId));
		bs.setSellCount(orderItemService.getCountByBook(bookId));
		bs.setCommentCount(commentService.getCountByBook(bookId));
		bs.setAvgCommentScore(commentService.getAvgScoreByBook(bookId));
		book.setBookStatistics(bs);
		
		List<TopCategory> topCategories = topCategoryService.findAll();
		Map<String, Set<LowCategory>> map = new HashMap<String, Set<LowCategory>>() ;
		for (TopCategory topCategory : topCategories) {
			map.put(topCategory.getCategoryId(), topCategory.getChildren());
		}
		List<Publisher> publishers = publisherService.findAll();
		
		Map request = (Map) ActionContext.getContext().get("request");
		request.put("topCategories", topCategories);
		request.put("publishers", publishers);
		request.put("map", map);
		request.put("book", book);
		
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
	public TopCategoryService getTopCategoryService() {
		return topCategoryService;
	}
	public void setTopCategoryService(TopCategoryService topCategoryService) {
		this.topCategoryService = topCategoryService;
	}
	public PublisherService getPublisherService() {
		return publisherService;
	}
	public void setPublisherService(PublisherService publisherService) {
		this.publisherService = publisherService;
	}

}
