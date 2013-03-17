package com.albert.bs.user.action.recipient;

import java.util.List;
import java.util.Map;

import com.albert.bs.constant.RecipientAddressStatus;
import com.albert.bs.model.Recipient;
import com.albert.bs.model.SessionContainer;
import com.albert.bs.service.RecipientService;
import com.albert.bs.user.action.UserAction;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ModelDriven;

public class AddRecipientAction extends UserAction implements ModelDriven<Recipient> {
	private static final long serialVersionUID = 7776882483943241109L;
	
	private String type;
	private Recipient recipient = new Recipient();
	private RecipientService recipientService;

	@SuppressWarnings("unchecked")
	public String execute() throws Exception {
		Map session = ActionContext.getContext().getSession();
		Map request = (Map) ActionContext.getContext().get("request");
		SessionContainer container = (SessionContainer) session.get("container");
		int maxRecipientCount = Integer.parseInt(getText("recipient.maxcount")); //每个用户拥有最多的收货地址数量
		int count = recipientService.getCountByUser(container.getUser().getUserId());
		
		//确认订单页面中的使用新地址功能，新增地址后跳转到确认订单页面
		//如该用户已拥有最多的收货地址数量，则删除(或隐藏)不是默认地址的且使用最少的那个收货地址，然后再增加该收货地址
		if(type != null && !type.equals("") && type.equals("confirmorder")) {
			if(count >= maxRecipientCount) {
				//如该用户已拥有最多的收货地址数量，则删除(或隐藏)未使用过的收货地址;
				//如所有的收货地址都是用过，则删除(或隐藏)不是默认地址的使用过的且使用次数最少的收货地址，然后再增加该收货地址
				//先查看是否有未使用过的收货地址
				List<Recipient> recipients = recipientService.getUnUsedRecipients(container.getUser().getUserId());
				if(recipients.size() > 0) { //有未使用的收货地址
					recipientService.delete(recipients.get(0));
				} else {  //所有的收货地址都使用过，删除(或隐藏)使用过的且使用次数最少的且不是默认地址的那个收货地址
					Recipient r = recipientService.getLeastUsedRecipient(container.getUser().getUserId());
					recipientService.delete(r);
				}
			}
			//新增收货地址
			recipient.setUser(container.getUser());
			Recipient r = recipientService.add(recipient);
			if(recipient.getDefaultAddr() == RecipientAddressStatus.DEFAULT_ADDRESS) { //设为默认地址
				recipientService.setDefault(container.getUser().getUserId(), r.getRecipientId());
			}
			return "confirmorder";
		} else { //在收货地址管理页面中新增收货地址
			if(count < maxRecipientCount) { //新增收货地址
				recipient.setUser(container.getUser());
				recipientService.add(recipient);
				if(recipient.getDefaultAddr() == RecipientAddressStatus.DEFAULT_ADDRESS) { //设为默认地址
					recipientService.setDefault(container.getUser().getUserId(), recipient.getRecipientId());
				}
			} else {
				request.put("notice", "error");
			}
		}
		return SUCCESS;
	}

	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
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
