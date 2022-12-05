package com.nttdata.microservice.bankcreditaccounts.services;

import com.nttdata.microservice.bankcreditaccounts.collections.CreditCardAccountCollection;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ICreditCardAccountService {
	
	public Flux<CreditCardAccountCollection> getAll() throws Exception;
	public Mono<CreditCardAccountCollection> getByAccountNumber(String accountNumber) throws Exception;
	public Flux<CreditCardAccountCollection> getByPersonCode(String personCode) throws Exception;
	public Mono<CreditCardAccountCollection> save(CreditCardAccountCollection collection) throws Exception;
	public Mono<CreditCardAccountCollection> update(CreditCardAccountCollection updatedCollection, String accountNumber) throws Exception;
	public Mono<Void> delete(CreditCardAccountCollection collection) throws Exception;
	public Mono<Boolean> haveCreditCard(String personCode) throws Exception;

}
