package com.albert.bs.admin.action.category;

import java.io.PrintWriter;

import net.sf.json.JSONObject;

import org.apache.struts2.ServletActionContext;

import com.albert.bs.admin.action.AdminAction;
import com.albert.bs.model.LowCategory;
import com.albert.bs.service.LowCategoryService;

public class DeleteLowCategoryAction extends AdminAction {
	private static final long serialVersionUID = 754785202658966846L;

	private String categoryId;
	private LowCategoryService categoryService;
	
	public String execute() throws Exception {
		PrintWriter writer = ServletActionContext.getResponse().getWriter();
		JSONObject json = new JSONObject();
		int count = categoryService.getBooksCount(categoryId);
		if(count > 0) {
			json.put("result", "false");
		} else {
			categoryService.deleteLowCategory(new LowCategory(categoryId));
			json.put("result", "success");
		}
		try {
			writer.write(json.toString());
		} finally {
			writer.flush();
			writer.close();
		}
		return null;
	}

	public String getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}
	public LowCategoryService getCategoryService() {
		return categoryService;
	}
	public void setCategoryService(LowCategoryService categoryService) {
		this.categoryService = categoryService;
	}

}
