package com.albert.bs.user.action.comment;

import java.util.List;
import java.util.Map;

import com.albert.bs.model.Comment;
import com.albert.bs.model.Paginate;
import com.albert.bs.model.SessionContainer;
import com.albert.bs.service.CommentService;
import com.albert.bs.user.action.UserAction;
import com.opensymphony.xwork2.ActionContext;

/**
 * 所有评价
 * @author Albert
 *
 */
public class AllCommentsAction extends UserAction {
	private static final long serialVersionUID = 8087027378479395626L;

	private Integer page_index;
	private CommentService commentService;
	
	@SuppressWarnings("unchecked")
	public String execute() throws Exception {
		Map session = (Map) ActionContext.getContext().getSession();
		SessionContainer container = (SessionContainer) session.get("container");
		
		Map request = (Map) ActionContext.getContext().get("request");
		Paginate<Comment> comments = new Paginate<Comment>();
		if(page_index == null || page_index == 0) {
			page_index = 1;
		}
		comments.setCurrentPage(page_index);
		comments.setAllRecords(commentService.getUserCommentCount(container.getUser().getUserId()));
		comments.setAllPages((comments.getAllRecords() - 1) / comments.getRecordInPage() + 1);
		List<Comment> list = commentService.getUserComments(container.getUser().getUserId(), (page_index- 1) * comments.getRecordInPage(), comments.getRecordInPage());
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
