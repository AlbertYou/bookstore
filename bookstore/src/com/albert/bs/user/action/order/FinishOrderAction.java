package com.albert.bs.user.action.order;

import java.util.List;
import java.util.Map;

import com.albert.bs.model.Cart;
import com.albert.bs.model.Order;
import com.albert.bs.model.OrderItem;
import com.albert.bs.model.Product;
import com.albert.bs.model.Recipient;
import com.albert.bs.model.SessionContainer;
import com.albert.bs.service.BookService;
import com.albert.bs.service.OrderService;
import com.albert.bs.service.ProductService;
import com.albert.bs.user.action.UserAction;
import com.albert.bs.util.OrderNumberCreator;
import com.opensymphony.xwork2.ActionContext;

/**
 * 购物车->确认订单->提交订单(FinishOrderAction)
 * @author Albert
 *
 */
public class FinishOrderAction extends UserAction {
	private static final long serialVersionUID = 2111708273164546325L;
	
	private String recipientId;
	private OrderService orderService;
	private ProductService productService;
	private BookService bookService;
	
	@SuppressWarnings("unchecked")
	public String execute() throws Exception {
		Map session = ActionContext.getContext().getSession();
		Map request = (Map) ActionContext.getContext().get("request");
		SessionContainer container = (SessionContainer) session.get("container");
		List<Product> products = container.getCart().getProducts();
		Order order = new Order();
		String orderNumber = new OrderNumberCreator().produce();
		order.setOrderNumber(orderNumber);
		order.setUser(container.getUser());
		order.setCount(products.size());
		order.setRecipient(new Recipient(recipientId));
		double totalPrice = 0;
		for (Product product : products) {
			OrderItem oi = new OrderItem();
			oi.setBook(product.getBook());
			oi.setQuantity(product.getQuantity());
			oi.setPrice(product.getBook().getPrice());
			oi.setDiscount(product.getBook().getDiscount());
			oi.setOrder(order);
			order.getOrderItems().add(oi);
			totalPrice += product.getBook().getPrice() * product.getQuantity();
			//修改库存
		 	bookService.modifyStock(product.getBook().getBookId(), product.getBook().getStock() - product.getQuantity());
		}
		order.setTotalPrice(totalPrice);
		orderService.save(order);
		request.put("orderNumber", orderNumber);
		
		//从购物车中删除商品
		productService.deleteProducts(container.getUser().getUserId());
		Cart cart = container.getCart();
		cart.setProducts(null);
		container.setCart(cart);
		session.put("container", container);
		return SUCCESS;
	}

	public String getRecipientId() {
		return recipientId;
	}
	public void setRecipientId(String recipientId) {
		this.recipientId = recipientId;
	}
	public OrderService getOrderService() {
		return orderService;
	}
	public void setOrderService(OrderService orderService) {
		this.orderService = orderService;
	}
	public ProductService getProductService() {
		return productService;
	}
	public void setProductService(ProductService productService) {
		this.productService = productService;
	}
	public BookService getBookService() {
		return bookService;
	}
	public void setBookService(BookService bookService) {
		this.bookService = bookService;
	}

}
