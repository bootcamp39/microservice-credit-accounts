package com.nttdata.microservice.bankcreditaccounts.controllers;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nttdata.microservice.bankcreditaccounts.collections.CreditMovementCollection;
import com.nttdata.microservice.bankcreditaccounts.enums.CreditTypeEnum;
import com.nttdata.microservice.bankcreditaccounts.services.ICreditMovementService;
import com.nttdata.microservice.bankcreditaccounts.services.ICreditService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping(value = "/creditMovements")
public class CreditMovementController {
	
	public static Logger log = Logger.getLogger(CreditMovementRestController.class);
	
	@Autowired
	private ICreditMovementService service;
	
	@PostMapping("/paymentCredit")
	public Mono<CreditMovementCollection> savePaymentCredit(@RequestBody CreditMovementCollection collection){
		log.info("EJECUTANDO ENDPOINT CreditMovementController.savePaymentCredit");
		return service.savePaymentCredit(collection);
	}
	
	@PostMapping("/paymentCreditCard")
	public Mono<CreditMovementCollection> savePaymentCreditCard(@RequestBody CreditMovementCollection collection){
		log.info("EJECUTANDO ENDPOINT CreditMovementController.savePaymentCreditCard");
		return service.savePaymentCreditCard(collection);
	}
	
	@PostMapping("/consumeCreditCard")
	public Mono<CreditMovementCollection> saveConsumeCreditCard(@RequestBody CreditMovementCollection collection){
		log.info("EJECUTANDO ENDPOINT CreditMovementController.saveConsumeCreditCard");
		return service.saveConsumeCreditCard(collection);
	}
	
	public Mono<CreditMovementCollection> savePaymentCreditThird(CreditMovementCollection collection){
		log.info("EJECUTANDO ENDPOINT CreditMovementController.savePaymentCreditThird");
		return service.savePaymentCredit(collection);
	}
	
	@GetMapping("/getAllCreditMovements/{personCode}")
	public Flux<CreditMovementCollection> listAllMovementsCreditByPersonCode(@PathVariable(value = "personCode") String personCode){
		log.info("EJECUTANDO ENDPOINT CreditMovementController.listAllMovementsCreditByPersonCode");
		return service.listAllMovementsCreditByPersonCode(personCode);
	}
	
	@GetMapping("/getAllCreditCardMovements/{personCode}")
	public Flux<CreditMovementCollection> listAllMovementsCreditCardByPersonCode(@PathVariable(value = "personCode") String personCode){
		log.info("EJECUTANDO ENDPOINT CreditMovementController.listAllMovementsCreditCardByPersonCode");
		return service.listAllMovementsCreditCardByPersonCode(personCode);
	}
	
}
