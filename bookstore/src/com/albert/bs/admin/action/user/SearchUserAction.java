package com.albert.bs.admin.action.user;

import java.util.List;
import java.util.Map;

import com.albert.bs.admin.action.AdminAction;
import com.albert.bs.model.Paginate;
import com.albert.bs.model.User;
import com.albert.bs.service.UserService;
import com.opensymphony.xwork2.ActionContext;

public class SearchUserAction extends AdminAction {
	private static final long serialVersionUID = 1587362740092644486L;

	private Integer page_index;
	private String username;
	private UserService userService;
	
	@SuppressWarnings("unchecked")
	public String execute() throws Exception {
		Map request = (Map) ActionContext.getContext().get("request");
		int count = userService.count();
		request.put("userCount", count);
		//使用分页
		Paginate<User> users = new Paginate<User>();
		if(page_index == null || page_index == 0) {
			page_index = 1;
		}
		if(username == null) {
			username = "";
		}
		List<User> list = userService.findUser(username, (page_index - 1) * users.getRecordInPage(), users.getRecordInPage());
		users.setAllRecords(userService.findUserCount(username));
		users.setCurrentPage(page_index);
		users.setAllPages((users.getAllRecords() - 1) / users.getRecordInPage() + 1);
		users.setList(list);
		request.put("users", users);
		return SUCCESS;
	}

	public Integer getPage_index() {
		return page_index;
	}
	public void setPage_index(Integer pageIndex) {
		page_index = pageIndex;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public UserService getUserService() {
		return userService;
	}
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
}
