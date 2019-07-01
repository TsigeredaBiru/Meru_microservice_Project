package com.meru.productviewservice.proxy;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


import com.meru.productviewservice.bean.ProductView;

@FeignClient(name="price-service")
public interface PriceServiceProxy {
	
	@GetMapping("/price/{id}")
	public ProductView retrievePrice(@PathVariable String id);
	
	
	@PostMapping("/price")
	   public ProductView savePrice(@RequestBody ProductView price);


}
