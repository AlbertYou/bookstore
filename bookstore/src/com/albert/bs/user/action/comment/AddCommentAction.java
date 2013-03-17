package com.albert.bs.user.action.comment;

import com.albert.bs.model.Comment;
import com.albert.bs.service.CommentService;
import com.albert.bs.service.OrderItemService;
import com.albert.bs.user.action.UserAction;
import com.opensymphony.xwork2.ModelDriven;

/**
 * 添加评价
 * @author Albert
 *
 */
public class AddCommentAction extends UserAction implements ModelDriven<Comment> {
	private static final long serialVersionUID = 4275330285752762829L;
	
	private String itemId;
	private Comment comment = new Comment();
	private CommentService commentService;
	private OrderItemService orderItemService;
	
	public String execute() throws Exception {
		commentService.save(comment);
		orderItemService.comment(itemId);
		return SUCCESS;
	}

	public OrderItemService getOrderItemService() {
		return orderItemService;
	}
	public void setOrderItemService(OrderItemService orderItemService) {
		this.orderItemService = orderItemService;
	}
	public String getItemId() {
		return itemId;
	}
	public void setItemId(String itemId) {
		this.itemId = itemId;
	}
	public Comment getComment() {
		return comment;
	}
	public void setComment(Comment comment) {
		this.comment = comment;
	}
	public CommentService getCommentService() {
		return commentService;
	}
	public void setCommentService(CommentService commentService) {
		this.commentService = commentService;
	}
	public Comment getModel() {
		return comment;
	}
	
}
