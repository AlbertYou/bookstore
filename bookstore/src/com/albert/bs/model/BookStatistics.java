package com.albert.bs.model;

import java.io.Serializable;

/**
 * 图书的统计数据
 * 
 * @author Albert
 * @version V1.0 2012-03-25
 * @since JDK5.0
 */
public class BookStatistics implements Serializable {
	private static final long serialVersionUID = -1633758389066277003L;
	
	private Integer sellCount; //购买人气
	private Integer collectCount; //收藏人气
	private Integer commentCount; //评论总数
	private Double avgCommentScore; //评价评分
	
	public BookStatistics() {
		
	}
	public BookStatistics(Integer sellCount,
			Integer collectCount, Integer commentCount, Double avgCommentScore) {
		super();
		this.sellCount = sellCount;
		this.collectCount = collectCount;
		this.commentCount = commentCount;
		this.avgCommentScore = avgCommentScore;
	}
	public Integer getSellCount() {
		return sellCount;
	}
	public void setSellCount(Integer sellCount) {
		this.sellCount = sellCount;
	}
	public Integer getCollectCount() {
		return collectCount;
	}
	public void setCollectCount(Integer collectCount) {
		this.collectCount = collectCount;
	}
	public Integer getCommentCount() {
		return commentCount;
	}
	public void setCommentCount(Integer commentCount) {
		this.commentCount = commentCount;
	}
	public Double getAvgCommentScore() {
		return avgCommentScore;
	}
	public void setAvgCommentScore(Double avgCommentScore) {
		this.avgCommentScore = avgCommentScore;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((avgCommentScore == null) ? 0 : avgCommentScore.hashCode());
		result = prime * result
				+ ((collectCount == null) ? 0 : collectCount.hashCode());
		result = prime * result
				+ ((commentCount == null) ? 0 : commentCount.hashCode());
		result = prime * result
				+ ((sellCount == null) ? 0 : sellCount.hashCode());
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
		BookStatistics other = (BookStatistics) obj;
		if (avgCommentScore == null) {
			if (other.avgCommentScore != null)
				return false;
		} else if (!avgCommentScore.equals(other.avgCommentScore))
			return false;
		if (collectCount == null) {
			if (other.collectCount != null)
				return false;
		} else if (!collectCount.equals(other.collectCount))
			return false;
		if (commentCount == null) {
			if (other.commentCount != null)
				return false;
		} else if (!commentCount.equals(other.commentCount))
			return false;
		if (sellCount == null) {
			if (other.sellCount != null)
				return false;
		} else if (!sellCount.equals(other.sellCount))
			return false;
		return true;
	}
	
}
