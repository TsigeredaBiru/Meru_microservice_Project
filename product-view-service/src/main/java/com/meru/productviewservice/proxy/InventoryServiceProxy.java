package com.meru.productviewservice.proxy;

import org.springframework.cloud.openfeign.FeignClient;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


import com.meru.productviewservice.bean.ProductView;

@FeignClient(name="Inventory-service")
public interface InventoryServiceProxy {
	
	@GetMapping("/inventory/{id}")
	public ProductView retrieveInventory(@PathVariable String id);
		

	@PostMapping("/inventory")
	public ProductView saveInventory(@RequestBody ProductView _inventory);

	
	
}
