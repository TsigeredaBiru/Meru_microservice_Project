package com.meru.productviewservice.bean;



public class ProductView {

	
	private Long id;
	
	private String productCode;
	private String description;
	private String name;
	private double price;
	private int quantity;
	private boolean promo;
	private int port;
	
	
	public ProductView() {}
	
	public ProductView(String productCode, String description, String name, double price, int quantity, boolean promo,
			int port) {
		super();
		this.productCode = productCode;
		this.description = description;
		this.name = name;
		this.price = price;
		this.quantity = quantity;
		this.promo = promo;
		this.port = port;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getProductCode() {
		return productCode;
	}
	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}
	public boolean isPromo() {
		return promo;
	}
	public void setPromo(boolean promo) {
		this.promo = promo;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public int getPort() {
		return port;
	}
	public void setPort(int port) {
		this.port = port;
	}
	


}
