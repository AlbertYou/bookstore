package com.albert.bs.admin.action.category;

import com.albert.bs.admin.action.AdminAction;
import com.albert.bs.model.TopCategory;
import com.albert.bs.service.TopCategoryService;

public class AddTopCategoryAction extends AdminAction {
	private static final long serialVersionUID = -3884676884708962034L;
	
	private String category;
	private TopCategoryService categoryService;
	
	public String execute() throws Exception {
		TopCategory tc = new TopCategory();
		System.out.println(category);
		tc.setName(category);
		categoryService.save(tc);
		return SUCCESS;
	}

	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public TopCategoryService getCategoryService() {
		return categoryService;
	}
	public void setCategoryService(TopCategoryService categoryService) {
		this.categoryService = categoryService;
	}
	
}
