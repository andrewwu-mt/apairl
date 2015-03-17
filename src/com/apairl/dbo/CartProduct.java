package com.apairl.dbo;

/**
 * Order entity. @author MyEclipse Persistence Tools
 */

public class CartProduct implements java.io.Serializable {

	// Fields

	private Integer cartProductId;
	private Cart cart;
	private Product product;
	private Integer qty;
	private Integer sum;
	private Size size;
	private Color color;

	// Constructors

	/** default constructor */
	public CartProduct() {
	}

	/** full constructor */
	public CartProduct(Cart cart, Product product, Integer qty, Integer sum, Size size, Color color) {
		this.cart = cart;
		this.product = product;
		this.qty = qty;
		this.sum = sum;
		this.size = size;
		this.color = color;
	}

	public Integer getCartProductId() {
		return cartProductId;
	}

	public void setCartProductId(Integer cartProductId) {
		this.cartProductId = cartProductId;
	}

	public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
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

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

}