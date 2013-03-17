package com.albert.bs.user.action;

import java.util.List;
import java.util.Map;

import com.albert.bs.model.Billboard;
import com.albert.bs.model.Book;
import com.albert.bs.model.TopCategory;
import com.albert.bs.service.BillboardService;
import com.albert.bs.service.BookService;
import com.albert.bs.service.TopCategoryService;
import com.opensymphony.xwork2.ActionContext;

/**
 * 系统首页
 * 
 * @author Albert
 * @version V1.0 2012-03-25
 * @since JDK5.0
 */
public class IndexAction extends UserAction {
	private static final long serialVersionUID = -1458732545130465916L;
	
	private BookService bookService;
	private TopCategoryService categoryService;
	private BillboardService billboardService;
	
	@SuppressWarnings("unchecked")
	public String execute() throws Exception {
		List<TopCategory> categories = categoryService.findAll(); //图书类别
		List<Billboard> billboards = billboardService.getCurrentBillboards(); //公告
		List<Book> newBooks = bookService.findNewBooks(0, 8); //新书
		List<Book> goodBooks = bookService.findGoodBooks(0, 8); //好书
		List<Book> bestSellBooks = bookService.findBestSellBooks(0, 8); //畅销书
		List<Book> mostSellBooks = bookService.findBooksBySale(0, 8); //销售排行
		Map request = (Map) ActionContext.getContext().get("request");
		request.put("categories", categories);
		request.put("billboards", billboards);
		request.put("newBooks", newBooks);
		request.put("goodBooks", goodBooks);
		request.put("bestSellBooks", bestSellBooks);
		request.put("mostSellBooks", mostSellBooks);
		return SUCCESS;
	}
	public BookService getBookService() {
		return bookService;
	}
	public void setBookService(BookService bookService) {
		this.bookService = bookService;
	}
	public TopCategoryService getCategoryService() {
		return categoryService;
	}
	public void setCategoryService(TopCategoryService categoryService) {
		this.categoryService = categoryService;
	}
	public BillboardService getBillboardService() {
		return billboardService;
	}
	public void setBillboardService(BillboardService billboardService) {
		this.billboardService = billboardService;
	}

}
