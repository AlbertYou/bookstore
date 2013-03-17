package com.albert.bs.admin.action.publisher;

import java.io.PrintWriter;

import net.sf.json.JSONObject;

import org.apache.struts2.ServletActionContext;

import com.albert.bs.admin.action.AdminAction;
import com.albert.bs.service.PublisherService;

public class HasPublisherAction extends AdminAction {
	private static final long serialVersionUID = -6497157631098936034L;
	
	private String publisher;
	private PublisherService publisherService;
	
	public String execute() throws Exception {
		PrintWriter writer = ServletActionContext.getResponse().getWriter();
		JSONObject json = new JSONObject();
		boolean hasIt = publisherService.hasPublisher(publisher);
		if(hasIt) {
			json.put("result", "exist");
		} else {
			json.put("result", "notexist");			
		}
		try {
			writer.write(json.toString());
		} finally {
			writer.flush();
			writer.close();
		}
		return null;
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
