package com.apairl.action;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;

import com.apairl.dao.AdminDAO;
import com.apairl.dao.CustomerDAO;
import com.apairl.dao.KabupatenDAO;
import com.apairl.dao.OrderDAO;
import com.apairl.dao.OrderShipDAO;
import com.apairl.dao.PaymentMethodDAO;
import com.apairl.dao.ProductDAO;
import com.apairl.dao.StockDAO;
import com.apairl.dbo.Admin;
import com.apairl.dbo.Customer;
import com.apairl.dbo.Kabupaten;
import com.apairl.dbo.Order;
import com.apairl.dbo.OrderProduct;
import com.apairl.dbo.OrderShip;
import com.apairl.dbo.PaymentMethod;
import com.apairl.dbo.Product;
import com.apairl.dbo.Stock;
import com.opensymphony.xwork2.ActionSupport;

public class AdminAction extends ActionSupport {
	private static final Logger log = Logger.getLogger(AdminAction.class);
	
	private String username;
	private String password;
	private AdminDAO adminDAO;
	private StockDAO stockDAO;
	private OrderShipDAO orderShipDAO;
	private OrderDAO orderDAO;
	private ProductDAO productDAO;
	private int id;
	private int productId;
	private Long orderShipId;
	private CustomerDAO customerDAO;
	private String path;
	
	private String name;
	private String description;
	private int priceBottle;
	private int priceBox;
	private int number;
	private short status;
	private Integer month;
	private Integer year;
	
	private List<Integer> productIds;
	private List<Integer> numbers;
	
	private List<Order> orderList;
	

	private KabupatenDAO kabupatenDAO;
	private PaymentMethodDAO paymentMethodDAO;
	
	private String last;
	private String email;
	
	private String address;
	private String address2;
	private String phone;
	private Integer post;
	
	private Integer kabupatenId;
	private Integer customerId;
	
	private String oldPwd;
	private String newPwd;
	
	private Integer paymentMethodId;
	private String shipAddress;
	private String shipAddress2;
	private String shipPhone;
	private Integer subtotal;
	private Integer fee;
	private Integer total;
	
	public String execute(){
		return SUCCESS;
	}

	//========================================================================
	
	//User Record
	public String allUserRecords(){
		HttpServletRequest request = ServletActionContext.getRequest();
		List customerList = customerDAO.findAll();
		request.setAttribute("customerList", customerList);
		
		return SUCCESS;
	}
	
	public String getUserRecord(){
		HttpServletRequest request = ServletActionContext.getRequest();
		Customer customer = customerDAO.findById(customerId);
		request.setAttribute("customer", customer);
		
		return SUCCESS;
	}
	
	public String saveUserRecord(){
		Customer customer = new Customer();
		customer.setName(name);
		customer.setEmail(email);
		customer.setPassword(password);
		customer.setInsertDate(new Timestamp(System.currentTimeMillis()));
		
		customerDAO.save(customer);
		
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		session.setAttribute("customer", customer);
		
		return "successsave";
	}

	public String updateUserRecord(){
		Kabupaten kab = kabupatenDAO.findById(kabupatenId);
		Customer cus = customerDAO.findById(customerId);
		cus.setName(name);
		cus.setLast(last);
		cus.setEmail(email);
		cus.setKabupaten(kab);
		cus.setPhone(phone);
		cus.setPassword(password);
		cus.setAddress(address);
		cus.setAddress2(address2);
		cus.setPost(post);
		
		customerDAO.update(cus);
		
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		session.removeAttribute("customer");
		session.setAttribute("customer", cus);
		
		return SUCCESS;
	}

	public String deleteUserRecord(){
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("path", path);
		try{
			Customer cus = customerDAO.findById(customerId);
			customerDAO.delete(cus);
			
			return "successdelete";
		} catch (Exception e){
			return "deleteusererror";
		}
	}
	
	
	//========================================================================
	
	
	//login
	public String login(){
		List<Admin> admin = adminDAO.findByUsername(username);
		if(admin.size() != 0){
			String pwd = admin.get(0).getPassword();
			if(password.equals(pwd)){
				HttpServletRequest request = ServletActionContext.getRequest();
				HttpSession session = request.getSession();
				session.setAttribute("admin", admin);				
				return "successlogin";
			} else {
				return "error";
			}
		} else {
			return "error";
		}
	}

