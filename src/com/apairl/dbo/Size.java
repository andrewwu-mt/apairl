package com.apairl.dbo;


/**
 * Type entity. @author MyEclipse Persistence Tools
 */

public class Size implements java.io.Serializable {

	// Fields

	private Integer sizeId;
	private String value;

	// Constructors

	/** default constructor */
	public Size() {
	}

	/** full constructor */
	public Size(String value) {
		this.value = value;
	}

	public Integer getSizeId() {
		return sizeId;
	}

	public void setSizeId(Integer sizeId) {
		this.sizeId = sizeId;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	}