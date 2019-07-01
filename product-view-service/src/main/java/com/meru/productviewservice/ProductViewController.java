package com.meru.productviewservice;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;


import com.meru.productviewservice.bean.ProductView;
import com.meru.productviewservice.proxy.InventoryServiceProxy;
import com.meru.productviewservice.proxy.PriceServiceProxy;
import com.meru.productviewservice.proxy.ProductServiceProxy;
import com.meru.productviewservice.proxy.PromotionServiceProxy;

@RestController
public class ProductViewController {
	
	
	
	@Autowired
	private ProductServiceProxy product;
	@Autowired
	private PriceServiceProxy price;
	@Autowired
	private InventoryServiceProxy inventory;
	
	@Autowired
	private PromotionServiceProxy promotion;
	
	
	
	@GetMapping("/products/{id}")
	public ProductView searchProduct(@PathVariable String id) {
		
		
	ProductView productView = product.retrieveProduct(id);
	
	ProductView productView2 = price.retrievePrice(id);
	
	ProductView productView3 = inventory.retrieveInventory(id);
	
	ProductView productView4 = promotion.onPromotion(id);
	
	productView.setPrice(productView2.getPrice());
	productView.setPromo(productView4.isPromo());
	productView.setQuantity(productView3.getQuantity());
	
	return productView;
}

	@PostMapping("/products")
	public ResponseEntity<Void> saveProduct(@RequestBody ProductView _product) {
		
		ProductView  aProduct =  product.saveProduct(_product);
		ProductView aPrice = price.savePrice(_product);
		ProductView anInventory = inventory.saveInventory(_product);
		ProductView aPromotion = promotion.savePromotion(_product);
		
		
		
		return ResponseEntity.ok().build();}
	
	
	@GetMapping("/products")
	public List<ProductView> showProduct() {
		
		
		return product.allproducts();
				}
	
	@GetMapping("/price/{id}")
	public ProductView findPrice(@PathVariable String id) {
		
		return price.retrievePrice(id);
		
	}
	
	
	@GetMapping("/inventory/{id}")
	public ProductView retrieveInventory(@PathVariable String id) {
		return inventory.retrieveInventory(id);
		
		}

	@GetMapping("/promotion/{id}")
	public ProductView anyPromotion(@PathVariable String id) {
		
		return promotion.onPromotion(id);
		
		
		
	}
	
}
