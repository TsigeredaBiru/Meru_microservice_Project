package com.meru.priceservice.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class IndividualPrice {

	@Id
	private Long id;
	@Column(name="p_code")
	private String productCode;
	
	private double price;
	private int port;
	
	

	public IndividualPrice(String id, double price) {
		super();
		this.productCode = id;
		this.price = price;
	}


	public IndividualPrice() {}
	
	
	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getProductCode() {
		return productCode;
	}



	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}



	public double getPrice() {
		return price;
	}



	public void setPrice(double price) {
		this.price = price;
	}
	
	public int getPort() {
		return port;
	}



	public void setPort(int port) {
		this.port = port;
	}

}
