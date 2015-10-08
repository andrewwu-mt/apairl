package com.apairl.dbo;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

/**
 * Product entity. @author MyEclipse Persistence Tools
 */

public class Product implements java.io.Serializable {

	// Fields

	private Integer productId;
	private String name;
	private String description;
	private Integer price;
	private Integer priceCompare;
	private Timestamp insertDate;
	private Timestamp updateDate;
	private Integer active;
	private String urlPath;
	private Short isSeparate;
	private Set productUrls = new HashSet(0);

	// Constructors

	/** default constructor */
	public Product() {
	}

	/** full constructor */
	public Product(String name, String description,
			Integer price, Integer priceCompare, Timestamp insertDate,
			Timestamp updateDate, Integer active, String urlPath, Short isSeparate, Set productUrls) {
		this.name = name;
		this.description = description;
		this.price = price;
		this.priceCompare = priceCompare;
		this.insertDate = insertDate;
		this.updateDate = updateDate;
		this.active = active;
		this.urlPath = urlPath;
		this.isSeparate = isSeparate;
		this.productUrls = productUrls;
	}

	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
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

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public Timestamp getInsertDate() {
		return insertDate;
	}

	public void setInsertDate(Timestamp insertDate) {
		this.insertDate = insertDate;
	}

	public Timestamp getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Timestamp updateDate) {
		this.updateDate = updateDate;
	}

	public Integer getActive() {
		return active;
	}

	public void setActive(Integer active) {
		this.active = active;
	}

	public String getUrlPath() {
		return urlPath;
	}

	public void setUrlPath(String urlPath) {
		this.urlPath = urlPath;
	}

	public Set getProductUrls() {
		return productUrls;
	}

	public void setProductUrls(Set productUrls) {
		this.productUrls = productUrls;
	}

	public Integer getPriceCompare() {
		return priceCompare;
	}

	public void setPriceCompare(Integer priceCompare) {
		this.priceCompare = priceCompare;
	}

	public Short getIsSeparate() {
		return isSeparate;
	}

	public void setIsSeparate(Short isSeparate) {
		this.isSeparate = isSeparate;
	}

}