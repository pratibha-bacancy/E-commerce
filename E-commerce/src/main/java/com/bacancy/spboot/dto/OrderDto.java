package com.bacancy.spboot.dto;

import java.time.LocalDate;
import java.util.Date;

public class OrderDto {
	private Long id;
	private Date dateCreated;
	private Integer productQuantity;
	private Long totalPrice;

	public OrderDto() {

	}

	public OrderDto(Long id, Date dateCreated, Integer productQuantity, Long totalPrice) {
		this.id = id;
		this.dateCreated = dateCreated;
		this.productQuantity = productQuantity;
		this.totalPrice = totalPrice;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
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
