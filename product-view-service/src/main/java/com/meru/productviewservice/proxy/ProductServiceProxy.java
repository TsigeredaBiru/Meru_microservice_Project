package com.meru.productviewservice.proxy;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import com.meru.productviewservice.bean.ProductView;

@FeignClient(name="product-service")
public interface ProductServiceProxy {
	
	@GetMapping("/product/{id}")
	public ProductView retrieveProduct(@PathVariable String id);

	
	@GetMapping("/products")
	public List<ProductView> allproducts();

	
	@PostMapping("/products")
	public ProductView saveProduct(@RequestBody ProductView product);}


	
	
	
