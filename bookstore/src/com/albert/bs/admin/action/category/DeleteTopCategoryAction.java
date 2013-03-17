package com.albert.bs.admin.action.category;

import java.io.PrintWriter;

import net.sf.json.JSONObject;

import org.apache.struts2.ServletActionContext;

import com.albert.bs.admin.action.AdminAction;
import com.albert.bs.model.TopCategory;
import com.albert.bs.service.TopCategoryService;

public class DeleteTopCategoryAction extends AdminAction {
	private static final long serialVersionUID = -8324121937086945740L;

	private String categoryId;
	private TopCategoryService categoryService;
	
	public String execute() throws Exception {
		PrintWriter writer = ServletActionContext.getResponse().getWriter();
		JSONObject json = new JSONObject();
		int count = categoryService.getChildrenCount(categoryId);
		if(count > 0) {
			json.put("result", "false");
		} else {
			categoryService.deleteTopCategory(new TopCategory(categoryId));
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
	public TopCategoryService getCategoryService() {
		return categoryService;
	}
	public void setCategoryService(TopCategoryService categoryService) {
		this.categoryService = categoryService;
	}
	
}
