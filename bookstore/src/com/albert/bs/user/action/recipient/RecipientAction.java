package com.albert.bs.user.action.recipient;

import java.util.List;
import java.util.Map;

import com.albert.bs.model.Recipient;
import com.albert.bs.model.SessionContainer;
import com.albert.bs.service.RecipientService;
import com.albert.bs.user.action.UserAction;
import com.opensymphony.xwork2.ActionContext;

public class RecipientAction extends UserAction {
	private static final long serialVersionUID = 8337940102504114055L;
	
	private String recipientId;
	private RecipientService recipientService;

	@SuppressWarnings("unchecked")
	public String execute() throws Exception {
		Map session = ActionContext.getContext().getSession();
		Map request = (Map) ActionContext.getContext().get("request");
		Recipient recipient = recipientService.findById(recipientId);
		SessionContainer container = (SessionContainer) session.get("container");
		List<Recipient> recipients = recipientService.findAll(container.getUser().getUserId());
		request.put("recipients", recipients);
		request.put("recipient", recipient);
		return SUCCESS;
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
