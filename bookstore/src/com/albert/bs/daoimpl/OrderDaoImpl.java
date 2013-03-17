package com.albert.bs.daoimpl;

import java.util.Date;
import java.util.List;

import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import com.albert.bs.constant.OrderStatus;
import com.albert.bs.dao.OrderDao;
import com.albert.bs.model.Order;

public class OrderDaoImpl extends BaseDaoImpl<Order, String> implements OrderDao {

	public int getDeliveriedOrdersCount(String userId) {
		return (Integer) getSession(false).createCriteria(Order.class).setProjection(Projections.rowCount()).add(Restrictions.eq("user.userId", userId)).add(Restrictions.eq("status", OrderStatus.DELIVERIED)).uniqueResult();
	}
	@SuppressWarnings("unchecked")
	public List<Order> getDeliveriedOrders(String userId) {
		return getSession(false).createCriteria(Order.class).add(Restrictions.eq("user.userId", userId)).add(Restrictions.eq("status", OrderStatus.DELIVERIED)).addOrder(org.hibernate.criterion.Order.asc("deliveryTime")).list();		
	}
	
	public int getDeliveriedOrdersCount() {
		return (Integer) getSession(false).createCriteria(Order.class).setProjection(Projections.rowCount()).add(Restrictions.eq("status", OrderStatus.DELIVERIED)).uniqueResult();
	}
	@SuppressWarnings("unchecked")
	public List<Order> getDeliveriedOrders() {
		return getSession(false).createCriteria(Order.class).add(Restrictions.eq("status", OrderStatus.DELIVERIED)).list();		
	}
	
	public int getNewOrdersCount() {
		return (Integer) getSession(false).createCriteria(Order.class).setProjection(Projections.rowCount()).add(Restrictions.eq("status", OrderStatus.UNDELIVERIED)).uniqueResult();
	}
	@SuppressWarnings("unchecked")
	public List<Order> getNewOrders(int start, int count) {
		return getSession(false).createCriteria(Order.class).add(Restrictions.eq("status", OrderStatus.UNDELIVERIED)).addOrder(org.hibernate.criterion.Order.asc("createTime")).setFirstResult(start).setMaxResults(count).list();
	}

	public Order getOrder(String orderNumber) {
		return (Order) getSession(false).createCriteria(Order.class).add(Restrictions.eq("orderNumber", orderNumber)).uniqueResult();
	}

	public int getOrdersCount(Date createTime) {
		String hql = "select count(orderId) from Order where date(:createTime) = date_format(createTime,'%Y%m%d')";
		return ((Long) getSession(false).createQuery(hql).setDate("createTime", createTime).uniqueResult()).intValue();
	}
	@SuppressWarnings("unchecked")
	public List<Order> getOrders(Date createTime, int start, int count) {
		String hql = "from Order where date(:createTime) = date_format(createTime,'%Y%m%d') order by createTime desc";
		return getSession(false).createQuery(hql).setDate("createTime", createTime).setFirstResult(start).setMaxResults(count).list();
	}
	
	public void deliver(String orderId) {
		Order order = (Order) getHibernateTemplate().load(Order.class, orderId);
		order.setStatus(OrderStatus.DELIVERIED);
		order.setDeliveryTime(new Date());
		getHibernateTemplate().update(order);
	}
	
	public void receive(String orderId) {
		Order order = (Order) getHibernateTemplate().load(Order.class, orderId);
		order.setStatus(OrderStatus.FINISHED);
		getHibernateTemplate().update(order);
	}
	
	@SuppressWarnings("unchecked")
	public List<Order> getUnDeliveredOrders(String userId) {
		return getSession(false).createCriteria(Order.class).add(Restrictions.eq("user.userId", userId)).add(Restrictions.eq("status", OrderStatus.UNDELIVERIED)).addOrder(org.hibernate.criterion.Order.desc("createTime")).list();		
	}
	
	public int getFinishedOrdersCount(String userId) {
		return (Integer) getSession(false).createCriteria(Order.class).setProjection(Projections.rowCount()).add(Restrictions.eq("user.userId", userId)).add(Restrictions.eq("status", OrderStatus.FINISHED)).uniqueResult();
	}
	@SuppressWarnings("unchecked")
	public List<Order> getFinishedOrders(String userId, int start, int count) {
		return getSession(false).createCriteria(Order.class).add(Restrictions.eq("user.userId", userId)).add(Restrictions.eq("status", OrderStatus.FINISHED)).addOrder(org.hibernate.criterion.Order.desc("createTime")).setFirstResult(start).setMaxResults(count).list();			
	}
	
}
