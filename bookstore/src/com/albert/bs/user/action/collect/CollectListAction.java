package com.albert.bs.user.action.collect;

import java.util.List;
import java.util.Map;

import com.albert.bs.model.BookStatistics;
import com.albert.bs.model.Collect;
import com.albert.bs.model.Paginate;
import com.albert.bs.model.SessionContainer;
import com.albert.bs.model.User;
import com.albert.bs.service.CollectService;
import com.albert.bs.user.action.UserAction;
import com.opensymphony.xwork2.ActionContext;

public class CollectListAction extends UserAction {
	private static final long serialVersionUID = -822209799829664079L;
	
	private Integer page_index;
	private CollectService collectService;
	
	@SuppressWarnings("unchecked")
	public String execute() throws Exception {
		Paginate<Collect> collects = new Paginate<Collect>();
		if(page_index == null || page_index.equals("")) {
			page_index = 1;
		}
		Map session = ActionContext.getContext().getSession();
		SessionContainer container = (SessionContainer) session.get("container");
		User user = container.getUser();
		collects.setAllRecords(collectService.getCollectCount(user.getUserId()));
		collects.setAllPages((collects.getAllRecords() - 1) / collects.getRecordInPage() + 1);
		collects.setCurrentPage(page_index);
		List<Collect> list = collectService.findPaginate(user.getUserId(), (collects.getCurrentPage() - 1) * collects.getRecordInPage(), collects.getRecordInPage());
		BookStatistics bs;
		for (Collect collect : list) { //添加图书的收藏人气
			bs = new BookStatistics();
			bs.setCollectCount(collectService.getCountByBook(collect.getBook().getBookId()));
			collect.getBook().setBookStatistics(bs);
		}
		collects.setList(list);
		Map request = (Map) ActionContext.getContext().get("request");
		request.put("collects", collects);
		return SUCCESS;
	}

	public Integer getPage_index() {
		return page_index;
	}
	public void setPage_index(Integer pageIndex) {
		page_index = pageIndex;
	}
	public CollectService getCollectService() {
		return collectService;
	}
	public void setCollectService(CollectService collectService) {
		this.collectService = collectService;
	}
	
}
