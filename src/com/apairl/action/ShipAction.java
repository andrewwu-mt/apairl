package com.apairl.action;

import java.text.DecimalFormat;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.apairl.bean.AES;
import com.apairl.bean.MailUtil;
import com.apairl.dao.ExchangeDAO;
import com.apairl.dao.OrderDAO;
import com.apairl.dao.OrderShipDAO;
import com.apairl.dao.StockDAO;
import com.apairl.dbo.Exchange;
import com.apairl.dbo.Order;
import com.apairl.dbo.Product;
import com.apairl.dbo.OrderShip;
import com.apairl.dbo.Stock;
import com.opensymphony.xwork2.ActionSupport;

public class ShipAction extends ActionSupport{

	private OrderShipDAO orderShipDAO;
	private ExchangeDAO exchangeDAO;
	private OrderDAO orderDAO;
	private StockDAO stockDAO;
	
	private Long shipId;
	private String email;
	
	private OrderShip threadShip;
	private String threadHost;
	
	//Paypal callback variables
	private String payment_status;
	private String txn_id;
	private String item_name;
	
	private String cert;
	
	public String getRecord(){
		HttpServletRequest request = ServletActionContext.getRequest();
		OrderShip ship = orderShipDAO.findById(shipId);
		request.setAttribute("ship", ship);
		
		return SUCCESS;
	}
	
	public String cancel(){
		OrderShip ship = orderShipDAO.findById(shipId);
		List<Order> orderList = orderDAO.findByProperty("ship.shipId", shipId);
		for(int i=0 ; i<orderList.size() ; i++){
			Order order = orderList.get(i);
			Product product = order.getProduct();
			String mult = product.getDescription().split("x")[0];
			int restock = 0;
			if(order.getType() == 1){
				restock = order.getAmount();
			} else {
				restock = order.getAmount() * Integer.valueOf(mult);
			}
			Stock stock = (Stock) stockDAO.findByProperty("product", product).get(0);
			stock.setNumber(stock.getNumber() + restock);
			stockDAO.update(stock);
			orderDAO.delete(order);
		}
		
		orderShipDAO.delete(ship);
		
		return SUCCESS;
	}
	
	public String success(){
		HttpServletRequest request = ServletActionContext.getRequest();
		String host = request.getScheme() + "://" + request.getHeader("host") + request.getContextPath();
		String item = item_name.split("#")[1];
		Long itemId = Long.valueOf(item);
		
		AES aes = new AES();
		Long id = Long.valueOf(aes.decrypt(cert));
		
		if(id.longValue() == itemId.longValue()){
			OrderShip ship = orderShipDAO.findById(id);
			if(payment_status != null){
				if(payment_status.equals("Completed")){
					if(ship.getStatus() != 1){
						ship.setStatus((short) 1);
						ship.setPaymentStatus(payment_status);
						ship.setTxnId(txn_id);
						orderShipDAO.update(ship);
						
						request.setAttribute("shipId", shipId);
						
						threadShip = ship;
						threadHost = host;
						
						Thread t = new Thread(new Runnable(){
							@Override
							public void run() {
								// TODO Auto-generated method stub
								sendMail(threadShip, threadHost);
							}
						});
						t.start();
					}
				} else {
					ship.setPaymentStatus(payment_status);
					orderShipDAO.update(ship);
				}
			}
		}
		return SUCCESS;
	}
	
	public void sendMail(OrderShip ship, String host){
		DecimalFormat df = new DecimalFormat("#,###");
		Exchange exc = exchangeDAO.findById(1);
		
		String rate = df.format(exc.getValue());
		String totalPrice = df.format(ship.getSubtotal());
		String totalFee = df.format(ship.getFee());
		String totalAll = df.format(ship.getTotal());
		String paypalTotal = df.format(((ship.getTotal()/exc.getValue())*1.04)+0.3);
		
		String website = "http://apairlstore.com/";
		String link = "<a href="+host+"/order-received?id="+ship.getShipId()+">Lihat detail pemesanan anda</a>"; 
		String title = "Konfirmasi pemesanan apairl";
		
		String content = ship.getCustomer().getName() + ", pembayaran anda telah kami terima. \n" +
				"ID pemesanan anda di apairlstore adalah "+ship.getShipId()+" dengan total harga :\n\n" +
				"IDR "+totalPrice+" \n" +
				"IDR "+totalFee+" (Shipping) \n" +
				"--------------------------------- + \n" +
				"IDR "+totalAll+ "\n\n"+

				"Anda melakukan pembayaran dengan Credit Card melalui Paypal. \n" +
				"Paypal Transaction #"+ship.getTxnId()+" \n" +
				"Kurs jual USD : IDR "+rate+" \n" +
				"Paypal Fee : 3.9% + $0.30 USD per transaction \n" +
				"Total : $"+paypalTotal+" USD \n\n" +
				
				"Klik link berikut ini untuk melihat detail pemesanan anda : \n" +
				link+" \n\n" +
				"Pesanan anda akan segera kami proses.\n" +
				"Terima kasih. \n\n" +
				"*NB. Untuk info lebih lanjut, silahkan hubungi kami melalui nomor HP. 081216438899 atau email apairlstore@gmail.com.";
		
		MailUtil.sendEmail(ship.getCustomer().getEmail(), ship.getCustomer().getName(), website, title, content, link, ship.getShipId(), totalPrice);
	}

	public OrderShipDAO getOrderShipDAO() {
		return orderShipDAO;
	}

	public void setOrderShipDAO(OrderShipDAO orderShipDAO) {
		this.orderShipDAO = orderShipDAO;
	}

	public Long getShipId() {
		return shipId;
	}

	public void setShipId(Long shipId) {
		this.shipId = shipId;
	}

	public String getEmai() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public ExchangeDAO getExchangeDAO() {
		return exchangeDAO;
	}

	public void setExchangeDAO(ExchangeDAO exchangeDAO) {
		this.exchangeDAO = exchangeDAO;
	}

	public OrderShip getThreadShip() {
		return threadShip;
	}

	public void setThreadShip(OrderShip threadShip) {
		this.threadShip = threadShip;
	}

	public String getEmail() {
		return email;
	}

	public OrderDAO getOrderDAO() {
		return orderDAO;
	}

	public void setOrderDAO(OrderDAO orderDAO) {
		this.orderDAO = orderDAO;
	}

	public StockDAO getStockDAO() {
		return stockDAO;
	}

	public void setStockDAO(StockDAO stockDAO) {
		this.stockDAO = stockDAO;
	}

	public String getThreadHost() {
		return threadHost;
	}

	public void setThreadHost(String threadHost) {
		this.threadHost = threadHost;
	}

	public String getPayment_status() {
		return payment_status;
	}

	public void setPayment_status(String payment_status) {
		this.payment_status = payment_status;
	}

	public String getTxn_id() {
		return txn_id;
	}

	public void setTxn_id(String txn_id) {
		this.txn_id = txn_id;
	}

	public String getCert() {
		return cert;
	}

	public void setCert(String cert) {
		this.cert = cert;
	}

	public String getItem_name() {
		return item_name;
	}

	public void setItem_name(String item_name) {
		this.item_name = item_name;
	}

}
