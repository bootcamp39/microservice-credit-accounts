package com.nttdata.microservice.bankcreditaccounts.controllers;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nttdata.microservice.bankcreditaccounts.collections.CreditAccountCollection;
import com.nttdata.microservice.bankcreditaccounts.collections.CreditMovementCollection;
import com.nttdata.microservice.bankcreditaccounts.facade.ICreditAccountFacadeService;
import com.nttdata.microservice.bankcreditaccounts.services.ICreditAccountService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping(value = "/credit-accounts")
public class CreditAccountRestController {
	
	public static Logger log = Logger.getLogger(CreditAccountRestController.class);
	
	@Autowired
	private ICreditAccountService creditAccountService;
	
	@Autowired
	private ICreditAccountFacadeService creditAccountFacadeService;
	
	@GetMapping(value = "/list-all")
	public Flux<CreditAccountCollection> getAllCreditAccounts() throws Exception{
		log.info("EJECUTANDO ENDPOINT CreditAccountRestController.getAllCreditAccounts");
		return creditAccountService.getAll();
	}
	
	@GetMapping(value = "/find/{personCode}")
	public Flux<CreditAccountCollection> getCreditAccountsByPersonCode(@PathVariable("personCode") String personCode) throws Exception{
		log.info("EJECUTANDO ENDPOINT CreditAccountRestController.getCreditAccountsByPersonCode "+personCode);
		return creditAccountService.getByPersonCode(personCode);
	}
	
	@GetMapping(value = "/find/credit-number/{numberAccount}")
	public Mono<CreditAccountCollection> getCreditAccountsByNumberAccount(@PathVariable("numberAccount") String numberAccount) throws Exception{
		log.info("EJECUTANDO ENDPOINT CreditAccountRestController.getCreditAccountsByNumberAccount "+ numberAccount);
		return creditAccountService.getByAccountNumber(numberAccount);
	}
	
	@PostMapping(value = "/create-personal-credit")
	public Mono<CreditAccountCollection> createPersonalCredit(@RequestBody CreditAccountCollection newCreditAccount) throws Exception{
		log.info("EJECUTANDO ENDPOINT CreditAccountRestController.createPersonalCredit " + newCreditAccount.toString());
		return creditAccountFacadeService.createPersonalCredit(newCreditAccount);
	}
	
	@PostMapping(value = "/create-enterprise-credit")
	public Mono<CreditAccountCollection> createEnterpriseCredit(@RequestBody CreditAccountCollection newCreditAccount) throws Exception{
		log.info("EJECUTANDO ENDPOINT CreditAccountRestController.createEnterpriseCredit " + newCreditAccount.toString());
		return creditAccountFacadeService.createEnterpriseCredit(newCreditAccount);
	}
	
	@PostMapping(value = "/payment-credit")
	public Mono<CreditMovementCollection> paymentCredit(@RequestBody CreditMovementCollection creditMovementCollection) throws Exception{
		log.info("EJECUTANDO ENDPOINT CreditAccountRestController.paymentCredit " + creditMovementCollection.toString());
		return creditAccountFacadeService.paymentCredit(creditMovementCollection);
	}
	
	/*
	@PutMapping(value = "/update/{accountNumber}")
	public Mono<CreditAccountCollection> updateCreditAccount(@PathVariable("accountNumber") String accountNumber, @RequestBody CreditAccountCollection creditAccountUpdated) throws Exception{
		return creditAccountService.update(creditAccountUpdated, accountNumber);
	} */
	
	@DeleteMapping(value = "/delete")
	public Mono<Void> deleteCreditAccount(@RequestBody CreditAccountCollection creditAccount) throws Exception{
		log.info("EJECUTANDO ENDPOINT CreditAccountRestController.deleteCreditAccount " + creditAccount.toString());
		return creditAccountService.delete(creditAccount);
	}
	
}
