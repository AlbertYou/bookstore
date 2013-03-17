package com.albert.bs.serviceimpl;

import java.util.List;

import com.albert.bs.dao.BookDao;
import com.albert.bs.model.Book;
import com.albert.bs.service.BookService;

public class BookServiceImpl implements BookService {

	private BookDao dao;
	
	public Book findById(String bookId) {
		return dao.findById(bookId);
	}
	public List<Book> findByName(String name, int start, int count) {
		return dao.findByName(name, start, count);
	}
	public int findCountByName(String name) {
		return dao.findCountByName(name);
	}
	public List<Book> findByCategory(String categoryId, int start, int count) {
		return dao.findByCategory(categoryId, start, count);
	}
	public int findCountByCategory(String categoryId) {
		return dao.findCountByCategory(categoryId);
	}
	public void modifyImage(String bookId, String imageUrl) {
		dao.modifyImage(bookId, imageUrl);
	}
	public void modifyStock(String bookId, int stock) {
		dao.modifyStock(bookId, stock);
	}
	public int getStock(String bookId) {
		return dao.getStock(bookId);
	}
	public void downShelf(String bookId) {
		dao.downShelf(bookId);
	}
	public List<Book> findLowStockBooks(int stock) {
		return dao.findLowStockBooks(stock);
	}
	public void save(Book book) {
		dao.save(book);
	}
	public void update(Book book) {
		dao.update(book);
	}
	public int findBooksCount() {
		return dao.findBooksCount();
	}
	public int findNewBooksCount() {
		return dao.findNewBooksCount();
	}
	public List<Book> findNewBooks(int start, int count) {
		return dao.findNewBooks(start, count);
	}
	public List<Book> findBestSellBooks(int start, int count) {
		return dao.findBestSellBooks(start, count);
	}
	public List<Book> findBooksBySale(int start, int count) {
		return dao.findBooksBySale(start, count);
	}
	public List<Book> findGoodBooks(int start, int count) {
		return dao.findGoodBooks(start, count);
	}
	public List<Book> getPurchasedBooks(String userId, int start, int count) {
		return dao.getPurchasedBooks(userId, start, count);
	}
	public int getPurchasedBooksCount(String userId) {
		return dao.getPurchasedBooksCount(userId);
	}
	public List<Book> getEmphasisBooks(String userId, int start, int count) {
		return dao.getEmphasisBooks(userId, start, count);
	}
	
	public BookDao getDao() {
		return dao;
	}
	public void setDao(BookDao dao) {
		this.dao = dao;
	}
}
