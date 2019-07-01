package com.meru.Inventoryservice.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Inventory {
	
	@Id
	Long id;
	@Column(name="p_code")
	String productCode;
	int quantity;
	int port;

	public int getPort() {
		return port;
	}


	public void setPort(int port) {
		this.port = port;
	}


	public Inventory(String code, int quantity) {
		super();
		
		this.productCode = code;
		this.quantity = quantity;
	}
	
	
	public Inventory() {}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getCode() {
		return productCode;
	}


	public void setCode(String code) {
		this.productCode = code;
	}


	public int getQuantity() {
		return quantity;
	}


	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	
	

}
