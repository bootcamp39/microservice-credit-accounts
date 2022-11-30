package com.nttdata.microservice.bankcreditaccounts.facade;

import com.nttdata.microservice.bankcreditaccounts.collections.CreditCardAccountCollection;
import com.nttdata.microservice.bankcreditaccounts.collections.CreditMovementCollection;

import reactor.core.publisher.Mono;

public interface ICreditCardAccountFacadeService {
	
	public Mono<CreditCardAccountCollection> createPersonalCreditCard(CreditCardAccountCollection creditCardAccountCollection) throws Exception;
	public Mono<CreditCardAccountCollection> createEnterpriseCreditCard(CreditCardAccountCollection creditCardAccountCollection) throws Exception;
	public Mono<CreditMovementCollection> paymentCreditCard(CreditMovementCollection creditMovementCollection) throws Exception;
	public Mono<CreditMovementCollection> consumeCreditCard(CreditMovementCollection creditMovementCollection) throws Exception;

}
