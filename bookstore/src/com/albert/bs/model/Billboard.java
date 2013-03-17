package com.albert.bs.model;

import java.io.Serializable;
import java.util.Date;

import com.albert.bs.constant.BillBoardStatus;

/**
 * 公告
 * 
 * @author Albert
 * @version V1.0 2012-03-25
 * @since JDK5.0
 */
public class Billboard implements Serializable {
	private static final long serialVersionUID = 7127381605206575438L;

	private String billboardId;
	private String title; //公告标题
	private String content; //公告内容
	private Date publishTime; //公告发布时间
	private Integer status = BillBoardStatus.SHOW; //公告状态（显示/隐藏）
	
	public Billboard() {
		
	}
	public Billboard(String billboardId) {
		this.billboardId = billboardId;
	}
	public Billboard(String billboardId, String title, String content,
			Date publishTime, Integer status) {
		super();
		this.billboardId = billboardId;
		this.title = title;
		this.content = content;
		this.publishTime = publishTime;
		this.status = status;
	}
	public String getBillboardId() {
		return billboardId;
	}
	public void setBillboardId(String billboardId) {
		this.billboardId = billboardId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getPublishTime() {
		return publishTime;
	}
	public void setPublishTime(Date publishTime) {
		this.publishTime = publishTime;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((billboardId == null) ? 0 : billboardId.hashCode());
		result = prime * result + ((content == null) ? 0 : content.hashCode());
		result = prime * result
				+ ((publishTime == null) ? 0 : publishTime.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Billboard other = (Billboard) obj;
		if (billboardId == null) {
			if (other.billboardId != null)
				return false;
		} else if (!billboardId.equals(other.billboardId))
			return false;
		if (content == null) {
			if (other.content != null)
				return false;
		} else if (!content.equals(other.content))
			return false;
		if (publishTime == null) {
			if (other.publishTime != null)
				return false;
		} else if (!publishTime.equals(other.publishTime))
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "BillBoard [content=" + content + "]";
	}
	
}
