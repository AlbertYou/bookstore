package com.albert.bs.admin.action.category;

import com.albert.bs.admin.action.AdminAction;
import com.albert.bs.model.TopCategory;
import com.albert.bs.service.TopCategoryService;

public class ModifyTopCategoryAction extends AdminAction {
	private static final long serialVersionUID = -9077649096619558849L;
	
	private String categoryId;
	private String category;
	private TopCategoryService categoryService;
	
	public String execute() throws Exception {
		TopCategory tc = categoryService.findById(categoryId);
		tc.setName(category);
		categoryService.update(tc);
		return SUCCESS;
	}

	public String getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
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
