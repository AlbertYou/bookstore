package com.albert.bs.user.action.recipient;

import java.util.Map;

import com.albert.bs.constant.RecipientAddressStatus;
import com.albert.bs.model.Recipient;
import com.albert.bs.model.SessionContainer;
import com.albert.bs.service.RecipientService;
import com.albert.bs.user.action.UserAction;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ModelDriven;

public class ModifyRecipientAction extends UserAction implements ModelDriven<Recipient> {
	private static final long serialVersionUID = -8008715554261534986L;
	
	private Recipient recipient = new Recipient();
	private RecipientService recipientService;

	@SuppressWarnings("unchecked")
	public String execute() throws Exception {
		Map session = ActionContext.getContext().getSession();
		SessionContainer container = (SessionContainer) session.get("container");
		recipient.setUser(container.getUser());
		recipientService.update(recipient);
		//设为默认地址
		if(recipient.getDefaultAddr() == RecipientAddressStatus.DEFAULT_ADDRESS) {
			recipientService.setDefault(container.getUser().getUserId(), recipient.getRecipientId());
		}
		return SUCCESS;
	}

	public Recipient getRecipient() {
		return recipient;
	}
	public void setRecipient(Recipient recipient) {
		this.recipient = recipient;
	}
	public RecipientService getRecipientService() {
		return recipientService;
	}
	public void setRecipientService(RecipientService recipientService) {
		this.recipientService = recipientService;
	}
	public Recipient getModel() {
		return recipient;
	}
	
}
