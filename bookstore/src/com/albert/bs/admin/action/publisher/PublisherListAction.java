package com.albert.bs.admin.action.publisher;

import java.util.List;
import java.util.Map;

import com.albert.bs.admin.action.AdminAction;
import com.albert.bs.model.Publisher;
import com.albert.bs.service.PublisherService;
import com.opensymphony.xwork2.ActionContext;

public class PublisherListAction extends AdminAction {
	private static final long serialVersionUID = 569220689911960164L;

	private PublisherService publisherService;
	
	@SuppressWarnings("unchecked")
	public String execute() throws Exception {
		List<Publisher> publishers = publisherService.findAll();
		Map request = (Map) ActionContext.getContext().get("request");
		request.put("publishers", publishers);
		return SUCCESS;
	}

	public PublisherService getPublisherService() {
		return publisherService;
	}
	public void setPublisherService(PublisherService publisherService) {
		this.publisherService = publisherService;
	}

}
