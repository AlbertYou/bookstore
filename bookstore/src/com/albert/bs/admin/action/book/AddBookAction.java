package com.albert.bs.admin.action.book;

import java.io.File;
import java.util.Date;

import org.apache.struts2.ServletActionContext;

import com.albert.bs.admin.action.AdminAction;
import com.albert.bs.model.Book;
import com.albert.bs.service.BookService;
import com.albert.bs.util.ImageCut;
import com.opensymphony.xwork2.ModelDriven;

public class AddBookAction extends AdminAction implements ModelDriven<Book> {
	private static final long serialVersionUID = 904221352435174347L;
	
	private Book book = new Book();
	private File image;
	private String imageContentType;
	private String imageFileName;
	
	private BookService bookService;
	
	public void uploadFile(File source, File target) {
		ImageCut.scale(source.getAbsolutePath(), target.getAbsolutePath(), 440, 550);
	}
	
	public String execute() throws Exception {
		if(image != null) {
			String imageName = new Date().getTime() + imageFileName.substring(imageFileName.lastIndexOf("."));
			String imageAddress = ServletActionContext.getServletContext().getRealPath("bookimage") + "\\" + imageName;
			String imageUrl = "..//bookimage//" + imageName;
			
			File target = new File(imageAddress);
			uploadFile(image, target);
			
			book.setImageUrl(imageUrl);
		}
		bookService.save(book);
		return SUCCESS;
	}
	
	public Book getBook() {
		return book;
	}
	public void setBook(Book book) {
		this.book = book;
	}
	public File getImage() {
		return image;
	}
	public void setImage(File image) {
		this.image = image;
	}

	public String getImageContentType() {
		return imageContentType;
	}
	public void setImageContentType(String imageContentType) {
		this.imageContentType = imageContentType;
	}
	public String getImageFileName() {
		return imageFileName;
	}
	public void setImageFileName(String imageFileName) {
		this.imageFileName = imageFileName;
	}
	public BookService getBookService() {
		return bookService;
	}
	public void setBookService(BookService bookService) {
		this.bookService = bookService;
	}
	public Book getModel() {
		return book;
	}

}
