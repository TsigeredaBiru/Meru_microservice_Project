package com.meru.promotionservice.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Promotion {
	
	@Id
	private Long id;
	@Column(name="p_code")
	private String productCode;
	private boolean promo;
	private int port;
	
	public Promotion() {}
	public Promotion(String code, boolean promo) {
		super();
		this.productCode = code;
		this.promo = promo;
	}
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
	public boolean isPromo() {
		return promo;
	}
	public void setPromo(boolean promo) {
		this.promo = promo;
	}

	public int getPort() {
		return port;
	}
	public void setPort(int port) {
		this.port = port;
	}




}
	
	