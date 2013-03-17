package com.albert.bs.model;

import java.io.Serializable;

import com.albert.bs.constant.RecipientAddressStatus;
import com.albert.bs.constant.RecipientStatus;

/**
 * 收货地址
 * 
 * @author Albert
 * @version V1.0 2012-03-25
 * @since JDK5.0
 */
public class Recipient implements Serializable {
	private static final long serialVersionUID = 5354878442648468977L;
	
	private String recipientId;
	private User user; //用户
	private String recipient; //收货人
	private String phone; //手机
	private String address; //地址
	private String zipcode; //邮编
	private Integer defaultAddr = RecipientAddressStatus.NOT_DEFAULT_ADDRESS; //1:默认地址；0：非默认地址
	private Integer status = RecipientStatus.SHOW; //0:显示；1：隐藏
	
	public Recipient() {
		
	}
	public Recipient(String recipientId) {
		this.recipientId = recipientId;
	}
	public Recipient(String recipientId, User user, String recipient,
			String phone, String address, String zipcode, Integer defaultAddr,
			Integer status) {
		super();
		this.recipientId = recipientId;
		this.user = user;
		this.recipient = recipient;
		this.phone = phone;
		this.address = address;
		this.zipcode = zipcode;
		this.defaultAddr = defaultAddr;
		this.status = status;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public String getRecipientId() {
		return recipientId;
	}
	public void setRecipientId(String recipientId) {
		this.recipientId = recipientId;
	}
	public String getRecipient() {
		return recipient;
	}
	public void setRecipient(String recipient) {
		this.recipient = recipient;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getZipcode() {
		return zipcode;
	}
	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}
	public Integer getDefaultAddr() {
		return defaultAddr;
	}
	public void setDefaultAddr(Integer defaultAddr) {
		this.defaultAddr = defaultAddr;
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
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result
				+ ((defaultAddr == null) ? 0 : defaultAddr.hashCode());
		result = prime * result + ((phone == null) ? 0 : phone.hashCode());
		result = prime * result
				+ ((recipient == null) ? 0 : recipient.hashCode());
		result = prime * result
				+ ((recipientId == null) ? 0 : recipientId.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result + ((user == null) ? 0 : user.hashCode());
		result = prime * result + ((zipcode == null) ? 0 : zipcode.hashCode());
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
		Recipient other = (Recipient) obj;
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
		if (defaultAddr == null) {
			if (other.defaultAddr != null)
				return false;
		} else if (!defaultAddr.equals(other.defaultAddr))
			return false;
		if (phone == null) {
			if (other.phone != null)
				return false;
		} else if (!phone.equals(other.phone))
			return false;
		if (recipient == null) {
			if (other.recipient != null)
				return false;
		} else if (!recipient.equals(other.recipient))
			return false;
		if (recipientId == null) {
			if (other.recipientId != null)
				return false;
		} else if (!recipientId.equals(other.recipientId))
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		if (user == null) {
			if (other.user != null)
				return false;
		} else if (!user.equals(other.user))
			return false;
		if (zipcode == null) {
			if (other.zipcode != null)
				return false;
		} else if (!zipcode.equals(other.zipcode))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Recipient [recipient=" + recipient + ", address=" + address + "]";
	}
	
}
