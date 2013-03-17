package com.albert.bs.user.action.order;

import java.util.List;
import java.util.Map;

import com.albert.bs.model.Product;
import com.albert.bs.model.Recipient;
import com.albert.bs.model.SessionContainer;
import com.albert.bs.service.RecipientService;
import com.albert.bs.user.action.UserAction;
import com.opensymphony.xwork2.ActionContext;

/**
 * 确认购物车中的商品
 * @author Albert
 *
 */
public class ConfirmOrderAction extends UserAction {
	private static final long serialVersionUID = -6932725917917066335L;

	private RecipientService recipientService;
	
	@SuppressWarnings("unchecked")
	public String execute() throws Exception {
		Map session = ActionContext.getContext().getSession();
		Map request = (Map) ActionContext.getContext().get("request");
		SessionContainer container = (SessionContainer) session.get("container");
		List<Product> products = container.getCart().getProducts();
		for (Product product : products) {
			if(product.getQuantity() > product.getBook().getStock()) { //购买图书数量大于库存
				this.addActionMessage("&lt;&lt;" + product.getBook().getName() + "&gt;&gt;&nbsp;的库存不足");
				return INPUT;
			}
		}
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
