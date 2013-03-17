package com.albert.bs.daoimpl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Property;
import org.hibernate.criterion.Restrictions;

import com.albert.bs.constant.BookStatus;
import com.albert.bs.dao.BookDao;
import com.albert.bs.model.Book;
import com.albert.bs.model.OrderItem;

public class BookDaoImpl extends BaseDaoImpl<Book, String> implements BookDao {

	@SuppressWarnings("unchecked")
	public List<Book> findByName(String name, int start, int count) {
		return getSession(false).createCriteria(Book.class).add(Restrictions.like("name", "%" + name + "%")).setFirstResult(start).setMaxResults(count).list(); 
	}
	public int findCountByName(String name) {
		return (Integer) getSession(false).createCriteria(Book.class).setProjection(Projections.rowCount()).add(Restrictions.like("name", "%" + name + "%")).uniqueResult(); 
	}
	
	@SuppressWarnings("unchecked")
	public List<Book> findByCategory(String categoryId, int start, int count) {
		String sql = "select {b.*} from book b left outer join orderitem oi on b.bookid = oi.bookid left outer join orders o on oi.orderid = o.orderid where b.categoryid = ? group by b.bookid order by sum(oi.quantity) desc limit ?,?;";
		SQLQuery query = getSession(false).createSQLQuery(sql);
		query.addEntity("b", Book.class);
		List<Book> books = query.setString(0, categoryId).setInteger(1, start).setInteger(2, count).list();
		return books;
	}
	public int findCountByCategory(String categoryId) {
		return (Integer) getSession(false).createCriteria(Book.class).setProjection(Projections.rowCount()).add(Restrictions.eq("category.categoryId", categoryId)).uniqueResult(); 		
	}
	
	@SuppressWarnings("unchecked")
	public List<Book> findLowStockBooks(int stock) {
		return getSession(false).createCriteria(Book.class).add(Restrictions.lt("stock", stock)).add(Restrictions.eq("status", BookStatus.ONSHELF)).list();
	}

	public synchronized void modifyImage(String bookId, String imageUrl) {
		Book book = (Book) getHibernateTemplate().load(Book.class, bookId);
		book.setImageUrl(imageUrl);
		getHibernateTemplate().update(book);
	}
	
	//修改库存方法同步
	public synchronized void modifyStock(String bookId, int stock) {
		Book book = (Book) getHibernateTemplate().load(Book.class, bookId);
		book.setStock(stock);
		getHibernateTemplate().update(book);
	}
	
	public int getStock(String bookId) {
		return (Integer) getSession(false).createCriteria(Book.class).setProjection(Property.forName("stock")).add(Restrictions.eq("bookId", bookId)).uniqueResult(); 		
	}
	
	public void downShelf(String bookId) {
		Book book = (Book) getHibernateTemplate().load(Book.class, bookId);
		book.setStatus(BookStatus.DOWNSHELF);		
		getHibernateTemplate().update(book);
	}
	
	public int findNewBooksCount() {
		String hql = "select count(book.bookId) from Book book where datediff(curdate(),book.onShelfDate) < 2";
		return ((Long) getSession(false).createQuery(hql).uniqueResult()).intValue();
	}
	@SuppressWarnings("unchecked")
	public List<Book> findNewBooks(int start, int count) {
		String hql = "from Book book where datediff(curdate(),book.onShelfDate) < 2 order by book.onShelfDate desc";
		return getSession(false).createQuery(hql).setFirstResult(start).setMaxResults(count).list();
	}

	//评价标准：图书的总销量*消费者综合评分
	@SuppressWarnings("unchecked")
	public List<Book> findGoodBooks(int start, int count) {
		String sql = "select {b.*} from book b left outer join orderitem oi on b.bookid = oi.bookid left outer join comment c on b.bookid = c.bookid group by b.bookid order by count(oi.itemid)*avg(c.score) desc limit ?,?;";
		SQLQuery query = getSession(false).createSQLQuery(sql);
		query.addEntity("b", Book.class);
		List<Book> books = query.setInteger(0, start).setInteger(1, count).list();
		return books;
	}

