package com.nttdata.microservice.bankcreditaccounts.controllers;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nttdata.microservice.bankcreditaccounts.collections.CreditMovementCollection;
import com.nttdata.microservice.bankcreditaccounts.services.ICreditMovementService;

import reactor.core.publisher.Flux;

@RestController
@RequestMapping(value = "/credit-movements")
public class CreditMovementRestController {
	
	public static Logger log = Logger.getLogger(CreditMovementRestController.class);
	
	@Autowired
	private ICreditMovementService creditMovementService;
	
	@GetMapping(value = "/list-all")
	public Flux<CreditMovementCollection> getAllCreditMovements() throws Exception{
		log.info("EJECUTANDO ENDPOINT CreditMovementRestController.getAllCreditMovements");
		return creditMovementService.getAll();
	}
	
	@GetMapping(value = "/find/{personCode}")
	public Flux<CreditMovementCollection> getCreditMovementsByPersonCode(@PathVariable("personCode") String personCode) throws Exception{
		log.info("EJECUTANDO ENDPOINT CreditMovementRestController.getCreditMovementsByPersonCode "+personCode);
		return creditMovementService.getByPersonCode(personCode);
	}
	
}
