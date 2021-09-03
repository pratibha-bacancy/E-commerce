package com.bacancy.spboot.dto;

import java.time.LocalDate;

public class OrderDto {
	private Long id;
	private LocalDate dateCreated;
	private String status;
	private Long price;

	public OrderDto() {

	}

	public OrderDto(Long id, LocalDate dateCreated, String status, Long price) {
		this.id = id;
		this.dateCreated = dateCreated;
		this.status = status;
		this.price = price;
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

	public Long getPrice() {
		return price;
	}

	public void setPrice(Long price) {
		this.price = price;
	}

}
