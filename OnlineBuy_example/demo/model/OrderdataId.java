package com.OnlineBuy_example.demo.model;


import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;

@Embeddable
public class OrderdataId implements Serializable{
	
	@ManyToOne(cascade = CascadeType.ALL)
	private ProductData products;
	
	@ManyToOne(cascade = CascadeType.ALL)
	private Orderdata orders;
	
	
	public ProductData getProducts() {
		return products;
	}

	public void setProducts(ProductData products) {
		this.products = products;
	}

	public Orderdata getOrders() {
		return orders;
	}

	public void setOrders(Orderdata orders) {
		this.orders = orders;
	}

	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		return super.equals(obj);
	}
	
	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return super.hashCode();
	}

	

	
}