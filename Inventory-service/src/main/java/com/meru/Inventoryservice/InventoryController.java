package com.meru.Inventoryservice;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.meru.Inventoryservice.bean.Inventory;




@RestController
public class InventoryController {

@Autowired	
Environment environment;

@Autowired
InventoryRepository inventoryRepository;
	
	
	@GetMapping("/inventory/{id}")
	public Inventory retrieveInventory(@PathVariable String id) {
		Inventory inventory = inventoryRepository.findByProductCode(id);
		inventory.setPort(Integer.parseInt(environment.getProperty("local.server.port")));
		
		return inventory;
		}

	
	@PostMapping("/inventory")
	public ResponseEntity<Object> saveInventory(@RequestBody Inventory _inventory) {
		
		Inventory inventory =  inventoryRepository.save(_inventory);
		
		URI location = ServletUriComponentsBuilder
				.fromCurrentRequest().path("/{id}")
				.buildAndExpand(inventory.getId()).toUri();
		
		return ResponseEntity.created(location).build();
		
	}

	
	
	
}
