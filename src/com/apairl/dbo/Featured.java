package com.apairl.dbo;

/**
 * Admin entity. @author MyEclipse Persistence Tools
 */

public class Featured implements java.io.Serializable {

	// Fields

	private Integer featuredId;
	private Product product;

	// Constructors

	/** default constructor */
	public Featured() {
	}

	/** full constructor */
	public Featured(Product product) {
		this.product = product;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Integer getFeaturedId() {
		return featuredId;
	}

	public void setFeaturedId(Integer featuredId) {
		this.featuredId = featuredId;
	}

}