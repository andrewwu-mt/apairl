package com.apairl.dbo;


/**
 * Type entity. @author MyEclipse Persistence Tools
 */

public class Color implements java.io.Serializable {

	// Fields

	private Integer colorId;
	private String value;

	// Constructors

	/** default constructor */
	public Color() {
	}

	/** full constructor */
	public Color(String value) {
		this.value = value;
	}

	public Integer getColorId() {
		return colorId;
	}

	public void setColorId(Integer colorId) {
		this.colorId = colorId;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	}