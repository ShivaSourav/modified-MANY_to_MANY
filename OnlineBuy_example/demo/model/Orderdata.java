package com.OnlineBuy_example.demo.model;


import java.beans.Transient;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.AssociationOverride;
import javax.persistence.AssociationOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.OneToMany;

@Entity

public class Orderdata{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer orderId;
	private float totalPrice;
	private LocalDateTime orderedDate;
	
	@ManyToOne(optional = false)
	@JoinColumn(name = "customer_id")
	private CustomerData customer;
	
	@OneToMany(mappedBy = "primaryKey.orders")
	private Set<OrderItems> orderItems = new HashSet<>(); 
	
	public Set<OrderItems> getOrderItems() {
		return orderItems;
	}
	public void setOrderItems(Set<OrderItems> orderItems) {
		this.orderItems = orderItems;
	}

	public Integer getOrderId() {
		return orderId;
	}
	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	
	public CustomerData getCustomer() {
		return customer;
	}
	public void setCustomer(CustomerData customer) {
		this.customer = customer;
	}
	public float getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(float totalPrice) {
		this.totalPrice = totalPrice;
	}
	public LocalDateTime getOrderedDate() {
		return orderedDate;
	}
	public void setOrderedDate(LocalDateTime orderedDate) {
		this.orderedDate = orderedDate;
	}

}
