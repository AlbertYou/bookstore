package com.albert.bs.daoimpl;

import java.util.List;

import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import com.albert.bs.constant.OrderItemStatus;
import com.albert.bs.constant.OrderStatus;
import com.albert.bs.dao.OrderItemDao;
import com.albert.bs.model.OrderItem;

public class OrderItemDaoImpl extends BaseDaoImpl<OrderItem, String> implements OrderItemDao {

	public int getTodayCount() {
		String sql = "select sum(oi.quantity) from OrderItem oi,Order o where oi.order.orderId = o.orderId and curdate() = date(o.createTime)";
		Long i = (Long) getSession(false).createQuery(sql).uniqueResult();
		if(i == null) {
			return 0;
		}
		return i.intValue();
	}

	public int getCountByBook(String bookId) {
		return (Integer) getSession(false).createCriteria(OrderItem.class).setProjection(Projections.rowCount()).add(Restrictions.eq("book.bookId", bookId)).uniqueResult();
	}

	public int getFinishedOrdersCount(String userId) {
		return (Integer) getSession(false).createCriteria(OrderItem.class).setProjection(Projections.rowCount()).add(Restrictions.eq("isCommented", OrderItemStatus.NOT_COMMENTED)).createCriteria("order").add(Restrictions.eq("user.userId", userId)).add(Restrictions.eq("status", OrderStatus.FINISHED)).uniqueResult();		
	}

	@SuppressWarnings("unchecked")
	public List<OrderItem> getFinishedOrders(String userId) {
		return getSession(false).createCriteria(OrderItem.class).add(Restrictions.eq("isCommented", OrderItemStatus.NOT_COMMENTED)).createCriteria("order").add(Restrictions.eq("user.userId", userId)).add(Restrictions.eq("status", OrderStatus.FINISHED)).list();		
	}

	public void comment(String itemId) {
		OrderItem oi = (OrderItem) getHibernateTemplate().load(OrderItem.class, itemId);
		oi.setIsCommented(OrderItemStatus.HAS_COMMENTED);
		getHibernateTemplate().update(oi);
	}

}
