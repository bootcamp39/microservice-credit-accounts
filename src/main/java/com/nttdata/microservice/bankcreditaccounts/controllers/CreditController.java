package com.nttdata.microservice.bankcreditaccounts.controllers;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nttdata.microservice.bankcreditaccounts.collections.CreditCollection;
import com.nttdata.microservice.bankcreditaccounts.services.ICreditService;

import reactor.core.publisher.Mono;

@RestController
@RequestMapping(value = "/credit")
public class CreditController {
	
	public static Logger log = Logger.getLogger(CreditController.class);
	
	@Autowired
	private ICreditService service;
	
	@GetMapping(value = "/checkIfHaveCreditCard")
	public Mono<Boolean> checkIfHaveCreditCard(@PathVariable("personCode") String personCode) {
		log.info("EJECUTANDO ENDPOINT CreditController.checkIfHaveCreditCard");
		return service.checkIfHaveCreditCard(personCode);
	}
	
	@PostMapping(value = "/saveCreditPersonal")
	public Mono<CreditCollection> saveCreditPersonal(@RequestBody CreditCollection collection) {
		log.info("EJECUTANDO ENDPOINT CreditController.saveCreditPersonal");
		return service.saveCreditPersonal(collection);
	}
	
	@PostMapping(value = "/saveCreditEnterprise")
	public Mono<CreditCollection> saveCreditEnterprise(@RequestBody CreditCollection collection) {
		log.info("EJECUTANDO ENDPOINT CreditController.saveCreditEnterprise");
		return service.saveCreditEnterprise(collection);
	}
	
	@PostMapping(value = "/saveCreditCardPersonal")
	public Mono<CreditCollection> saveCreditCardPersonal(@RequestBody CreditCollection collection) {
		log.info("EJECUTANDO ENDPOINT CreditController.saveCreditCardPersonal");
		return service.saveCreditCardPersonal(collection);
	}
	
	@PostMapping(value = "/saveCreditCardEnterprise")
	public Mono<CreditCollection> saveCreditCardEnterprise(@RequestBody CreditCollection collection) {
		log.info("EJECUTANDO ENDPOINT CreditController.saveCreditCardEnterprise");
		return service.saveCreditCardEnterprise(collection);
	}
	
	@GetMapping(value = "/showAvailableBalanceCreditCard/{creditNumber}")
	public Mono<Double> showAvailableBalanceCreditCard(@PathVariable(value = "creditNumber") String creditNumber){
		log.info("EJECUTANDO ENDPOINT CreditController.showAvailableBalanceCreditCard");
		return service.getAmountAvailable(creditNumber);
	}
	
	
}
