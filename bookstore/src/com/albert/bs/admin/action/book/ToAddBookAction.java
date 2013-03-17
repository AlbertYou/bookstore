package com.albert.bs.admin.action.book;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.albert.bs.admin.action.AdminAction;
import com.albert.bs.model.LowCategory;
import com.albert.bs.model.Publisher;
import com.albert.bs.model.TopCategory;
import com.albert.bs.service.PublisherService;
import com.albert.bs.service.TopCategoryService;
import com.opensymphony.xwork2.ActionContext;

public class ToAddBookAction extends AdminAction {
	private static final long serialVersionUID = 7193206275405088020L;

	private TopCategoryService topCategoryService;
	private PublisherService publisherService;
	
	@SuppressWarnings("unchecked")
	public String execute() throws Exception {
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
		return SUCCESS;
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
