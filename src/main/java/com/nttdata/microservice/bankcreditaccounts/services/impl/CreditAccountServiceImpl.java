package com.nttdata.microservice.bankcreditaccounts.services.impl;

import java.util.Date;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



import com.nttdata.microservice.bankcreditaccounts.repository.ICreditAccountRepository;
import com.nttdata.microservice.bankcreditaccounts.services.ICreditAccountService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

//@Service
public class CreditAccountServiceImpl implements ICreditAccountService {
	/*
	@Autowired
	private ICreditAccountRepository creditAccountRepository;

	@Override
	public Flux<CreditAccountCollection> getAll() throws Exception {
		// TODO Auto-generated method stub
		return creditAccountRepository.findAll();
	}

	@Override
	public Flux<CreditAccountCollection> getByPersonCode(String personCode) throws Exception {
		// TODO Auto-generated method stub
		Flux<CreditAccountCollection> col = creditAccountRepository.findAll().filter(x -> x.getPersonCode().equals(personCode));
		
		return col;
	}

	@Override
	public Mono<CreditAccountCollection> getByAccountNumber(String accountNumber) throws Exception {
		// TODO Auto-generated method stub
		Mono<CreditAccountCollection> col = creditAccountRepository.findAll().filter(x -> x.getAccountNumber().equals(accountNumber)).next();
		
		return col;
	}

	@Override
	public Mono<CreditAccountCollection> save(CreditAccountCollection collection) throws Exception {
		// TODO Auto-generated method stub
		collection.setCreditCode(UUID.randomUUID().toString());
		collection.setAccountNumber(UUID.randomUUID().toString());
		
		collection.setCreditAmount(collection.getCreditAmount() != null ? collection.getCreditAmount() : 0.00);
		collection.setCreditRemaining(collection.getCreditAmount() != null ? collection.getCreditAmount() : 0.00);
		
		if(collection.getAccountType() != null) {
			if(collection.getAccountType().equals(CreditAccountEnum.PERSONAL_CREDIT.toString())) {
				collection.setQuantityCreditLimit(1); // MAX 1 
			}else if(collection.getAccountType().equals(CreditAccountEnum.ENTERPRISE_CREDIT.toString())) {
				collection.setQuantityCreditLimit(-1); // SIN LIMITE
			}
		}
		
		collection.setCurrency(collection.getCurrency() != null ? collection.getCurrency() : "PEN"); //DEFAULT SOLES
		collection.setState("1");
		collection.setCreatedAt(new Date());
		
		return creditAccountRepository.save(collection);
	}

	@Override
	public Mono<CreditAccountCollection> update(CreditAccountCollection updatedCollection, String accountNumber) throws Exception {
		// TODO Auto-generated method stub
		Mono<CreditAccountCollection> result = this.getByAccountNumber(accountNumber);
		CreditAccountCollection resultNew = result.block();
		
		resultNew.setCreditAmount(updatedCollection.getCreditAmount());
		resultNew.setCreditRemaining(updatedCollection.getCreditRemaining());
		
		resultNew.setCurrency(updatedCollection.getCurrency());
		resultNew.setState(updatedCollection.getState());
		resultNew.setUpdatedAt(new Date());
		
		return creditAccountRepository.save(resultNew);
	}

	@Override
	public Mono<Void> delete(CreditAccountCollection collection) throws Exception {
		// TODO Auto-generated method stub
		Mono<CreditAccountCollection> result = this.getByAccountNumber(collection.getAccountNumber());
		CreditAccountCollection resultNew = result.block();
		
		return creditAccountRepository.delete(resultNew);
	}

	@Override
	public Mono<Long> countPersonalCreditAccount(String personCode) throws Exception {
		// TODO Auto-generated method stub
		return this.getByPersonCode(personCode).filter(x -> x.getAccountType().equals(CreditAccountEnum.PERSONAL_CREDIT.toString())).count();
	}
*/

}
