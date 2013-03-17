package com.albert.bs.dao;

import java.util.List;

import com.albert.bs.model.Recipient;

public interface RecipientDao extends BaseDao<Recipient, String>{

	//设为默认地址
	public void setDefault(String userId, String recipientId);
	
	//新增收货地址
	public Recipient add(Recipient recipient);
	
	//查找某用户的收货地址个数
	public int getCountByUser(String userId);
	
	//获得某用户的所有收货地址
	public List<Recipient> findAll(String userId);
	
	//判断该收货地址是否使用过
	public boolean isUsed(String recipientId);
	
	//获得未使用过的收货地址
	public List<Recipient> getUnUsedRecipients(String userId);
	
	//获得当前使用过的且使用次数最少的收货地址（除了默认地址）
	public Recipient getLeastUsedRecipient(String userId);
	
	//隐藏收货地址
	public void hidRecipient(String recipientId);
	
}
