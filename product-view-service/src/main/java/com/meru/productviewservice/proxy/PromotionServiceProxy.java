package com.meru.productviewservice.proxy;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.meru.productviewservice.bean.ProductView;


@FeignClient("promotion-service")
public interface PromotionServiceProxy {
	
	
	@GetMapping("/promotion/{id}")
	public ProductView onPromotion(@PathVariable String id);
	
	@PostMapping("/promotion")
	public ProductView savePromotion(@RequestBody ProductView _promotion);

}
