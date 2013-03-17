package com.albert.bs.admin.action.billboard;

import java.util.List;
import java.util.Map;

import com.albert.bs.admin.action.AdminAction;
import com.albert.bs.model.Billboard;
import com.albert.bs.service.BillboardService;
import com.opensymphony.xwork2.ActionContext;

public class CurrentBillboardsAction extends AdminAction {
	private static final long serialVersionUID = -4159282181647195211L;

	private BillboardService billboardService;
	
	@SuppressWarnings("unchecked")
	public String execute() throws Exception {
		List<Billboard> billboards = billboardService.getCurrentBillboards();
		Map request = (Map) ActionContext.getContext().get("request");
		request.put("billboards", billboards);
		return SUCCESS;
	}

	public BillboardService getBillboardService() {
		return billboardService;
	}
	public void setBillboardService(BillboardService billboardService) {
		this.billboardService = billboardService;
	}
	
}
