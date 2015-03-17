package com.apairl.dbo;

/**
 * Stock entity. @author MyEclipse Persistence Tools
 */

public class Stock implements java.io.Serializable {

	// Fields

	private Integer stockId;
	private Product product;
	private Size size;
	private Color color;
	private Integer qty;

	// Constructors

	/** default constructor */
	public Stock() {
	}

	/** full constructor */
	public Stock(Product product, Integer qty, Size size, Color color) {
		this.product = product;
		this.qty = qty;
		this.size = size;
		this.color = color;
	}

	// Property accessors

	public Integer getStockId() {
		return this.stockId;
	}

	public void setStockId(Integer stockId) {
		this.stockId = stockId;
	}

	public Product getProduct() {
		return this.product;
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

	public Size getSize() {
		return size;
	}

	public void setSize(Size size) {
		this.size = size;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

}