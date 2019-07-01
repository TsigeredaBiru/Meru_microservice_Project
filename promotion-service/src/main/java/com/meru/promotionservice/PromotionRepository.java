package com.meru.promotionservice;

import org.springframework.data.jpa.repository.JpaRepository;

import com.meru.promotionservice.bean.Promotion;



public interface PromotionRepository extends JpaRepository<Promotion, Long> {
	
	public Promotion findByProductCode(String code);

}
