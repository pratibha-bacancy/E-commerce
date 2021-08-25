package com.bacancy.spboot.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.sun.istack.NotNull;

@Entity
@Table(name = "categories")
public class Categories {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long cid;

	@NotNull
	@Basic(optional = false)
	@Column(name = "category_name")
	private String categoryName;

	@NotNull
	@Column(name = "category_pictureUrl")
	private String categoryPictureUrl;
	
	@OneToMany(cascade = CascadeType.ALL)
	private List<Products> products=new ArrayList<>();

	public Categories() {

	}

	public Categories(Long cid, String categoryName, String categoryPictureUrl) {
		this.cid = cid;
		this.categoryName = categoryName;
		this.categoryPictureUrl = categoryPictureUrl;
	}

	public Long getCid() {
		return cid;
	}

	public void setCid(Long cid) {
		this.cid = cid;
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

}
