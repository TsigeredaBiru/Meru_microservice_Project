package com.meru.productservice;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.meru.productservice.bean.Product;


@RestController
public class ProductController {
	
	@Autowired
	Environment environment;
	
	@Autowired
	ProductRepository productRepository;
	
	
	@GetMapping("/product/{id}")
	public Product retrieveProduct(@PathVariable String id) {
		
		Product p = productRepository.findByProductCode(id);
		
		//setting up dynamic port in response
		p.setPort(Integer.parseInt(environment.getProperty("local.server.port")));
		
		return p;
		}

	@GetMapping("/products")
	public List<Product> allproducts(){
		
		return productRepository.findAll();
		
	}
	
	@PostMapping("/products")
	public ResponseEntity<Object> saveProduct(@RequestBody Product product) {
		
		Product p =  productRepository.save(product);
		
		URI location = ServletUriComponentsBuilder
				.fromCurrentRequest().path("/{id}")
				.buildAndExpand(p.getId()).toUri();
		
		return ResponseEntity.created(location).build();
		
	}

}
