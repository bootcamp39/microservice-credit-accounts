package com.nttdata.microservice.bankcreditaccounts.controllers;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nttdata.microservice.bankcreditaccounts.collections.CreditMovementCollection;
import com.nttdata.microservice.bankcreditaccounts.services.ICreditMovementService;

import reactor.core.publisher.Mono;

@RestController
@RequestMapping(value = "/creditMovements")
public class CreditMovementController {
	
	public static Logger log = Logger.getLogger(CreditMovementRestController.class);
	
	@Autowired
	private ICreditMovementService service;
	
	public Mono<CreditMovementCollection> savePaymentCredit(CreditMovementCollection collection){
		return service.savePaymentCredit(collection);
	}
	
	public Mono<CreditMovementCollection> savePaymentCreditCard(CreditMovementCollection collection){
		return service.savePaymentCredit(collection);
	}
	
	public Mono<CreditMovementCollection> saveConsumeCreditCard(CreditMovementCollection collection){
		return service.savePaymentCredit(collection);
	}
	
	public Mono<CreditMovementCollection> savePaymentCreditThird(CreditMovementCollection collection){
		return service.savePaymentCredit(collection);
	}
	
}
