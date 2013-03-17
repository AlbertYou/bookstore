package com.albert.bs.dao;

import java.util.List;

import com.albert.bs.model.Book;

public interface BookDao extends BaseDao<Book, String> {

	//通过书名查找
	public List<Book> findByName(String name, int start, int count);
	//通过书名查找的结果总数
	public int findCountByName(String name);

	//查找某分类的图书(销量降序)
	public List<Book> findByCategory(String categoryId, int start, int count);
	//查找某分类的图书的总数
	public int findCountByCategory(String categoryId);

	//获得低库存图书
	public List<Book> findLowStockBooks(int stock);
	
	//修改图片地址
	public void modifyImage(String bookId, String imageUrl);
	
	//修改库存
	public void modifyStock(String bookId, int stock);

	//获得某本书的库存
	public int getStock(String bookId);

	//下架
	public void downShelf(String bookId);

	//获得最近2天新书的总数
	public int findNewBooksCount();
	//获得最近2天新书(时间倒序)
	public List<Book> findNewBooks(int start, int count);
	
	public int findBooksCount();
	
	//获得好书(好书为图书的总销量高、消费者综合评分(消费者购买该图书时对该图书进行的评分的平均值))
	//评价标准：图书的总销量*消费者综合评分
	public List<Book> findGoodBooks(int start, int count);
	
	//获得畅销书(一周内销量最高)
	public List<Book> findBestSellBooks(int start, int count);
	
	//分页获得销售排行榜(累计销售量减序)
	public List<Book> findBooksBySale(int start, int count);

	//获得某用户已购商品的总数
	public int getPurchasedBooksCount(String userId);
	//获得某用户的已购商品(按购买时间降序)
	public List<Book> getPurchasedBooks(String userId, int start, int count);
	
	//根据用户购买图书较多的类别查找销量较高的图书
	public List<Book> getEmphasisBooks(String userId, int start, int count);
	
}
