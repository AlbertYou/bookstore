package com.albert.bs.user.action.collect;

import java.io.PrintWriter;

import org.apache.struts2.ServletActionContext;

import com.albert.bs.service.CollectService;
import com.albert.bs.user.action.UserAction;

public class ModifyCollectTitleAction extends UserAction {
	private static final long serialVersionUID = 3513466112759409810L;

	private String collectId;
	private String title;
	private CollectService collectService;
	
	public String execute() throws Exception {
		PrintWriter writer = ServletActionContext.getResponse().getWriter();
		try {
			collectService.modifyTitle(collectId, title);
			writer.write("success");
		} catch (Exception e) {
			writer.write("false");
		} finally {
			writer.flush();
			writer.close();
		}
		return null;
	}

	public String getCollectId() {
		return collectId;
	}
	public void setCollectId(String collectId) {
		this.collectId = collectId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public CollectService getCollectService() {
		return collectService;
	}
	public void setCollectService(CollectService collectService) {
		this.collectService = collectService;
	}
	
}
