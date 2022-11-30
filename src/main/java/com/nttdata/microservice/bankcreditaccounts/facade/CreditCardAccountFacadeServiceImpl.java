package com.nttdata.microservice.bankcreditaccounts.facade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nttdata.microservice.bankcreditaccounts.collections.CreditCardAccountCollection;
import com.nttdata.microservice.bankcreditaccounts.collections.CreditMovementCollection;
import com.nttdata.microservice.bankcreditaccounts.enums.CreditCardAccountEnum;
import com.nttdata.microservice.bankcreditaccounts.services.ICreditCardAccountService;
import com.nttdata.microservice.bankcreditaccounts.services.ICreditMovementService;

import reactor.core.publisher.Mono;

@Service
public class CreditCardAccountFacadeServiceImpl implements ICreditCardAccountFacadeService {
	
	@Autowired
	private ICreditCardAccountService creditCardAccountService;
	
	@Autowired
	private ICreditMovementService creditMovementService;

	@Override
	public Mono<CreditMovementCollection> paymentCreditCard(CreditMovementCollection creditMovementCollection) throws Exception {
		
		// 1. Registrar movimiento
		CreditMovementCollection collection = new CreditMovementCollection();
		collection.setPersonCode(creditMovementCollection.getPersonCode());
		collection.setMovementType(CreditCardAccountEnum.PAYMENT_CREDIT_CARD.toString());
		collection.setAmount(creditMovementCollection.getAmount());
		collection.setCurrency(creditMovementCollection.getCurrency());
		Mono<CreditMovementCollection> result = creditMovementService.save(collection);
		
		// 2. actualizar saldo deudor tarjeta credito
		/*
		Mono<CreditCardAccountCollection> obj = creditCardAccountService.getByAccountNumber(creditMovementCollection.getAccountNumber());
		CreditCardAccountCollection objNew = obj.block();
		objNew.setCreditAmountAvailable(objNew.getCreditAmountAvailable() + creditMovementCollection.getAmount());
		creditCardAccountService.update(objNew, creditMovementCollection.getAccountNumber()); */
		
		return result;
	}

	@Override
	public Mono<CreditMovementCollection> consumeCreditCard(CreditMovementCollection creditMovementCollection) throws Exception {
		
		// 1. Registrar movimiento
		CreditMovementCollection collection = new CreditMovementCollection();
		collection.setPersonCode(creditMovementCollection.getPersonCode());
		collection.setMovementType(CreditCardAccountEnum.CONSUME_CREDIT_CARD.toString());
		collection.setAmount(creditMovementCollection.getAmount());
		collection.setCurrency(creditMovementCollection.getCurrency());
		Mono<CreditMovementCollection> result = creditMovementService.save(collection);
		
		// 2. actualizar saldo deudor tarjeta credito
		/*
		Mono<CreditCardAccountCollection> obj = creditCardAccountService.getByAccountNumber(creditMovementCollection.getAccountNumber());
		CreditCardAccountCollection objNew = obj.block();
		objNew.setCreditAmountAvailable(objNew.getCreditAmountAvailable() - creditMovementCollection.getAmount());
		creditCardAccountService.update(objNew, creditMovementCollection.getAccountNumber());*/
		
		return result;
	}

	@Override
	public Mono<CreditCardAccountCollection> createPersonalCreditCard(
			CreditCardAccountCollection creditCardAccountCollection) throws Exception {
		/*
		 * sin logica de negocio
		 */
		
		Mono<CreditCardAccountCollection> result = creditCardAccountService.save(creditCardAccountCollection);
		
		return result;
	}

	@Override
	public Mono<CreditCardAccountCollection> createEnterpriseCreditCard(
			CreditCardAccountCollection creditCardAccountCollection) throws Exception {
		
		/*
		 * sin logica de negocio
		 */
		
		Mono<CreditCardAccountCollection> result = creditCardAccountService.save(creditCardAccountCollection);
		
		return result;
	}
	

	

}
