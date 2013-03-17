package com.albert.bs.admin.action.billboard;

import java.util.Map;

import com.albert.bs.admin.action.AdminAction;
import com.albert.bs.model.Billboard;
import com.albert.bs.service.BillboardService;
import com.opensymphony.xwork2.ActionContext;

public class BillboardInfoAction extends AdminAction {
	private static final long serialVersionUID = 5674484539725888926L;
	
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
