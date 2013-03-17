package com.albert.bs.service;

import java.util.List;

import com.albert.bs.model.Recipient;

public interface RecipientService {

	public Recipient findById(String recipientId);

	public Recipient add(Recipient recipient);
	
	public void update(Recipient recipient);
	
	public void delete(Recipient recipient);
	
	public List<Recipient> findAll(String userId);
	
	public void setDefault(String userId, String recipientId);

	public int getCountByUser(String userId);
	
	public boolean isUsed(String recipientId);
	
	public List<Recipient> getUnUsedRecipients(String userId);
	
	public Recipient getLeastUsedRecipient(String userId);
	
	public void hidRecipient(String recipientId);
	
}
