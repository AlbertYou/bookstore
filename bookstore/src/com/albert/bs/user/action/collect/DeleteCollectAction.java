package com.albert.bs.user.action.collect;

import com.albert.bs.model.Collect;
import com.albert.bs.service.CollectService;
import com.albert.bs.user.action.UserAction;

public class DeleteCollectAction extends UserAction {
	private static final long serialVersionUID = 4570462023511406803L;

	private String collectId;
	private CollectService collectService;
	
	public String execute() throws Exception {
		collectService.delete(new Collect(collectId));
		return SUCCESS;
	}

	public String getCollectId() {
		return collectId;
	}
	public void setCollectId(String collectId) {
		this.collectId = collectId;
	}
	public CollectService getCollectService() {
		return collectService;
	}
	public void setCollectService(CollectService collectService) {
		this.collectService = collectService;
	}
	
}
