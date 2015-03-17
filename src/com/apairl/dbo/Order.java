package com.apairl.dbo;

import java.util.HashSet;
import java.util.Set;

/**
 * Order entity. @author MyEclipse Persistence Tools
 */

public class Order implements java.io.Serializable {

	// Fields

	private Integer orderId;
	private Customer customer;
	private Set orderProducts = new HashSet(0);

	// Constructors

	/** default constructor */
	public Order() {
	}

	/** full constructor */
	public Order(Customer customer, Set orderProducts) {
		this.customer = customer;
		this.orderProducts = orderProducts;
	}

	// Property accessors

	public Integer getOrderId() {
		return this.orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	public Customer getCustomer() {
		return this.customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Set getOrderProducts() {
		return orderProducts;
	}

	public void setOrderProducts(Set orderProducts) {
		this.orderProducts = orderProducts;
	}

}