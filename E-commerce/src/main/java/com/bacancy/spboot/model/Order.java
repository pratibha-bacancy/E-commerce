package com.bacancy.spboot.model;

import java.util.ArrayList;
import java.sql.Date;
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

@Entity
@Table(name = "orders")
public class Order {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "order_date")
	private Date orderDate;

	@Column(name = "product_quantity")
	private Integer productQuantity;

	@Column(name = "total_price")
	private Long totalPrice;

	@ManyToOne(fetch = FetchType.LAZY)
	@JsonIgnore
	private User user;

	@OneToMany(cascade = CascadeType.ALL)
	private List<OrderStatus> status = new ArrayList<>();

	@OneToMany(cascade = CascadeType.ALL)
	private List<Products> products = new ArrayList<>();

	public Order() {

	}

	public Order(Long id, Date orderDate, Integer productQuantity, Long totalPrice, User user, List<OrderStatus> status,
			List<Products> products) {
		this.id = id;
		this.orderDate = orderDate;
		this.productQuantity = productQuantity;
		this.totalPrice = totalPrice;
		this.user = user;
		this.status = status;
		this.products = products;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public Integer getProductQuantity() {
		return productQuantity;
	}

	public void setProductQuantity(Integer productQuantity) {
		this.productQuantity = productQuantity;
	}

	public Long getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(Long totalPrice) {
		this.totalPrice = totalPrice;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<OrderStatus> getStatus() {
		return status;
	}

	public List<Products> getProducts() {
		return products;
	}

}
