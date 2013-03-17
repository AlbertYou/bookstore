package com.albert.bs.admin.action.comment;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.albert.bs.admin.action.AdminAction;
import com.albert.bs.model.Comment;
import com.albert.bs.model.Paginate;
import com.albert.bs.service.CommentService;
import com.opensymphony.xwork2.ActionContext;

/**
 * 根据日期查询评论
 * @author Albert
 *
 */
public class QueryCommentsAction extends AdminAction {
	private static final long serialVersionUID = -3162189527935496475L;
	
	private Integer page_index;
	private String commentDate;
	private CommentService commentService;
	
	@SuppressWarnings("unchecked")
	public String execute() throws Exception {
		Map request = (Map) ActionContext.getContext().get("request");
		Paginate<Comment> comments = new Paginate<Comment>();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date date;
		if(commentDate == null || commentDate.equals("")) {
			date = new Date();
			commentDate = sdf.format(date);
		} else {
			date = sdf.parse(commentDate);
		}
		if(page_index == null || page_index == 0) {
			page_index = 1;
		}
		comments.setCurrentPage(page_index);
		comments.setAllRecords(commentService.getCommentCount(date));
		comments.setAllPages((comments.getAllRecords() - 1) / comments.getRecordInPage() + 1);
		List<Comment> list = commentService.getComments(date, comments.getRecordInPage() * (page_index - 1), comments.getRecordInPage());
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
	public String getCommentDate() {
		return commentDate;
	}
	public void setCommentDate(String commentDate) {
		this.commentDate = commentDate;
	}
	public CommentService getCommentService() {
		return commentService;
	}
	public void setCommentService(CommentService commentService) {
		this.commentService = commentService;
	}

}
