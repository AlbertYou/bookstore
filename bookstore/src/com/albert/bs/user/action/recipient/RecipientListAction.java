package com.albert.bs.user.action.recipient;

import java.util.List;
import java.util.Map;

import com.albert.bs.model.Recipient;
import com.albert.bs.model.SessionContainer;
import com.albert.bs.service.RecipientService;
import com.albert.bs.user.action.UserAction;
import com.opensymphony.xwork2.ActionContext;

public class RecipientListAction extends UserAction {
	private static final long serialVersionUID = 6011141986040666172L;
	
	private RecipientService recipientService;

	@SuppressWarnings("unchecked")
	public String execute() throws Exception {
		Map session = ActionContext.getContext().getSession();
		Map request = (Map) ActionContext.getContext().get("request");		
		SessionContainer container = (SessionContainer) session.get("container");
		List<Recipient> recipients = recipientService.findAll(container.getUser().getUserId());
		request.put("recipients", recipients);
		return SUCCESS;
	}

	public RecipientService getRecipientService() {
		return recipientService;
	}
	public void setRecipientService(RecipientService recipientService) {
		this.recipientService = recipientService;
	}
	
}
