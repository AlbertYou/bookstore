package com.albert.bs.admin.action.publisher;

import java.io.PrintWriter;

import net.sf.json.JSONObject;

import org.apache.struts2.ServletActionContext;

import com.albert.bs.admin.action.AdminAction;
import com.albert.bs.model.Publisher;
import com.albert.bs.service.PublisherService;

public class DeletePublisherAction extends AdminAction {
	private static final long serialVersionUID = 8802354670558573147L;

	private String publisherId;
	private PublisherService publisherService;
	
	public String execute() throws Exception {
		PrintWriter writer = ServletActionContext.getResponse().getWriter();
		JSONObject json = new JSONObject();
		//判断该出版社是否被使用了
		boolean isUsed = publisherService.isUsed(publisherId);
		if(!isUsed) {
			publisherService.delete(new Publisher(publisherId));
			json.put("result", "success");
		} else {
			json.put("result", "false");			
		}
		try {
			writer.write(json.toString());
		} finally {
			writer.flush();
			writer.close();
		}
		return null;
	}

	public String getPublisherId() {
		return publisherId;
	}
	public void setPublisherId(String publisherId) {
		this.publisherId = publisherId;
	}
	public PublisherService getPublisherService() {
		return publisherService;
	}
	public void setPublisherService(PublisherService publisherService) {
		this.publisherService = publisherService;
	}
	
}
