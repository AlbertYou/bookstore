package com.albert.bs.daoimpl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.criterion.Order;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Property;
import org.hibernate.criterion.Restrictions;

import com.albert.bs.constant.BillBoardStatus;
import com.albert.bs.dao.BillboardDao;
import com.albert.bs.model.Billboard;

public class BillboardDaoImpl extends BaseDaoImpl<Billboard, String> implements BillboardDao {

	@SuppressWarnings("unchecked")
	public List<Billboard> getAllBillboards(int start, int count) {
		ProjectionList pl = Projections.projectionList();
		pl.add(Property.forName("billboardId"));
		pl.add(Property.forName("title"));
		pl.add(Property.forName("publishTime"));
		pl.add(Property.forName("status"));
		List<Object[]> objs = getSession(false).createCriteria(Billboard.class).setProjection(pl).addOrder(Order.desc("publishTime")).setFirstResult(start).setMaxResults(count).list();
		List<Billboard> billboards = new ArrayList<Billboard>();
		for (Object[] obj : objs) {
			Billboard b = new Billboard(obj[0].toString());
			b.setTitle(obj[1].toString());
			b.setPublishTime((Date) obj[2]);
			b.setStatus((Integer) obj[3]);
			billboards.add(b);
		}
		return billboards;
	}

	@SuppressWarnings("unchecked")
	public List<Billboard> getCurrentBillboards() {
		ProjectionList pl = Projections.projectionList();
		pl.add(Property.forName("billboardId"));
		pl.add(Property.forName("title"));
		pl.add(Property.forName("publishTime"));
		List<Object[]> objs = getSession(false).createCriteria(Billboard.class).setProjection(pl).add(Restrictions.eq("status", BillBoardStatus.SHOW)).addOrder(Order.desc("publishTime")).list();
		List<Billboard> billboards = new ArrayList<Billboard>();
		for (Object[] obj : objs) {
			Billboard b = new Billboard(obj[0].toString());
			b.setTitle(obj[1].toString());
			b.setPublishTime((Date) obj[2]);
			billboards.add(b);
		}
		return billboards;
	}

	public void hid(String billboardId) {
		Billboard billboard = (Billboard) getHibernateTemplate().load(Billboard.class, billboardId);
		billboard.setStatus(BillBoardStatus.HIDDEN);
		getHibernateTemplate().update(billboard);
	}

}
