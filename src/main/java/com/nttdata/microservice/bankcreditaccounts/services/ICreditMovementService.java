package com.nttdata.microservice.bankcreditaccounts.services;

import com.nttdata.microservice.bankcreditaccounts.collections.CreditMovementCollection;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ICreditMovementService {
	
	public Mono<CreditMovementCollection> savePaymentCredit(CreditMovementCollection collection);
	public Mono<CreditMovementCollection> savePaymentCreditCard(CreditMovementCollection collection);
	public Mono<CreditMovementCollection> saveConsumeCreditCard(CreditMovementCollection collection);
	public Mono<CreditMovementCollection> savePaymentCreditThird(CreditMovementCollection collection);
	
	public Flux<CreditMovementCollection> listAllMovementsCreditByPersonCode(String personCode);
	public Flux<CreditMovementCollection> listAllMovementsCreditCardByPersonCode(String personCode);
	
}
