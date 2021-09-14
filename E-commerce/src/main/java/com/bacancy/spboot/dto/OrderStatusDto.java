package com.bacancy.spboot.dto;

public class OrderStatusDto {
	private Long id;
	private String Status;

	public OrderStatusDto() {

	}

	public OrderStatusDto(Long id, String status) {
		this.id = id;
		Status = status;
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
}
