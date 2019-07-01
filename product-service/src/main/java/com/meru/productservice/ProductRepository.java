package com.meru.productservice;

import org.springframework.data.jpa.repository.JpaRepository;

import com.meru.productservice.bean.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
	
	
	public Product findByProductCode(String code);

	


}
