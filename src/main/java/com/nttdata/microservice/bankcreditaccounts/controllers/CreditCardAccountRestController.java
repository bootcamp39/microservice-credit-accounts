package com.nttdata.microservice.bankcreditaccounts.controllers;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.nttdata.microservice.bankcreditaccounts.collections.CreditCardAccountCollection;
import com.nttdata.microservice.bankcreditaccounts.collections.CreditMovementCollection;
import com.nttdata.microservice.bankcreditaccounts.facade.ICreditCardAccountFacadeService;
import com.nttdata.microservice.bankcreditaccounts.services.ICreditCardAccountService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping(value = "/credit-card-accounts")
public class CreditCardAccountRestController {
	
	public static Logger log = Logger.getLogger(CreditCardAccountRestController.class);
	
	@Autowired
	private ICreditCardAccountService creditCardAccountService;
	
	@Autowired
	private ICreditCardAccountFacadeService creditCardAccountFacadeService;
	
	@GetMapping(value = "/list-all")
	public Flux<CreditCardAccountCollection> getAllCreditCardAccounts() throws Exception{
		log.info("EJECUTANDO ENDPOINT CreditCardAccountRestController.getAllCreditCardAccounts");
		return creditCardAccountService.getAll();
	}
	
	@GetMapping(value = "/find/{personCode}")
	public Flux<CreditCardAccountCollection> getCreditCatdAccountsByPersonCode(@RequestParam("personCode") String personCode) throws Exception{
		log.info("EJECUTANDO ENDPOINT CreditCardAccountRestController.getCreditCatdAccountsByPersonCode "+personCode);
		return creditCardAccountService.getByPersonCode(personCode);
	}
	
	@PostMapping(value = "/create-personal-credit-card")
	public Mono<CreditCardAccountCollection> createPersonalCreditCard(@RequestBody CreditCardAccountCollection newCreditCardAccount) throws Exception{
		log.info("EJECUTANDO ENDPOINT CreditCardAccountRestController.createPersonalCreditCard "+newCreditCardAccount.toString());
		return creditCardAccountFacadeService.createPersonalCreditCard(newCreditCardAccount);
	}
	
	@PostMapping(value = "/create-enterprise-credit-card")
	public Mono<CreditCardAccountCollection> createEnterpriseCreditCard(@RequestBody CreditCardAccountCollection newCreditCardAccount) throws Exception{
		log.info("EJECUTANDO ENDPOINT CreditCardAccountRestController.createEnterpriseCreditCard "+newCreditCardAccount.toString());
		return creditCardAccountFacadeService.createEnterpriseCreditCard(newCreditCardAccount);
	}
	
	@PostMapping(value = "/payment-credit-card")
	public Mono<CreditMovementCollection> paymentCreditCard(@RequestBody CreditMovementCollection creditMovementCollection) throws Exception{
		log.info("EJECUTANDO ENDPOINT CreditCardAccountRestController.paymentCreditCard "+creditMovementCollection.toString());
		return creditCardAccountFacadeService.paymentCreditCard(creditMovementCollection);
	}
	
	
	@PostMapping(value = "/consume-credit-card")
	public Mono<CreditMovementCollection> consumeCreditCard(@RequestBody CreditMovementCollection creditMovementCollection) throws Exception{
		log.info("EJECUTANDO ENDPOINT CreditCardAccountRestController.consumeCreditCard "+creditMovementCollection.toString());
		return creditCardAccountFacadeService.consumeCreditCard(creditMovementCollection);
	}
	
	/*
	@PutMapping(value = "/update/{accountNumber}")
	public Mono<CreditCardAccountCollection> updateCreditCardAccount(@RequestParam("accountNumber") String accountNumber, @RequestBody CreditCardAccountCollection creditCardAccountUpdated) throws Exception{
		return creditCardAccountService.update(creditCardAccountUpdated, accountNumber);
	} */
	
	@DeleteMapping(value = "/delete")
	public Mono<Void> deleteCreditCardAccount(@RequestBody CreditCardAccountCollection creditCardAccount) throws Exception{
		log.info("EJECUTANDO ENDPOINT CreditCardAccountRestController.deleteCreditCardAccount "+creditCardAccount.toString());
		return creditCardAccountService.delete(creditCardAccount);
	}

}
