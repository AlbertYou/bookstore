package com.albert.bs.admin.action.category;

import com.albert.bs.admin.action.AdminAction;
import com.albert.bs.model.LowCategory;
import com.albert.bs.model.TopCategory;
import com.albert.bs.service.LowCategoryService;

public class ModifyLowCategoryAction extends AdminAction {
	private static final long serialVersionUID = -4543794122999375285L;
	
	private String categoryId;
	private String category;
	private String parentId;	
	private LowCategoryService categoryService;
	
	public String execute() throws Exception {
		LowCategory lc = categoryService.findById(categoryId);
		lc.setParent(new TopCategory(parentId));
		lc.setName(category);
		categoryService.update(lc);
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
	public String getParentId() {
		return parentId;
	}
	public void setParentId(String parentId) {
		this.parentId = parentId;
	}
	public LowCategoryService getCategoryService() {
		return categoryService;
	}
	public void setCategoryService(LowCategoryService categoryService) {
		this.categoryService = categoryService;
	}

}
