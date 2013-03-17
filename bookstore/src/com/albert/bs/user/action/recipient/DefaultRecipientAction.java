package com.albert.bs.user.action.recipient;

import java.util.Map;

import com.albert.bs.model.SessionContainer;
import com.albert.bs.service.RecipientService;
import com.albert.bs.user.action.UserAction;
import com.opensymphony.xwork2.ActionContext;

public class DefaultRecipientAction extends UserAction {
	private static final long serialVersionUID = 4273708210292467407L;
	
	private String type;
	private String recipientId;
	private RecipientService recipientService;

	@SuppressWarnings("unchecked")
	public String execute() throws Exception {
		Map session = ActionContext.getContext().getSession();
		SessionContainer container = (SessionContainer) session.get("container");
		recipientService.setDefault(container.getUser().getUserId(), recipientId);
		//确认订单页面中的设为默认地址功能，跳转到确认订单页面
		if(type != null && !type.equals("") && type.equals("confirmorder")) {
			return "confirmorder";
		}
		//在收货地址管理页面中设置默认收货地址
		return SUCCESS;
	}

	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getRecipientId() {
		return recipientId;
	}
	public void setRecipientId(String recipientId) {
		this.recipientId = recipientId;
	}
	public RecipientService getRecipientService() {
		return recipientService;
	}
	public void setRecipientService(RecipientService recipientService) {
		this.recipientService = recipientService;
	}
	
}
