package com.albert.bs.user.action.billboard;

import java.util.Map;

import com.albert.bs.model.Billboard;
import com.albert.bs.service.BillboardService;
import com.albert.bs.user.action.UserAction;
import com.opensymphony.xwork2.ActionContext;

public class BillboardAction extends UserAction {
	private static final long serialVersionUID = -899144986304151254L;

	private String billboardId;
	private BillboardService billboardService;
	
	@SuppressWarnings("unchecked")
	public String execute() throws Exception {
		Map request = (Map) ActionContext.getContext().get("request");		
		Billboard billboard = billboardService.findById(billboardId);
		request.put("billboard", billboard);
		return SUCCESS;
	}

	public String getBillboardId() {
		return billboardId;
	}
	public void setBillboardId(String billboardId) {
		this.billboardId = billboardId;
	}
	public BillboardService getBillboardService() {
		return billboardService;
	}
	public void setBillboardService(BillboardService billboardService) {
		this.billboardService = billboardService;
	}
	
}
