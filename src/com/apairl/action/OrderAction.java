package com.apairl.action;

import java.sql.Timestamp;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;

import com.apairl.dao.CartProductDAO;
import com.apairl.dao.KabupatenDAO;
import com.apairl.dao.OrderDAO;
import com.apairl.dao.OrderProductDAO;
import com.apairl.dao.OrderShipDAO;
import com.apairl.dao.PaymentMethodDAO;
import com.apairl.dao.StockDAO;
import com.apairl.dbo.CartProduct;
import com.apairl.dbo.Customer;
import com.apairl.dbo.Kabupaten;
import com.apairl.dbo.Order;
import com.apairl.dbo.OrderProduct;
import com.apairl.dbo.OrderShip;
import com.apairl.dbo.PaymentMethod;
import com.opensymphony.xwork2.ActionSupport;

public class OrderAction extends ActionSupport{
	private static final Logger log = Logger.getLogger(OrderAction.class);
	
	private OrderDAO orderDAO;
	private CartProductDAO cartProductDAO;
	private OrderProductDAO orderProductDAO;
	private OrderShipDAO orderShipDAO;
	private PaymentMethodDAO paymentMethodDAO;
	private KabupatenDAO kabupatenDAO;
	private StockDAO stockDAO;
	
	private Integer paymentMethodId;
	private String shipName;
	private String shipLast;
	private String shipAddress;
	private String shipAddress2;
	private Integer shipPost;
	private Integer shipKabupatenId;
	private String shipPhone;
	
	private Integer isSameAddr;
	
	public Order copyCartToOrder(){
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		Customer customer = (Customer) session.getAttribute("customer");
		
		Order order = new Order();
		order.setCustomer(customer);
		orderDAO.save(order);
		
		List<CartProduct> cpList = cartProductDAO.findByProperty("cart.customer.customerId", customer.getCustomerId());
		for(CartProduct cp : cpList){
			OrderProduct op = new OrderProduct();
			op.setOrder(order);
			op.setProduct(cp.getProduct());
			op.setSize(cp.getSize());
			op.setQty(cp.getQty());
			op.setSum(cp.getSum());
			try{
				orderProductDAO.save(op);
			} catch(Exception e){
				log.error("Copy to order failed", e);
				return null;
			}
		}
		
		return order;
	}

	public String checkout(){
		Order order = copyCartToOrder();
		
		OrderShip os = new OrderShip();
		os.setOrder(order);
		os.setInsertDate(new Timestamp(System.currentTimeMillis()));

		PaymentMethod pm = paymentMethodDAO.findById(paymentMethodId);
		os.setPaymentMethod(pm);
		
		if(isSameAddr != null && isSameAddr != 0){
			Customer customer = order.getCustomer();
			os.setShipName(customer.getName());
			os.setShipLast(customer.getLast());
			os.setShipAddress(customer.getAddress());
			os.setShipAddress2(customer.getAddress2());
			os.setShipPost(customer.getPost());
			os.setShipPhone(customer.getPhone());
		} else {
			os.setShipName(shipName);
			os.setShipLast(shipLast);
			os.setShipAddress(shipAddress);
			os.setShipAddress2(shipAddress2);
			os.setShipPost(shipPost);
			os.setShipPhone(shipPhone);
		}

		Kabupaten shipKabupaten = kabupatenDAO.findById(shipKabupatenId);
		os.setShipKabupaten(shipKabupaten);
		
		try{
			orderShipDAO.save(os);
		}catch(Exception e){
			log.error("Checkout error", e);
			return "systemerror";
		}
		
		return SUCCESS;
	}

	public OrderDAO getOrderDAO() {
		return orderDAO;
	}

	public void setOrderDAO(OrderDAO orderDAO) {
		this.orderDAO = orderDAO;
	}

	public CartProductDAO getCartProductDAO() {
		return cartProductDAO;
	}

	public void setCartProductDAO(CartProductDAO cartProductDAO) {
		this.cartProductDAO = cartProductDAO;
	}

	public OrderProductDAO getOrderProductDAO() {
		return orderProductDAO;
	}

	public void setOrderProductDAO(OrderProductDAO orderProductDAO) {
		this.orderProductDAO = orderProductDAO;
	}

	public OrderShipDAO getOrderShipDAO() {
		return orderShipDAO;
	}

	public void setOrderShipDAO(OrderShipDAO orderShipDAO) {
		this.orderShipDAO = orderShipDAO;
	}

	public PaymentMethodDAO getPaymentMethodDAO() {
		return paymentMethodDAO;
	}

	public void setPaymentMethodDAO(PaymentMethodDAO paymentMethodDAO) {
		this.paymentMethodDAO = paymentMethodDAO;
	}

	public KabupatenDAO getKabupatenDAO() {
		return kabupatenDAO;
	}

	public void setKabupatenDAO(KabupatenDAO kabupatenDAO) {
		this.kabupatenDAO = kabupatenDAO;
	}

	public StockDAO getStockDAO() {
		return stockDAO;
	}

	public void setStockDAO(StockDAO stockDAO) {
		this.stockDAO = stockDAO;
	}

	public Integer getPaymentMethodId() {
		return paymentMethodId;
	}

	public void setPaymentMethodId(Integer paymentMethodId) {
		this.paymentMethodId = paymentMethodId;
	}

	public String getShipName() {
		return shipName;
	}

	public void setShipName(String shipName) {
		this.shipName = shipName;
	}

	public String getShipLast() {
		return shipLast;
	}

	public void setShipLast(String shipLast) {
		this.shipLast = shipLast;
	}

	public String getShipAddress() {
		return shipAddress;
	}

	public void setShipAddress(String shipAddress) {
		this.shipAddress = shipAddress;
	}

	public String getShipAddress2() {
		return shipAddress2;
	}

	public void setShipAddress2(String shipAddress2) {
		this.shipAddress2 = shipAddress2;
	}

	public Integer getShipPost() {
		return shipPost;
	}

	public void setShipPost(Integer shipPost) {
		this.shipPost = shipPost;
	}

	public Integer getShipKabupatenId() {
		return shipKabupatenId;
	}

	public void setShipKabupatenId(Integer shipKabupatenId) {
		this.shipKabupatenId = shipKabupatenId;
	}

	public String getShipPhone() {
		return shipPhone;
	}

	public void setShipPhone(String shipPhone) {
		this.shipPhone = shipPhone;
	}

	public Integer getIsSameAddr() {
		return isSameAddr;
	}

	public void setIsSameAddr(Integer isSameAddr) {
		this.isSameAddr = isSameAddr;
	}

	public static Logger getLog() {
		return log;
	}
	
}
