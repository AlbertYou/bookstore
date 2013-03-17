package com.albert.bs.daoimpl;

import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import com.albert.bs.constant.RecipientAddressStatus;
import com.albert.bs.constant.RecipientStatus;
import com.albert.bs.dao.RecipientDao;
import com.albert.bs.model.Order;
import com.albert.bs.model.Recipient;

public class RecipientDaoImpl extends BaseDaoImpl<Recipient, String> implements RecipientDao {

	public void update(Recipient recipient) {
		Recipient r = (Recipient) getHibernateTemplate().load(Recipient.class, recipient.getRecipientId());
		r.setRecipient(recipient.getRecipient());
		r.setDefaultAddr(recipient.getDefaultAddr());
		r.setZipcode(recipient.getZipcode());
		r.setAddress(recipient.getAddress());
		r.setPhone(recipient.getPhone());
		r.setUser(recipient.getUser());
		getHibernateTemplate().update(r);
	}
	
	public Recipient add(Recipient recipient) {
		String recipientId = (String) getHibernateTemplate().save(recipient);
		recipient.setRecipientId(recipientId);
		return recipient;
	}
	
	public void delete(Recipient recipient) {
		Recipient r = (Recipient) getHibernateTemplate().load(Recipient.class, recipient.getRecipientId());
		getHibernateTemplate().delete(r);
	}
	
	@SuppressWarnings("unchecked")
	public List<Recipient> findAll(String userId) {
		return getSession(false).createCriteria(Recipient.class).add(Restrictions.eq("status", RecipientStatus.SHOW)).add(Restrictions.eq("user.userId", userId)).list();
	}

	public int getCountByUser(String userId) {
		return (Integer) getSession(false).createCriteria(Recipient.class).setProjection(Projections.rowCount()).add(Restrictions.eq("status", RecipientStatus.SHOW)).add(Restrictions.eq("user.userId", userId)).uniqueResult();
	}

	@SuppressWarnings("unchecked")
	public void setDefault(String userId, String recipientId) {
		Recipient recipient = (Recipient) getHibernateTemplate().load(Recipient.class, recipientId);
		List<Recipient> recipients = getSession(false).createCriteria(Recipient.class).add(Restrictions.eq("user.userId", userId)).list();
		for (Recipient r : recipients) {  //只能有一个默认地址
			if(r.getDefaultAddr() == RecipientAddressStatus.DEFAULT_ADDRESS) {
				r.setDefaultAddr(RecipientAddressStatus.NOT_DEFAULT_ADDRESS);
				getHibernateTemplate().update(r);
			}
		}
		recipient.setDefaultAddr(RecipientAddressStatus.DEFAULT_ADDRESS);
		getHibernateTemplate().update(recipient);
	}
	
	public boolean isUsed(String recipientId) {
		int count = (Integer) getSession(false).createCriteria(Order.class).setProjection(Projections.rowCount()).add(Restrictions.eq("recipient.recipientId", recipientId)).uniqueResult();
		if(count > 0) {
			return true;
		}
		return false;
	}
	
	@SuppressWarnings("unchecked")
	public List<Recipient> getUnUsedRecipients(String userId) {
		String hql = "from Recipient r where r.user.userId = :userId and not exists (" +
						"select o.recipient.recipientId from Order o where o.recipient.recipientId = r.recipientId)";
		return getSession(false).createQuery(hql).setString("userId", userId).list();
	}
	
	//获得当前使用过的且使用次数最少的收货地址（除了默认地址）
	public Recipient getLeastUsedRecipient(String userId) {
		String hql = "select {r.*} from recipient r inner join orders o on r.recipientid = o.recipientid where r.userid = :userId and r.defaultaddr = 0 and r.status = 0 " +
		"group by o.recipientid order by count(o.orderid) asc limit 1;";
		SQLQuery query = getSession(false).createSQLQuery(hql);
		query.addEntity("r", Recipient.class);
		return (Recipient) query.setString("userId", userId).uniqueResult();
	}
	
	public void hidRecipient(String recipientId) {
		Recipient recipient = (Recipient) getHibernateTemplate().load(Recipient.class, recipientId);
		recipient.setStatus(RecipientStatus.HIDDEN);
		getHibernateTemplate().update(recipient);
	}

}
