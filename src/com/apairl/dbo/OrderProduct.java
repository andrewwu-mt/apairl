package com.apairl.dbo;

/**
 * Order entity. @author MyEclipse Persistence Tools
 */

public class OrderProduct implements java.io.Serializable {

	// Fields

	private Integer orderProductId;
	private Order order;
	private Product product;
	private Integer qty;
	private Integer sum;
	private Size size;

	// Constructors

	/** default constructor */
	public OrderProduct() {
	}

	/** full constructor */
	public OrderProduct(Order order, Product product, Integer qty, Integer sum, Size size) {
		this.order = order;
		this.product = product;
		this.qty = qty;
		this.sum = sum;
		this.size = size;
	}

	public Integer getOrderProductId() {
		return orderProductId;
	}

	public void setOrderProductId(Integer orderProductId) {
		this.orderProductId = orderProductId;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Integer getQty() {
		return qty;
	}

	public void setQty(Integer qty) {
		this.qty = qty;
	}

	public Integer getSum() {
		return sum;
	}

	public void setSum(Integer sum) {
		this.sum = sum;
	}

	public Size getSize() {
		return size;
	}

	public void setSize(Size size) {
		this.size = size;
	}

}