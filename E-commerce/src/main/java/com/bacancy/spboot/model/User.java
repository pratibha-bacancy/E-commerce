package com.bacancy.spboot.model;

import java.util.ArrayList;
import java.util.List;
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
@Table(name = "user")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull
	@Column(name = "user_name")
	private String userName;

	@NotNull
	@Column(name = "user_detail")
	private String userDetail;

	@NotNull
	@Column(name = "user_email")
	private String userEmail;

	@NotNull
	@Column(name = "user_contact")
	private String userContact;

	@OneToMany(cascade = CascadeType.ALL)
	private List<Products> products = new ArrayList<>();

	@OneToMany(cascade = CascadeType.ALL)
	private List<Categories> categories = new ArrayList<>();

	@OneToMany(cascade = CascadeType.ALL)
	private List<Order> order = new ArrayList<>();

	public User() {

	}

	public User(Long id, String userName, String userDetail, String userEmail, String userContact,
			List<Products> products, List<Categories> categories) {
		this.id = id;
		this.userName = userName;
		this.userDetail = userDetail;
		this.userEmail = userEmail;
		this.userContact = userContact;
		this.products = products;
		this.categories = categories;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserDetail() {
		return userDetail;
	}

	public void setUserDetail(String userDetail) {
		this.userDetail = userDetail;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getUserContact() {
		return userContact;
	}

	public void setUserContact(String userContact) {
		this.userContact = userContact;
	}

	public List<Products> getProducts() {
		return products;
	}

	public List<Categories> getCategories() {
		return categories;
	}

	public List<Order> getOrder() {
		return order;
	}

}
