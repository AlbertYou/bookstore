package com.albert.bs.model;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import com.albert.bs.constant.BookStatus;

/**
 * 图书
 * 
 * @author Albert
 * @version V1.0 2012-03-25
 * @since JDK5.0
 */
public class Book implements Serializable {
	private static final long serialVersionUID = 5752001140299561439L;
	
	private String bookId;
	private String name; //书名
	private String author; //作者
	private LowCategory category; //图书类别
	private String description; //图书描述
	private String imageUrl; //图书图片地址
	private Double bid; //图书购入价格
	private Double originalPrice; //图书定价
	private Integer discount; //折扣(例如：76折)
	private Double price; //销售价格
	private Publisher publisher; //出版社
	private Date publishDate; //出版日期
	private Integer printCount; //印次
	private Date printDate; //印刷日期
	private Date onShelfDate; //上架日期
	private Integer stock; //库存
	private Integer status = BookStatus.ONSHELF; //图书状态(1：已下架；0：上架）
	private Set<OrderItem> orderItems = new HashSet<OrderItem>();
	private Set<Comment> comments = new HashSet<Comment>();
	private BookStatistics bookStatistics; //图书统计信息
	
	public Book() {
		
	}
	public Book(String bookId) {
		this.bookId = bookId;
	}
	public Book(String bookId, String name, String author,
			LowCategory category, String description, String imageUrl,
			Double bid, Double originalPrice, Integer discount, Double price,
			Publisher publisher, Date publishDate, Integer printCount,
			Date printDate, Date onShelfDate, Integer stock, Integer status,
			Set<Comment> comments, Set<OrderItem> orderItems, BookStatistics bookStatistics) {
		super();
		this.bookId = bookId;
		this.name = name;
		this.author = author;
		this.category = category;
		this.description = description;
		this.imageUrl = imageUrl;
		this.bid = bid;
		this.originalPrice = originalPrice;
		this.discount = discount;
		this.price = price;
		this.publisher = publisher;
		this.publishDate = publishDate;
		this.printCount = printCount;
		this.printDate = printDate;
		this.onShelfDate = onShelfDate;
		this.stock = stock;
		this.status = status;
		this.comments = comments;
		this.orderItems = orderItems;
		this.bookStatistics = bookStatistics;
	}
	public String getBookId() {
		return bookId;
	}
	public void setBookId(String bookId) {
		this.bookId = bookId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public LowCategory getCategory() {
		return category;
	}
	public void setCategory(LowCategory category) {
		this.category = category;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getImageUrl() {
		return imageUrl;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	public Double getBid() {
		return bid;
	}
	public void setBid(Double bid) {
		this.bid = bid;
	}
	public Double getOriginalPrice() {
		return originalPrice;
	}
	public void setOriginalPrice(Double originalPrice) {
		this.originalPrice = originalPrice;
	}
	public Integer getDiscount() {
		return discount;
	}
	public void setDiscount(Integer discount) {
		this.discount = discount;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public Publisher getPublisher() {
		return publisher;
	}
	public void setPublisher(Publisher publisher) {
		this.publisher = publisher;
	}
	public Date getPublishDate() {
		return publishDate;
	}
	public void setPublishDate(Date publishDate) {
		this.publishDate = publishDate;
	}
	public Integer getPrintCount() {
		return printCount;
	}
	public void setPrintCount(Integer printCount) {
		this.printCount = printCount;
	}
	public Date getPrintDate() {
		return printDate;
	}
	public void setPrintDate(Date printDate) {
		this.printDate = printDate;
	}
	public Date getOnShelfDate() {
		return onShelfDate;
	}
	public void setOnShelfDate(Date onShelfDate) {
		this.onShelfDate = onShelfDate;
	}
	public Integer getStock() {
		return stock;
	}
	public void setStock(Integer stock) {
		this.stock = stock;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public Set<Comment> getComments() {
		return comments;
	}
	public void setComments(Set<Comment> comments) {
		this.comments = comments;
	}
	public Set<OrderItem> getOrderItems() {
		return orderItems;
	}
	public void setOrderItems(Set<OrderItem> orderItems) {
		this.orderItems = orderItems;
	}
	public BookStatistics getBookStatistics() {
		return bookStatistics;
	}
	public void setBookStatistics(BookStatistics bookStatistics) {
		this.bookStatistics = bookStatistics;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((author == null) ? 0 : author.hashCode());
		result = prime * result + ((bid == null) ? 0 : bid.hashCode());
		result = prime * result + ((bookId == null) ? 0 : bookId.hashCode());
		result = prime * result
				+ ((bookStatistics == null) ? 0 : bookStatistics.hashCode());
		result = prime * result
				+ ((category == null) ? 0 : category.hashCode());
		result = prime * result
				+ ((description == null) ? 0 : description.hashCode());
		result = prime * result
				+ ((discount == null) ? 0 : discount.hashCode());
		result = prime * result
				+ ((imageUrl == null) ? 0 : imageUrl.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result
				+ ((onShelfDate == null) ? 0 : onShelfDate.hashCode());
		result = prime * result
				+ ((originalPrice == null) ? 0 : originalPrice.hashCode());
		result = prime * result + ((price == null) ? 0 : price.hashCode());
		result = prime * result
				+ ((printCount == null) ? 0 : printCount.hashCode());
		result = prime * result
				+ ((printDate == null) ? 0 : printDate.hashCode());
		result = prime * result
				+ ((publishDate == null) ? 0 : publishDate.hashCode());
		result = prime * result
				+ ((publisher == null) ? 0 : publisher.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result + ((stock == null) ? 0 : stock.hashCode());
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
		Book other = (Book) obj;
		if (author == null) {
			if (other.author != null)
				return false;
		} else if (!author.equals(other.author))
			return false;
		if (bid == null) {
			if (other.bid != null)
				return false;
		} else if (!bid.equals(other.bid))
			return false;
		if (bookId == null) {
			if (other.bookId != null)
				return false;
		} else if (!bookId.equals(other.bookId))
			return false;
		if (bookStatistics == null) {
			if (other.bookStatistics != null)
				return false;
		} else if (!bookStatistics.equals(other.bookStatistics))
			return false;
		if (category == null) {
			if (other.category != null)
				return false;
		} else if (!category.equals(other.category))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (discount == null) {
			if (other.discount != null)
				return false;
		} else if (!discount.equals(other.discount))
			return false;
		if (imageUrl == null) {
			if (other.imageUrl != null)
				return false;
		} else if (!imageUrl.equals(other.imageUrl))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (onShelfDate == null) {
			if (other.onShelfDate != null)
				return false;
		} else if (!onShelfDate.equals(other.onShelfDate))
			return false;
		if (originalPrice == null) {
			if (other.originalPrice != null)
				return false;
		} else if (!originalPrice.equals(other.originalPrice))
			return false;
		if (price == null) {
			if (other.price != null)
				return false;
		} else if (!price.equals(other.price))
			return false;
		if (printCount == null) {
			if (other.printCount != null)
				return false;
		} else if (!printCount.equals(other.printCount))
			return false;
		if (printDate == null) {
			if (other.printDate != null)
				return false;
		} else if (!printDate.equals(other.printDate))
			return false;
		if (publishDate == null) {
			if (other.publishDate != null)
				return false;
		} else if (!publishDate.equals(other.publishDate))
			return false;
		if (publisher == null) {
			if (other.publisher != null)
				return false;
		} else if (!publisher.equals(other.publisher))
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		if (stock == null) {
			if (other.stock != null)
				return false;
		} else if (!stock.equals(other.stock))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Book [name=" + name + "]";
	}
	
}