	public int findBooksCount() {
		return (Integer) getSession(false).createCriteria(Book.class).setProjection(Projections.rowCount()).uniqueResult();
	}
	
	@SuppressWarnings("unchecked")
	public List<Book> findBestSellBooks(int start, int count) {
		String sql = "select {b.*} from book b left outer join orderitem oi on b.bookid = oi.bookid left outer join orders o on oi.orderid = o.orderid where datediff(curdate(),b.onShelfDate) < 8 group by oi.bookid order by sum(oi.quantity) desc limit ?,?;";
		SQLQuery query = getSession(false).createSQLQuery(sql);
		query.addEntity("b", Book.class);
		List<Book> books = query.setInteger(0, start).setInteger(1, count).list();
		return books;
	}

	@SuppressWarnings("unchecked")
	public List<Book> findBooksBySale(int start, int count) {
		String sql = "select {b.*} from book b left outer join orderitem oi on b.bookid = oi.bookid left outer join orders o on oi.orderid = o.orderid group by oi.bookid order by sum(oi.quantity) desc limit ?,?;";
		SQLQuery query = getSession(false).createSQLQuery(sql);
		query.addEntity("b", Book.class);
		List<Book> books = query.setInteger(0, start).setInteger(1, count).list();
		return books;
	}

	@Override
	public void update(Book book) {
		Book b = (Book) getHibernateTemplate().load(Book.class, book.getBookId());
		b.setName(book.getName());
		b.setAuthor(book.getAuthor());
		b.setCategory(book.getCategory());
		b.setPublishDate(book.getPublishDate());
		b.setPrintDate(book.getPrintDate());
		b.setPrintCount(book.getPrintCount());
		b.setPublisher(book.getPublisher());
		b.setBid(book.getBid());
		b.setOriginalPrice(book.getOriginalPrice());
		b.setDiscount(book.getDiscount());
		b.setPrice(book.getPrice());
		b.setDescription(book.getDescription());
		getHibernateTemplate().update(b);
	}
	
	@SuppressWarnings("unchecked")
	public int getPurchasedBooksCount(String userId) {
		List<String> bids = getSession(false).createCriteria(OrderItem.class).setProjection(Projections.distinct(Property.forName("book.bookId"))).createCriteria("order").add(Restrictions.eq("user.userId", userId)).list();
		return bids.size();
	}

	@SuppressWarnings("unchecked")
	public List<Book> getPurchasedBooks(String userId, int start, int count) {
		List<String> bookIds = getSession(false).createCriteria(OrderItem.class).setProjection(Projections.distinct(Property.forName("book.bookId"))).createCriteria("order").add(Restrictions.eq("user.userId", userId)).addOrder(Order.desc("createTime")).setFirstResult(start).setMaxResults(count).list();
		List<Book> books = new ArrayList<Book>();
		for (String bookId : bookIds) {
			Book book = (Book) getSession(false).createCriteria(Book.class).add(Restrictions.eq("bookId", bookId)).uniqueResult();
			books.add(book);
		}
		return books;
	}

	@SuppressWarnings("unchecked")
	public List<Book> getEmphasisBooks(String userId, int start, int count) {
		//查找用户购买图书较多的类别
		String sql="select b.categoryId from OrderItem oi inner join Orders o on oi.orderId = o.orderId inner join User u on o.userId = u.userId inner join Book b on oi.bookId = b.bookId " +
		"where u.userId = ? group by b.categoryId order by count(oi.itemId) desc limit 1";
		String categoryId =  (String) getSession(false).createSQLQuery(sql).setString(0, userId).uniqueResult();
		//根据用户购买图书较多的类别查找销量较高的图书
		String sql2="select {b.*} from book b inner join orderitem oi on b.bookid = oi.bookid " +
		"where b.categoryid = ? group by oi.bookid order by count(oi.itemId) desc limit ?, ?";
		SQLQuery query = getSession(false).createSQLQuery(sql2);
		query.addEntity("b", Book.class);
		List<Book> books = query.setString(0, categoryId).setInteger(1, start).setInteger(2, count).list();
		return books;
	}
	
}
