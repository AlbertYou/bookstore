package com.albert.bs.admin.action.book;

import java.io.File;
import java.util.Date;

import org.apache.struts2.ServletActionContext;

import com.albert.bs.admin.action.AdminAction;
import com.albert.bs.model.Book;
import com.albert.bs.service.BookService;
import com.albert.bs.util.ImageCut;

public class ModifyImageAction extends AdminAction {
	private static final long serialVersionUID = -2627096291920529451L;
	
	private String bookId;
	private File image;
	private String imageContentType;
	private String imageFileName;
	
	private BookService bookService;
	
	public void uploadFile(File source, File target) {
		ImageCut.scale(source.getAbsolutePath(), target.getAbsolutePath(), 440, 550);
	}
	
	public String execute() throws Exception {
		Book book = bookService.findById(bookId);
		//旧图片信息
		String oldImageName = book.getImageUrl().substring(book.getImageUrl().lastIndexOf("//"));
		String oldImageAddress = ServletActionContext.getServletContext().getRealPath("bookimage") + "\\" + oldImageName;;
		//新图片信息
		String imageName = new Date().getTime() + imageFileName.substring(imageFileName.lastIndexOf("."));
		String imageUrl = "..//bookimage//" + imageName;
		String imageAddress = ServletActionContext.getServletContext().getRealPath("bookimage") + "\\" + imageName;
		//更新数据库
		book.setImageUrl(imageUrl);
		bookService.modifyImage(bookId, imageUrl);
		//删除旧图片
		File oldimage = new File(oldImageAddress);
		oldimage.delete();
		//上传新图片
		File target = new File(imageAddress);
		uploadFile(image, target);
		return SUCCESS;
	}
	
	public String getBookId() {
		return bookId;
	}
	public void setBookId(String bookId) {
		this.bookId = bookId;
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

}
