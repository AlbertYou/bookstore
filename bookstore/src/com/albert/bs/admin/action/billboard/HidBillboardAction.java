package com.albert.bs.admin.action.billboard;

import com.albert.bs.admin.action.AdminAction;
import com.albert.bs.service.BillboardService;

public class HidBillboardAction extends AdminAction {
	private static final long serialVersionUID = -6183546891592430274L;
	
	private String billboardId;
	private BillboardService billboardService;
	
	public String execute() throws Exception {
		billboardService.hid(billboardId);
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
