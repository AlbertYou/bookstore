package com.albert.bs.user.action.collect;

import java.util.Map;

import com.albert.bs.model.Book;
import com.albert.bs.model.Collect;
import com.albert.bs.model.SessionContainer;
import com.albert.bs.model.User;
import com.albert.bs.service.CollectService;
import com.albert.bs.user.action.UserAction;
import com.opensymphony.xwork2.ActionContext;

public class AddCollectAction extends UserAction {
	private static final long serialVersionUID = 8464023015430268952L;

	private String bookId;
	private CollectService collectService;
	
	@SuppressWarnings("unchecked")
	public String execute() throws Exception {
		Map session = ActionContext.getContext().getSession();
		SessionContainer container = (SessionContainer) session.get("container");
		User user = container.getUser();
		//重复判断
		boolean flag = collectService.isCollected(user.getUserId(), bookId);
		if(!flag) { //之前未收藏过
			Collect collect = new Collect();
			collect.setUser(user);
			collect.setBook(new Book(bookId));
			collectService.save(collect);
		}
		return SUCCESS;
	}

	public String getBookId() {
		return bookId;
	}
	public void setBookId(String bookId) {
		this.bookId = bookId;
	}
	public CollectService getCollectService() {
		return collectService;
	}
	public void setCollectService(CollectService collectService) {
		this.collectService = collectService;
	}
	
}
