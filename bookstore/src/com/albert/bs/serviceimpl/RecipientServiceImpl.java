package com.albert.bs.serviceimpl;

import java.util.List;

import com.albert.bs.dao.RecipientDao;
import com.albert.bs.model.Recipient;
import com.albert.bs.service.RecipientService;

public class RecipientServiceImpl implements RecipientService {

	private RecipientDao dao;
	
	public void delete(Recipient recipient) {
		dao.delete(recipient);
	}
	public List<Recipient> findAll(String userId) {
		return dao.findAll(userId);
	}
	public Recipient findById(String recipientId) {
		return dao.findById(recipientId);
	}
	public int getCountByUser(String userId) {
		return dao.getCountByUser(userId);
	}
	public Recipient add(Recipient recipient) {
		return dao.add(recipient);
	}
	public void setDefault(String userId, String recipientId) {
		dao.setDefault(userId, recipientId);
	}
	public void update(Recipient recipient) {
		dao.update(recipient);
	}
	public boolean isUsed(String recipientId) {
		return dao.isUsed(recipientId);
	}
	public List<Recipient> getUnUsedRecipients(String userId) {
		return dao.getUnUsedRecipients(userId);
	}
	public Recipient getLeastUsedRecipient(String userId) {
		return dao.getLeastUsedRecipient(userId);
	}
	public void hidRecipient(String recipientId) {
		dao.hidRecipient(recipientId);
	}
	
	public RecipientDao getDao() {
		return dao;
	}
	public void setDao(RecipientDao dao) {
		this.dao = dao;
	}

}
