package com.meru.Inventoryservice;

import org.springframework.data.jpa.repository.JpaRepository;

import com.meru.Inventoryservice.bean.Inventory;

public interface InventoryRepository extends JpaRepository<Inventory,Long>{
	
	public Inventory findByProductCode(String code);
	
	
	

}
