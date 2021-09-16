package com.bacancy.spboot.dto;

import java.sql.Date;

public class OrderDto {
	private Long id;
	private Date orderDate;
	private Integer productQuantity;
	private Long totalPrice;

	public OrderDto() {

	}

	public OrderDto(Long id, Date orderDate, Integer productQuantity, Long totalPrice) {
		this.id = id;
		this.orderDate = orderDate;
		this.productQuantity = productQuantity;
		this.totalPrice = totalPrice;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public Integer getProductQuantity() {
		return productQuantity;
	}

	public void setProductQuantity(Integer productQuantity) {
		this.productQuantity = productQuantity;
	}

	public Long getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(Long totalPrice) {
		this.totalPrice = totalPrice;
	}

}
