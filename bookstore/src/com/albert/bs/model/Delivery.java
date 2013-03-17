package com.albert.bs.model;

import java.io.Serializable;

/**
 * 送货方式
 * 
 * @author Albert
 * @version V1.0 2012-03-25
 * @since JDK5.0
 */
public class Delivery implements Serializable {
	private static final long serialVersionUID = -3142461616725082839L;
	
	private String deliveryId;
	private String deliveryType; //送货方式
	private String description; //运费描述
	
	public Delivery() {
		
	}
	public Delivery(String deliveryId) {
		this.deliveryId = deliveryId;
	}
	public Delivery(String deliveryId, String deliveryType, String description) {
		super();
		this.deliveryId = deliveryId;
		this.deliveryType = deliveryType;
		this.description = description;
	}
	public String getDeliveryId() {
		return deliveryId;
	}
	public void setDeliveryId(String deliveryId) {
		this.deliveryId = deliveryId;
	}
	public String getDeliveryType() {
		return deliveryType;
	}
	public void setDeliveryType(String deliveryType) {
		this.deliveryType = deliveryType;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((deliveryId == null) ? 0 : deliveryId.hashCode());
		result = prime * result
				+ ((deliveryType == null) ? 0 : deliveryType.hashCode());
		result = prime * result
				+ ((description == null) ? 0 : description.hashCode());
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
		Delivery other = (Delivery) obj;
		if (deliveryId == null) {
			if (other.deliveryId != null)
				return false;
		} else if (!deliveryId.equals(other.deliveryId))
			return false;
		if (deliveryType == null) {
			if (other.deliveryType != null)
				return false;
		} else if (!deliveryType.equals(other.deliveryType))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Delivery [deliveryType=" + deliveryType + "]";
	}
	
}
