package com.albert.bs.admin.action.billboard;

import com.albert.bs.admin.action.AdminAction;
import com.albert.bs.model.Billboard;
import com.albert.bs.service.BillboardService;

public class DeleteBillboardAction extends AdminAction {
	private static final long serialVersionUID = -2911750468681797581L;
	
	private String billboardId;
	private BillboardService billboardService;
	
	public String execute() throws Exception {
		billboardService.delete(new Billboard(billboardId));
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
