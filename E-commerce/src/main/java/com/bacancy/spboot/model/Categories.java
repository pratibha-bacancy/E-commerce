package com.bacancy.spboot.model;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;

@Entity
@Table(name = "categories")
public class Categories {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull
	@Column(name = "category_name")
	private String categoryName;

	@NotNull
	@Column(name = "category_pictureUrl")
	private String categoryPictureUrl;

	@OneToMany(cascade = CascadeType.ALL)
	private List<Products> products = new ArrayList<>();

	@ManyToOne(fetch = FetchType.LAZY)
	@JsonIgnore
	private User user;

	public Categories() {

	}

	public Categories(Long id, String categoryName, String categoryPictureUrl, List<Products> products, User user) {
		this.id = id;
		this.categoryName = categoryName;
		this.categoryPictureUrl = categoryPictureUrl;
		this.products = products;
		this.user = user;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public String getCategoryPictureUrl() {
		return categoryPictureUrl;
	}

	public void setCategoryPictureUrl(String categoryPictureUrl) {
		this.categoryPictureUrl = categoryPictureUrl;
	}

	public List<Products> getProducts() {
		return products;
	}

	public void setProducts(List<Products> products) {
		this.products = products;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public User getUser() {
		return user;
	}

}
