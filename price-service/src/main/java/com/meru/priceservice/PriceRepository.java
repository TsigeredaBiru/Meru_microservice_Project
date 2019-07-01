package com.meru.priceservice;

import org.springframework.data.jpa.repository.JpaRepository;
import com.meru.priceservice.bean.IndividualPrice;


public interface PriceRepository extends JpaRepository<IndividualPrice,Long> {
	
	
	public IndividualPrice findByProductCode(String code);}
	
	
	