	//========================================================================
	
	
	//Stock Records
	public String allStockRecords(){
		HttpServletRequest request = ServletActionContext.getRequest();
		List<Stock> stockList = stockDAO.findAll();
		request.setAttribute("stockList", stockList);
		
		return SUCCESS;
	}
	
	public String update(){
		try{
			List<Stock> list = stockDAO.findAll();
			for(int i=0 ; i<list.size() ; i++){
				if(numbers.get(i) != null){
					Stock stock = list.get(i);
					stock.setQty(numbers.get(i));
					stockDAO.update(stock);
				}
			}
		} catch (Exception e){
			e.printStackTrace();
		}
		return SUCCESS;
	}
	

	//========================================================================
	

	//Order Records
	public String getShipDetailRecord(){
		orderList = orderDAO.findByProperty("ship.orderShipId", orderShipId);
		return SUCCESS;
	}
	
	
	//========================================================================
	
	
	//Ship Records
	public String getShipRecord(){
		HttpServletRequest request = ServletActionContext.getRequest();
		OrderShip ship = orderShipDAO.findById(orderShipId);
		request.setAttribute("ship", ship);
		
		return SUCCESS;
	}
	
	public String updateShipRecord(){
		OrderShip ship = orderShipDAO.findById(orderShipId);
		Kabupaten shipKabupaten = kabupatenDAO.findById(kabupatenId);
		PaymentMethod paymentMethod = paymentMethodDAO.findById(paymentMethodId);
		
		ship.setShipAddress(shipAddress);
		ship.setShipAddress2(shipAddress2);
		ship.setShipKabupaten(shipKabupaten);
		ship.setShipPhone(shipPhone);
		ship.setStatus(status);
		ship.setPaymentMethod(paymentMethod);
		orderShipDAO.update(ship);
		
		return SUCCESS;
	}
	
	public String allShipRecords(){
		if(year == null) {
			Calendar cal = Calendar.getInstance();
			cal.setTime(new Date());
			year = cal.get(Calendar.YEAR);
		}
		HttpServletRequest request = ServletActionContext.getRequest();
		List<OrderShip> shipList = orderShipDAO.findByMonth(month, year);
		Long subtotal = orderShipDAO.findPrice(month, year, "subtotal");
		Long fee = orderShipDAO.findPrice(month, year, "fee");
		Long adminFee = orderShipDAO.findAdminFee(month, year);
		Long total = orderShipDAO.findPrice(month, year, "total");
		
		if(subtotal == null) subtotal = (long) 0;
		if(fee == null) fee = (long) 0;
		if(adminFee == null) adminFee = (long) 0;
		if(total == null) total = (long) 0;
		
		request.setAttribute("shipList", shipList);
		request.setAttribute("subtotal", subtotal);
		request.setAttribute("fee", fee+adminFee);
		request.setAttribute("total", total);
		request.setAttribute("month", month);
		request.setAttribute("year", year);
		
		return SUCCESS;
	}
	

	public String deleteShipRecord(){
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("path", path);
		
		OrderShip orderShip = orderShipDAO.findById(orderShipId);
		Order order = orderShip.getOrder();
		
		Set<OrderProduct> opList = order.getOrderProducts();
		for(OrderProduct op : opList){
			Product p = op.getProduct();
			Integer qty = op.getQty();
			List<Stock> stockList = stockDAO.findByProperty("product.productId", p.getProductId());
			if(stockList.size() != 0){
				Stock stock = stockList.get(0);
				stock.setQty(stock.getQty() + qty);
				stockDAO.update(stock);
			}
		}
		
		try{
			orderShipDAO.delete(orderShip);
		} catch(Exception e){
			log.error("Delete ship error", e);
			return "systemerror";
		}
		return "successdelete";
	}
	
