package com.albert.bs.admin.action.publisher;

import com.albert.bs.admin.action.AdminAction;
import com.albert.bs.model.Publisher;
import com.albert.bs.service.PublisherService;

public class AddPublisherAction extends AdminAction {
	private static final long serialVersionUID = 5620196862971950988L;
	
	private String publisher;
	private PublisherService publisherService;
	
	public String execute() throws Exception {
		Publisher p = new Publisher();
		p.setPublisher(publisher);
		publisherService.save(p);
		return SUCCESS;
	}

	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public PublisherService getPublisherService() {
		return publisherService;
	}
	public void setPublisherService(PublisherService publisherService) {
		this.publisherService = publisherService;
	}
	
}
