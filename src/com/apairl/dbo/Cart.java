package com.apairl.dbo;

import java.util.HashSet;
import java.util.Set;

/**
 * Order entity. @author MyEclipse Persistence Tools
 */

public class Cart implements java.io.Serializable {

	// Fields

	private Integer cartId;
	private Customer customer;
	private Set cartProducts = new HashSet(0);

	// Constructors

	/** default constructor */
	public Cart() {
	}

	/** full constructor */
	public Cart(Customer customer, Set cartProducts) {
		this.customer = customer;
		this.cartProducts = cartProducts;
	}

	// Property accessors

	public Integer getOrderId() {
		return this.cartId;
	}

	public void setCartId(Integer cartId) {
		this.cartId = cartId;
	}

	public Customer getCustomer() {
		return this.customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Set getCartProducts() {
		return cartProducts;
	}

	public void setCartProducts(Set cartProducts) {
		this.cartProducts = cartProducts;
	}

	public Integer getCartId() {
		return cartId;
	}

}