package com.OnlineBuy_example.demo.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

@Entity
public class ProductData {
	
	@Id
	@SequenceGenerator(name = "PROSEQID",initialValue = 1,allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "PROSEQID")
	private Integer product_Id;
	private String productName;
	private Integer productPrice;
	

	 @OneToMany(mappedBy = "primaryKey.products")
	    private Set<OrderItems> orderItems = new HashSet<>();


	public Integer getProduct_Id() {
		return product_Id;
	}


	public void setProduct_Id(Integer product_Id) {
		this.product_Id = product_Id;
	}


	public String getProductName() {
		return productName;
	}


	public void setProductName(String productName) {
		this.productName = productName;
	}


	public Integer getProductPrice() {
		return productPrice;
	}


	public void setProductPrice(Integer productPrice) {
		this.productPrice = productPrice;
	}


	public Set<OrderItems> getOrderItems() {
		return orderItems;
	}


	public void setOrderItems(Set<OrderItems> orderItems) {
		this.orderItems = orderItems;
	}
	 
	

	
	
	
	

}
