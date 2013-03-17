package com.albert.bs.user.action.recipient;

import com.albert.bs.model.Recipient;
import com.albert.bs.service.RecipientService;
import com.albert.bs.user.action.UserAction;

public class DeleteRecipientAction extends UserAction {
	private static final long serialVersionUID = 8337940102504114055L;
	
	private String recipientId;
	private RecipientService recipientService;

	public String execute() throws Exception {
		//如果之前有使用过该收货地址，则将其设为隐藏；否则删除
		boolean flag = recipientService.isUsed(recipientId);
		if(flag) {
			recipientService.hidRecipient(recipientId);
		} else {
			recipientService.delete(new Recipient(recipientId));
		}
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
