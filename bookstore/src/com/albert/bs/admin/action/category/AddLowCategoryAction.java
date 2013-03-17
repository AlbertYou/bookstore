package com.albert.bs.admin.action.category;

import com.albert.bs.admin.action.AdminAction;
import com.albert.bs.model.LowCategory;
import com.albert.bs.model.TopCategory;
import com.albert.bs.service.LowCategoryService;

public class AddLowCategoryAction extends AdminAction {
	private static final long serialVersionUID = 5177043611265440564L;
	
	private String parent;
	private String category;
	private LowCategoryService categoryService;
	
	public String execute() throws Exception {
		LowCategory lc = new LowCategory();
		lc.setParent(new TopCategory(parent));
		lc.setName(category);
		categoryService.save(lc);
		return SUCCESS;
	}

	public String getParent() {
		return parent;
	}
	public void setParent(String parent) {
		this.parent = parent;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public LowCategoryService getCategoryService() {
		return categoryService;
	}
	public void setCategoryService(LowCategoryService categoryService) {
		this.categoryService = categoryService;
	}

}
