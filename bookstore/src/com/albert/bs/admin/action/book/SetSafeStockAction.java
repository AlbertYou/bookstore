package com.albert.bs.admin.action.book;

import java.util.Map;

import com.albert.bs.admin.action.AdminAction;
import com.opensymphony.xwork2.ActionContext;

/**
 * 设置安全库存
 * @author Albert
 *
 */
public class SetSafeStockAction extends AdminAction {
	private static final long serialVersionUID = -406494888595920828L;
	
	private Integer stock;
	
	@SuppressWarnings("unchecked")
	public String execute() throws Exception {
		Map application = ActionContext.getContext().getApplication();
		application.put("safestock", stock);
		return SUCCESS;
	}

	public Integer getStock() {
		return stock;
	}
	public void setStock(Integer stock) {
		this.stock = stock;
	}
	
}
