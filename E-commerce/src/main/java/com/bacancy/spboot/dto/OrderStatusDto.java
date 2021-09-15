package com.bacancy.spboot.dto;

import java.util.Date;

public class OrderStatusDto {
	private Long id;
	private String Status;
	private Date OrderDate;

	public OrderStatusDto() {

	}

	public OrderStatusDto(Long id, String status, Date orderDate) {
		this.id = id;
		Status = status;
		OrderDate = orderDate;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getStatus() {
		return Status;
	}

	public void setStatus(String status) {
		Status = status;
	}

	public Date getOrderDate() {
		return OrderDate;
	}

	public void setOrderDate(Date orderDate) {
		OrderDate = orderDate;
	}

}
