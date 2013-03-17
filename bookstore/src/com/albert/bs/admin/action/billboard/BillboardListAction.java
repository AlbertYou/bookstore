package com.albert.bs.admin.action.billboard;

import java.util.List;
import java.util.Map;

import com.albert.bs.admin.action.AdminAction;
import com.albert.bs.model.Billboard;
import com.albert.bs.model.Paginate;
import com.albert.bs.service.BillboardService;
import com.opensymphony.xwork2.ActionContext;

public class BillboardListAction extends AdminAction {
	private static final long serialVersionUID = -4159282181647195211L;

	private Integer page_index;
	private BillboardService billboardService;
	
	@SuppressWarnings("unchecked")
	public String execute() throws Exception {
		if(page_index == null || page_index == 0) {
			page_index = 1;
		}
		Paginate<Billboard> billboards = new Paginate<Billboard>();
		billboards.setCurrentPage(page_index);
		billboards.setAllRecords(billboardService.count());
		billboards.setAllPages((billboards.getAllRecords() - 1) / billboards.getRecordInPage() + 1);
		List<Billboard> list = billboardService.getAllBillboards((billboards.getCurrentPage() - 1) * billboards.getRecordInPage(), billboards.getRecordInPage());
		billboards.setList(list);
		Map request = (Map) ActionContext.getContext().get("request");
		request.put("billboards", billboards);
		return SUCCESS;
	}

	public Integer getPage_index() {
		return page_index;
	}
	public void setPage_index(Integer pageIndex) {
		page_index = pageIndex;
	}
	public BillboardService getBillboardService() {
		return billboardService;
	}
	public void setBillboardService(BillboardService billboardService) {
		this.billboardService = billboardService;
	}
	
}
