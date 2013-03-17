package com.albert.bs.admin.action.billboard;

import java.util.Date;

import com.albert.bs.admin.action.AdminAction;
import com.albert.bs.model.Billboard;
import com.albert.bs.service.BillboardService;

public class AddBillboardAction extends AdminAction {
	private static final long serialVersionUID = -775052023608322797L;
	
	private String title;
	private String content;
	private BillboardService billboardService;
	
	public String execute() throws Exception {
		Billboard billboard = new Billboard();
		billboard.setTitle(title);
		billboard.setContent(content);
		billboard.setPublishTime(new Date());
		billboardService.save(billboard);
		return SUCCESS;
	}

	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public BillboardService getBillboardService() {
		return billboardService;
	}
	public void setBillboardService(BillboardService billboardService) {
		this.billboardService = billboardService;
	}
	
}
