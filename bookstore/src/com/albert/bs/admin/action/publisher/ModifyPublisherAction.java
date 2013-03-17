package com.albert.bs.admin.action.publisher;

import com.albert.bs.admin.action.AdminAction;
import com.albert.bs.model.Publisher;
import com.albert.bs.service.PublisherService;

public class ModifyPublisherAction extends AdminAction {
	private static final long serialVersionUID = 4641208772015732737L;
	
	private String publisherId;
	private String publisher;
	private PublisherService publisherService;
	
	public String execute() throws Exception {
		Publisher p = publisherService.findById(publisherId);
		p.setPublisher(publisher);
		publisherService.update(p);
		return SUCCESS;
	}

	public String getPublisherId() {
		return publisherId;
	}
	public void setPublisherId(String publisherId) {
		this.publisherId = publisherId;
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
