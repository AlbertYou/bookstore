package com.albert.bs.admin.action.comment;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.albert.bs.admin.action.AdminAction;
import com.albert.bs.model.Comment;
import com.albert.bs.model.Paginate;
import com.albert.bs.service.CommentService;
import com.opensymphony.xwork2.ActionContext;

/**
 * 查看今日评论
 * @author Albert
 *
 */
public class TodayCommentsAction extends AdminAction {
	private static final long serialVersionUID = 6632506835993733000L;
	
	private Integer page_index;
	private CommentService commentService;
	
	@SuppressWarnings("unchecked")
	public String execute() throws Exception {
		Map request = (Map) ActionContext.getContext().get("request");
		Paginate<Comment> comments = new Paginate<Comment>();
		if(page_index == null || page_index == 0) {
			page_index = 1;
		}
		comments.setCurrentPage(page_index);
		comments.setAllRecords(commentService.getCommentCount(new Date()));
		comments.setAllPages((comments.getAllRecords() - 1) / comments.getRecordInPage() + 1);
		List<Comment> list = commentService.getComments(new Date(), comments.getRecordInPage() * (page_index - 1), comments.getRecordInPage());
		comments.setList(list);
		request.put("comments", comments);
		return SUCCESS;
	}

	public Integer getPage_index() {
		return page_index;
	}
	public void setPage_index(Integer pageIndex) {
		page_index = pageIndex;
	}
	public CommentService getCommentService() {
		return commentService;
	}
	public void setCommentService(CommentService commentService) {
		this.commentService = commentService;
	}

}
