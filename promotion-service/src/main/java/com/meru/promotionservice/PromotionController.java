package com.meru.promotionservice;

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


import com.meru.promotionservice.bean.Promotion;

@RestController
public class PromotionController {
	
	@Autowired
	PromotionRepository promotionRepository;
	
	@Autowired
	Environment environment;

	
	@GetMapping("/promotion/{id}")
	public Promotion onPromotion(@PathVariable String id) {
		
		Promotion p = promotionRepository.findByProductCode(id);
		
		p.setPort(Integer.parseInt(environment.getProperty("local.server.port")));
		return p;
		}


	@PostMapping("/promotion")
	public ResponseEntity<Object> savePromotion(@RequestBody Promotion _promotion) {
		
		Promotion promotion =  promotionRepository.save(_promotion);
		
		URI location = ServletUriComponentsBuilder
				.fromCurrentRequest().path("/{id}")
				.buildAndExpand(promotion.getId()).toUri();
		
		return ResponseEntity.created(location).build();
		
	}





}
