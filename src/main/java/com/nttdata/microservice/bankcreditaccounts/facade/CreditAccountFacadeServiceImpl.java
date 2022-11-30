package com.nttdata.microservice.bankcreditaccounts.facade;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nttdata.microservice.bankcreditaccounts.collections.CreditAccountCollection;
import com.nttdata.microservice.bankcreditaccounts.collections.CreditMovementCollection;
import com.nttdata.microservice.bankcreditaccounts.enums.CreditAccountEnum;
import com.nttdata.microservice.bankcreditaccounts.services.ICreditAccountService;
import com.nttdata.microservice.bankcreditaccounts.services.ICreditMovementService;

import reactor.core.publisher.Mono;

@Service
public class CreditAccountFacadeServiceImpl implements ICreditAccountFacadeService {
	
	public static Logger log = Logger.getLogger(CreditAccountFacadeServiceImpl.class);
	
	@Autowired
	private ICreditAccountService creditAccountService;
	
	@Autowired
	private ICreditMovementService creditMovementService;

	@Override
	public Mono<CreditMovementCollection> paymentCredit(CreditMovementCollection creditMovementCollection) throws Exception {
		
		// 1. Registrar movimiento
		CreditMovementCollection collection = new CreditMovementCollection();
		collection.setPersonCode(creditMovementCollection.getPersonCode());
		collection.setMovementType(CreditAccountEnum.PAYMENT_CREDIT.toString());
		collection.setAmount(creditMovementCollection.getAmount());
		collection.setCurrency(creditMovementCollection.getCurrency());
		Mono<CreditMovementCollection> result = creditMovementService.save(collection);
		
		// 2. Actualizar saldo deudor
		/*
		Mono<CreditAccountCollection> obj = creditAccountService.getByAccountNumber(creditMovementCollection.getAccountNumber())
											.map(ca -> {
												ca.setCreditRemaining(ca.getCreditRemaining() - creditMovementCollection.getAmount());
												
												return ca;
											});
		
		creditAccountService.update(obj.block(), creditMovementCollection.getAccountNumber()); */
		
		return result;
	}

	@Override
	public Mono<CreditAccountCollection> createPersonalCredit(CreditAccountCollection creditAccountCollection)
			throws Exception {
		
		// 1. Validamos que la persona no cuenta con un credito existente
		Mono<CreditAccountCollection> resultCreate = creditAccountService.countPersonalCreditAccount(creditAccountCollection.getPersonCode())
				.flatMap(value -> {
					if(value == 0) {
						try {
							return creditAccountService.save(creditAccountCollection);
						} catch (Exception e) {
							// TODO Auto-generated catch block
							log.info("OCURRIO UN ERROR AL CREAR EL CREDITO PERSONAL PERSON CODE: "+creditAccountCollection.getPersonCode());
							return Mono.empty();	
						}
					}else {
						log.info("LA PERSONA YA TIENE UN CREDITO PERSONAL");
						return Mono.empty();	
					}
				});
		
		return resultCreate;
	}

	@Override
	public Mono<CreditAccountCollection> createEnterpriseCredit(CreditAccountCollection creditAccountCollection)
			throws Exception {
		
		Mono<CreditAccountCollection> resultCreate = creditAccountService.save(creditAccountCollection);
		
		return resultCreate;
	}

	
}
