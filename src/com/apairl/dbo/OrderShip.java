package com.apairl.dbo;

import java.sql.Timestamp;

/**
 * Ship entity. @author MyEclipse Persistence Tools
 */

public class OrderShip implements java.io.Serializable {

	// Fields

	private Long orderShipId;
	private Order order;
	private ShipType shipType;
	private Short status;
	private String comment;
	private Timestamp insertDate;
	private Timestamp updateDate;
	
	private PaymentMethod paymentMethod;
	private String shipName;
	private String shipLast;
	private String shipAddress;
	private String shipAddress2;
	private Integer shipPost;
	private Kabupaten shipKabupaten;
	private String shipPhone;

	// Constructors

	/** default constructor */
	public OrderShip() {
	}

	/** full constructor */
	public OrderShip(Order order, Long orderShipId, ShipType shipType, Timestamp insertDate, Timestamp updateDate, 
			Short status, String comment, PaymentMethod paymentMethod,
			String shipName,
			String shipLast,
			String shipAddress,
			String shipAddress2,
			Integer shipPost,
			Kabupaten shipKabupaten,
			String shipPhone
			) {
		this.orderShipId = orderShipId;
		this.shipType = shipType;
		this.order = order;
		this.insertDate = insertDate;
		this.status = status;
		this.updateDate = updateDate;
		this.comment = comment;
		this.paymentMethod = paymentMethod;
		this.shipName = shipName;
		this.shipLast = shipLast;
		this.shipAddress = shipAddress;
		this.shipAddress2 = shipAddress2;
		this.shipPost = shipPost;
		this.shipKabupaten = shipKabupaten;
		this.shipPhone = shipPhone;
		
		
	}

	public Long getOrderShipId() {
		return orderShipId;
	}

	public void setOrderShipId(Long orderShipId) {
		this.orderShipId = orderShipId;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public ShipType getShipType() {
		return shipType;
	}

	public void setShipType(ShipType shipType) {
		this.shipType = shipType;
	}

	public Short getStatus() {
		return status;
	}

	public void setStatus(Short status) {
		this.status = status;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
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

	public PaymentMethod getPaymentMethod() {
		return paymentMethod;
	}

	public void setPaymentMethod(PaymentMethod paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

	public String getShipName() {
		return shipName;
	}

	public void setShipName(String shipName) {
		this.shipName = shipName;
	}

	public String getShipLast() {
		return shipLast;
	}

	public void setShipLast(String shipLast) {
		this.shipLast = shipLast;
	}

	public String getShipAddress() {
		return shipAddress;
	}

	public void setShipAddress(String shipAddress) {
		this.shipAddress = shipAddress;
	}

	public String getShipAddress2() {
		return shipAddress2;
	}

	public void setShipAddress2(String shipAddress2) {
		this.shipAddress2 = shipAddress2;
	}

	public Integer getShipPost() {
		return shipPost;
	}

	public void setShipPost(Integer shipPost) {
		this.shipPost = shipPost;
	}

	public Kabupaten getShipKabupaten() {
		return shipKabupaten;
	}

	public void setShipKabupaten(Kabupaten shipKabupaten) {
		this.shipKabupaten = shipKabupaten;
	}

	public String getShipPhone() {
		return shipPhone;
	}

	public void setShipPhone(String shipPhone) {
		this.shipPhone = shipPhone;
	}

}