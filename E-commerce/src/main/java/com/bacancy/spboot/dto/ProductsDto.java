package com.bacancy.spboot.dto;

public class ProductsDto {
	private Long id;
	private String productName;
	private Double productPrice;
	private String productPictureUrl;

	public ProductsDto() {

	}

	public ProductsDto(Long id, String productName, Double productPrice, String productPictureUrl) {
		this.id = id;
		this.productName = productName;
		this.productPrice = productPrice;
		this.productPictureUrl = productPictureUrl;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public Double getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(Double productPrice) {
		this.productPrice = productPrice;
	}

	public String getProductPictureUrl() {
		return productPictureUrl;
	}

	public void setProductPictureUrl(String productPictureUrl) {
		this.productPictureUrl = productPictureUrl;
	}

}
