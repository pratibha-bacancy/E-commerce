package com.bacancy.spboot.dto;

import java.time.LocalDate;

public class OrderDto {
	private Long id;
	private LocalDate dateCreated;
	private String status;

	public OrderDto() {

	}

	public OrderDto(Long id, LocalDate dateCreated, String status) {
		this.id = id;
		this.dateCreated = dateCreated;
		this.status = status;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDate getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(LocalDate dateCreated) {
		this.dateCreated = dateCreated;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
