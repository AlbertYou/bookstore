package com.albert.bs.admin.action.category;

import java.util.List;
import java.util.Map;

import com.albert.bs.admin.action.AdminAction;
import com.albert.bs.model.TopCategory;
import com.albert.bs.service.TopCategoryService;
import com.opensymphony.xwork2.ActionContext;

public class CategoryListAction extends AdminAction {
	private static final long serialVersionUID = 754785202658966846L;

	private TopCategoryService categoryService;
	
	@SuppressWarnings("unchecked")
	public String execute() throws Exception {
		List<TopCategory> categories = categoryService.findAll();
		Map request = (Map) ActionContext.getContext().get("request");
		request.put("categories", categories);
		return SUCCESS;
	}

	public TopCategoryService getCategoryService() {
		return categoryService;
	}
	public void setCategoryService(TopCategoryService categoryService) {
		this.categoryService = categoryService;
	}
	
}
