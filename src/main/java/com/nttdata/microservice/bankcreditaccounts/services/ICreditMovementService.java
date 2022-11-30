package com.nttdata.microservice.bankcreditaccounts.services;

import com.nttdata.microservice.bankcreditaccounts.collections.CreditMovementCollection;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ICreditMovementService {
	
	public Flux<CreditMovementCollection> getAll() throws Exception;
	public Flux<CreditMovementCollection> getByPersonCode(String personCode) throws Exception;
	public Mono<CreditMovementCollection> save(CreditMovementCollection collection) throws Exception;
	public Mono<CreditMovementCollection> update(CreditMovementCollection updatedCollection, String creditMovementCode) throws Exception;
	public Mono<Void> delete(CreditMovementCollection collection) throws Exception;

}