	public String updateShipStatus(){
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("path", path);
		
		OrderShip ship = orderShipDAO.findByIdJoin(orderShipId);
		if(status == 0){
			ship.setStatus((short) 1);
		} else {
			ship.setStatus((short) 0);
		}
		
		orderShipDAO.update(ship);
		
		return SUCCESS;
		
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public AdminDAO getAdminDAO() {
		return adminDAO;
	}

	public void setAdminDAO(AdminDAO adminDAO) {
		this.adminDAO = adminDAO;
	}

	public StockDAO getStockDAO() {
		return stockDAO;
	}

	public void setStockDAO(StockDAO stockDAO) {
		this.stockDAO = stockDAO;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public OrderShipDAO getOrderShipDAO() {
		return orderShipDAO;
	}

	public void setOrderShipDAO(OrderShipDAO orderShipDAO) {
		this.orderShipDAO = orderShipDAO;
	}

	public OrderDAO getOrderDAO() {
		return orderDAO;
	}

	public void setOrderDAO(OrderDAO orderDAO) {
		this.orderDAO = orderDAO;
	}

	public List<Order> getOrderList() {
		return orderList;
	}

	public void setOrderList(List<Order> orderList) {
		this.orderList = orderList;
	}

	public Long getOrderShipId() {
		return orderShipId;
	}

	public void setOrderShipId(Long orderShipId) {
		this.orderShipId = orderShipId;
	}

	public ProductDAO getProductDAO() {
		return productDAO;
	}

	public void setProductDAO(ProductDAO productDAO) {
		this.productDAO = productDAO;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getPriceBottle() {
		return priceBottle;
	}

	public void setPriceBottle(int priceBottle) {
		this.priceBottle = priceBottle;
	}

	public int getPriceBox() {
		return priceBox;
	}

	public void setPriceBox(int priceBox) {
		this.priceBox = priceBox;
	}

	public List<Integer> getProductIds() {
		return productIds;
	}

	public void setProductIds(List<Integer> productIds) {
		this.productIds = productIds;
	}

	public List<Integer> getNumbers() {
		return numbers;
	}

	public void setNumbers(List<Integer> numbers) {
		this.numbers = numbers;
	}

	public short getStatus() {
		return status;
	}

	public void setStatus(short status) {
		this.status = status;
	}

	public Integer getMonth() {
		return month;
	}

	public void setMonth(Integer month) {
		this.month = month;
	}

	public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

	public CustomerDAO getCustomerDAO() {
		return customerDAO;
	}

	public void setCustomerDAO(CustomerDAO customerDAO) {
		this.customerDAO = customerDAO;
	}

	public KabupatenDAO getKabupatenDAO() {
		return kabupatenDAO;
	}

	public void setKabupatenDAO(KabupatenDAO kabupatenDAO) {
		this.kabupatenDAO = kabupatenDAO;
	}

	public String getLast() {
		return last;
	}

	public void setLast(String last) {
		this.last = last;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getAddress2() {
		return address2;
	}

	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Integer getPost() {
		return post;
	}

	public void setPost(Integer post) {
		this.post = post;
	}

	public Integer getKabupatenId() {
		return kabupatenId;
	}

	public void setKabupatenId(Integer kabupatenId) {
		this.kabupatenId = kabupatenId;
	}

	public Integer getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}

	public String getOldPwd() {
		return oldPwd;
	}

	public void setOldPwd(String oldPwd) {
		this.oldPwd = oldPwd;
	}

	public String getNewPwd() {
		return newPwd;
	}

	public void setNewPwd(String newPwd) {
		this.newPwd = newPwd;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public PaymentMethodDAO getPaymentMethodDAO() {
		return paymentMethodDAO;
	}

	public void setPaymentMethodDAO(PaymentMethodDAO paymentMethodDAO) {
		this.paymentMethodDAO = paymentMethodDAO;
	}

	public Integer getPaymentMethodId() {
		return paymentMethodId;
	}

	public void setPaymentMethodId(Integer paymentMethodId) {
		this.paymentMethodId = paymentMethodId;
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

	public String getShipPhone() {
		return shipPhone;
	}

	public void setShipPhone(String shipPhone) {
		this.shipPhone = shipPhone;
	}

	public Integer getSubtotal() {
		return subtotal;
	}

	public void setSubtotal(Integer subtotal) {
		this.subtotal = subtotal;
	}

	public Integer getFee() {
		return fee;
	}

	public void setFee(Integer fee) {
		this.fee = fee;
	}

	public Integer getTotal() {
		return total;
	}

	public void setTotal(Integer total) {
		this.total = total;
	}

	public static Logger getLog() {
		return log;
	}

}
