package com.albert.bs.admin.action.category;

import java.io.PrintWriter;

import net.sf.json.JSONObject;

import org.apache.struts2.ServletActionContext;

import com.albert.bs.admin.action.AdminAction;
import com.albert.bs.service.TopCategoryService;

public class HasTopCategoryAction extends AdminAction {
	private static final long serialVersionUID = 3747469161013955074L;
	
	private String category;
	private TopCategoryService categoryService;
	
	public String execute() throws Exception {
		PrintWriter writer = ServletActionContext.getResponse().getWriter();
		JSONObject json = new JSONObject();
		boolean hasIt = categoryService.hasCategory(category);
		if(hasIt) {
			json.put("result", "exist");
		} else {
			json.put("result", "notexist");			
		}
		try {
			writer.write(json.toString());
		} finally {
			writer.flush();
			writer.close();
		}
		return null;
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
