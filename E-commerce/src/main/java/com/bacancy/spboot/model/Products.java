package com.bacancy.spboot.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;

@Entity
@Table(name = "products")
public class Products {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull
	@Column(name = "product_name")
	private String productName;

	@NotNull
	@Column(name = "product_pictureUrl")
	private String productPictureUrl;

	@NotNull
	@Column(name = "product_price")
	private Double productPrice;

	@ManyToOne(fetch = FetchType.LAZY)
	@JsonIgnore
	private User user;

	@ManyToOne(fetch = FetchType.LAZY)
	@JsonIgnore
	private Categories categories;

	public Products() {

	}

	public Products(Long id, String productName, String productPictureUrl, Double productPrice, User user,
			Categories categories) {
		this.id = id;
		this.productName = productName;
		this.productPictureUrl = productPictureUrl;
		this.productPrice = productPrice;
		this.user = user;
		this.categories = categories;
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

	public String getProductPictureUrl() {
		return productPictureUrl;
	}

	public void setProductPictureUrl(String productPictureUrl) {
		this.productPictureUrl = productPictureUrl;
	}

	public Double getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(Double productPrice) {
		this.productPrice = productPrice;
	}

	public User getUser() {
		return user;
	}

	public Categories getCategories() {
		return categories;
	}

}
