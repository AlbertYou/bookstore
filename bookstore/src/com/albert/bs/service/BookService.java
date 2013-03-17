package com.albert.bs.service;

import java.util.List;

import com.albert.bs.model.Book;

public interface BookService {

	public Book findById(String bookId);

	public List<Book> findByName(String name, int start, int count);
	public int findCountByName(String name);

	public List<Book> findByCategory(String categoryId, int start, int count);
	public int findCountByCategory(String categoryId);
	
	public void modifyImage(String bookId, String imageUrl);
	
	public void modifyStock(String bookId, int stock);
	
	public int getStock(String bookId);
	
	public void downShelf(String bookId);
	
	public List<Book> findLowStockBooks(int stock);
	
	public void save(Book book);
	
	public void update(Book book);
	
	public int findBooksCount();
	
	public int findNewBooksCount();
	public List<Book> findNewBooks(int start, int count);
	
	public List<Book> findGoodBooks(int start, int count);
	
	public List<Book> findBestSellBooks(int start, int count);
	
	public List<Book> findBooksBySale(int start, int count);

	public int getPurchasedBooksCount(String userId);
	public List<Book> getPurchasedBooks(String userId, int start, int count);
	
	public List<Book> getEmphasisBooks(String userId, int start, int count);
	
}
