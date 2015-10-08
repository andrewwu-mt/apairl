package com.apairl.action;

import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;

import com.apairl.dao.CartDAO;
import com.apairl.dao.CartProductDAO;
import com.apairl.dao.ExchangeDAO;
import com.apairl.dao.ProductDAO;
import com.apairl.dao.SizeDAO;
import com.apairl.dao.StockDAO;
import com.apairl.dbo.Cart;
import com.apairl.dbo.CartProduct;
import com.apairl.dbo.Customer;
import com.apairl.dbo.Product;
import com.apairl.dbo.Size;
import com.opensymphony.xwork2.ActionSupport;

public class CartAction extends ActionSupport{
	private static final Logger log = Logger.getLogger(CartAction.class);
	
	private int id;
	private int amount;
	private int type;
	private int productId;
	private ProductDAO productDAO;
	private StockDAO stockDAO;
	private ExchangeDAO exchangeDAO;
	private CartDAO cartDAO;
	private CartProductDAO cartProductDAO;
	private SizeDAO sizeDAO;
	
	private Integer qty;
	private Integer sizeId;
	private Integer cartId;
	private Integer cartProductId;
	private int total;
	private String productName;
	private String name;
	private String address;
	private String phone;
	private String email;
	private int provinsiId;
	private int shipTypeId;
	private String host;
	
	
	public String allRecords(){
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		
		Customer customer = (Customer) session.getAttribute("customer");
		List<Cart> cartList = cartDAO.findByProperty("customer.customerId", customer.getCustomerId());
		if(cartList.size() != 0){
			Cart cart = cartList.get(0);
			Set cartProductList = cart.getCartProducts();
			request.setAttribute("cartProductList", cartProductList);
		}
		
		return SUCCESS;
	}

	public String saveRecord(){
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		host = request.getScheme() + "://" + request.getHeader("host") + request.getContextPath();
		
		Customer customer = (Customer) session.getAttribute("customer");
		List<Cart> cartList = cartDAO.findByProperty("customer.customerId", customer.getCustomerId());
		Cart cart = new Cart();
		if(cartList.size() != 0){
			cart = cartList.get(0);
		} else {
			cart.setCustomer(customer);
			cartDAO.save(cart);
		}
		Product p = productDAO.findById(productId);
		CartProduct cp = new CartProduct();
		cp.setCart(cart);
		cp.setProduct(p);
		
		Size size = sizeDAO.findById(sizeId);
		cp.setSize(size);
		
		cp.setQty(qty);
		cp.setSum(p.getPrice() * qty);
		
		try{
			cartProductDAO.save(cp);
		} catch(Exception e){
			log.error("Add to cart error", e);
		}
			
		return "successsave";
		
	}
	
	public Integer calculateTotal(Map<Integer, List<Object>> cartList){
		int totalBottle = 0;
		
		for(int key : cartList.keySet()){
			Product product = productDAO.findById(key);
			
			int amount = (Integer) cartList.get(key).get(1);
			int type = (Integer) cartList.get(key).get(2);
			
			if(type == 2){
				String m = product.getDescription().split("x")[0];
				int mult = Integer.valueOf(m);
				amount = amount*mult;
			}
			
			totalBottle += amount;
			String desc = product.getDescription();
			String multiplier = desc.split("x")[0];
			if(type == 2){
				amount = (amount * Integer.valueOf(multiplier));
			}
			
		}
		
		return totalBottle;
	}

	public String updateRecord(){
		List<CartProduct> cpList = cartProductDAO.findByProperty("product.productId", productId);
		for(CartProduct cp : cpList){
			try{
				cp.setQty(qty);
				cartProductDAO.attachDirty(cp);
			} catch(Exception e){
				log.error("Remove from cart error", e);
				return "systemerror";
			}
		}
		
		return "successdelete";
	}
	
	public String deleteRecord(){
		List<CartProduct> cpList = cartProductDAO.findByProperty("product.productId", productId);
		for(CartProduct cp : cpList){
			try{
				cartProductDAO.delete(cp);
			} catch(Exception e){
				log.error("Remove from cart error", e);
				return "systemerror";
			}
		}
		
		return "successdelete";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public ProductDAO getProductDAO() {
		return productDAO;
	}

	public void setProductDAO(ProductDAO productDAO) {
		this.productDAO = productDAO;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getShipTypeId() {
		return shipTypeId;
	}

	public void setShipTypeId(int shipTypeId) {
		this.shipTypeId = shipTypeId;
	}

	public int getProvinsiId() {
		return provinsiId;
	}

	public void setProvinsiId(int provinsiId) {
		this.provinsiId = provinsiId;
	}

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public StockDAO getStockDAO() {
		return stockDAO;
	}

	public void setStockDAO(StockDAO stockDAO) {
		this.stockDAO = stockDAO;
	}

	public ExchangeDAO getExchangeDAO() {
		return exchangeDAO;
	}

	public void setExchangeDAO(ExchangeDAO exchangeDAO) {
		this.exchangeDAO = exchangeDAO;
	}

	public CartDAO getCartDAO() {
		return cartDAO;
	}

	public void setCartDAO(CartDAO cartDAO) {
		this.cartDAO = cartDAO;
	}

	public CartProductDAO getCartProductDAO() {
		return cartProductDAO;
	}

	public void setCartProductDAO(CartProductDAO cartProductDAO) {
		this.cartProductDAO = cartProductDAO;
	}

	public SizeDAO getSizeDAO() {
		return sizeDAO;
	}

	public void setSizeDAO(SizeDAO sizeDAO) {
		this.sizeDAO = sizeDAO;
	}

	public Integer getQty() {
		return qty;
	}

	public void setQty(Integer qty) {
		this.qty = qty;
	}

	public Integer getSizeId() {
		return sizeId;
	}

	public void setSizeId(Integer sizeId) {
		this.sizeId = sizeId;
	}

	public Integer getCartId() {
		return cartId;
	}

	public void setCartId(Integer cartId) {
		this.cartId = cartId;
	}

	public Integer getCartProductId() {
		return cartProductId;
	}

	public void setCartProductId(Integer cartProductId) {
		this.cartProductId = cartProductId;
	}

	public static Logger getLog() {
		return log;
	}
	
}
