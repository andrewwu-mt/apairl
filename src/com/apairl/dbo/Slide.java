package com.apairl.dbo;

/**
 * Admin entity. @author MyEclipse Persistence Tools
 */

public class Slide implements java.io.Serializable {

	// Fields

	private Integer slideId;
	private String src;

	// Constructors

	/** default constructor */
	public Slide() {
	}

	/** full constructor */
	public Slide(String src) {
		this.src = src;
	}

	public Integer getSlideId() {
		return slideId;
	}

	public void setSlideId(Integer slideId) {
		this.slideId = slideId;
	}

	public String getSrc() {
		return src;
	}

	public void setSrc(String src) {
		this.src = src;
	}

}