package com.meru.priceservice;

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

import com.meru.priceservice.bean.IndividualPrice;



@RestController
public class PriceController {

	
	@Autowired
	Environment environment;
	
	@Autowired
	PriceRepository priceRepository;
	
	
	@GetMapping("/price/{id}")
	public IndividualPrice retrievePrice(@PathVariable String id) {
		
		IndividualPrice p = priceRepository.findByProductCode(id);
		
		//setting up dynamic port in response
		p.setPort(Integer.parseInt(environment.getProperty("local.server.port")));
		
		return p;
		}


	@PostMapping("/price")
	public ResponseEntity<Object> savePrice(@RequestBody IndividualPrice price) {
		
		IndividualPrice p =  priceRepository.save(price);
		
		URI location = ServletUriComponentsBuilder
				.fromCurrentRequest().path("/{id}")
				.buildAndExpand(p.getId()).toUri();
		
		return ResponseEntity.created(location).build();
		
	}



}
