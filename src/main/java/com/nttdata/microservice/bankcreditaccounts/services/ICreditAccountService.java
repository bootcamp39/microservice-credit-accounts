package com.nttdata.microservice.bankcreditaccounts.services;

import com.nttdata.microservice.bankcreditaccounts.collections.CreditAccountCollection;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ICreditAccountService {

	public Flux<CreditAccountCollection> getAll() throws Exception;
	public Flux<CreditAccountCollection> getByPersonCode(String personCode) throws Exception;
	public Mono<CreditAccountCollection> getByAccountNumber(String accountNumber) throws Exception;
	public Mono<CreditAccountCollection> save(CreditAccountCollection collection) throws Exception;
	public Mono<CreditAccountCollection> update(CreditAccountCollection updatedCollection, String accountNumber) throws Exception;
	public Mono<Void> delete(CreditAccountCollection collection) throws Exception;
	public Mono<Long> countPersonalCreditAccount(String personCode) throws Exception;
	
}
