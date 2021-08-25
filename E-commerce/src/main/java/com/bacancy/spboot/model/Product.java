package com.bacancy.spboot.model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import com.sun.istack.NotNull;

@Entity
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long pid;

	@NotNull
	@Basic(optional = false)
	@Column(name = "product_name")
	private String productName;

	@NotNull
	@Column(name = "product_pictureUrl")
	private String productPictureUrl;

	@NotNull
	@Column(name = "product_price")
	private Double productPrice;

	public Product() {

	}

	public Product(Long pid, String productName, String productPictureUrl, Double productPrice) {
		this.pid = pid;
		this.productName = productName;
		this.productPictureUrl = productPictureUrl;
		this.productPrice = productPrice;
	}

	public Long getPid() {
		return pid;
	}

	public void setPid(Long pid) {
		this.pid = pid;
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
