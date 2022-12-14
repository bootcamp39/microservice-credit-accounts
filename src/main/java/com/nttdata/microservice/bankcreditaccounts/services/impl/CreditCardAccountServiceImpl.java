package com.nttdata.microservice.bankcreditaccounts.services.impl;

import java.util.Date;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.nttdata.microservice.bankcreditaccounts.repository.ICreditCardAccountRepository;
import com.nttdata.microservice.bankcreditaccounts.services.ICreditCardAccountService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

//@Service
public class CreditCardAccountServiceImpl implements ICreditCardAccountService{
	/*
	@Autowired
	private ICreditCardAccountRepository creditCardAccountRepository;

	@Override
	public Flux<CreditCardAccountCollection> getAll() throws Exception {
		// TODO Auto-generated method stub
		return creditCardAccountRepository.findAll();
	}

	@Override
	public Mono<CreditCardAccountCollection> getByAccountNumber(String accountNumber) throws Exception {
		// TODO Auto-generated method stub
		Mono<CreditCardAccountCollection> col = creditCardAccountRepository.findAll().filter(x -> x.getAccountNumber().equals(accountNumber)).next();
		
		return col;
	}

	@Override
	public Flux<CreditCardAccountCollection> getByPersonCode(String personCode) throws Exception {
		// TODO Auto-generated method stub
		Flux<CreditCardAccountCollection> col = creditCardAccountRepository.findAll().filter(x -> x.getPersonCode().equals(personCode));
		
		return col;
	}

	@Override
	public Mono<CreditCardAccountCollection> save(CreditCardAccountCollection collection) throws Exception {
		// TODO Auto-generated method stub
		collection.setCreditCode(UUID.randomUUID().toString());
		collection.setAccountNumber(UUID.randomUUID().toString());
		
		collection.setCreditAmountLimit(collection.getCreditAmountLimit() != null ? collection.getCreditAmountLimit() : 0.00);
		collection.setCreditAmountAvailable(collection.getCreditAmountLimit() != null ? collection.getCreditAmountLimit() : 0.00);
		
		collection.setCurrency(collection.getCurrency() != null ? collection.getCurrency() : "PEN"); //DEFAULT SOLES
		collection.setState("1");
		collection.setCreatedAt(new Date());
		
		return creditCardAccountRepository.save(collection);
	}

	@Override
	public Mono<CreditCardAccountCollection> update(CreditCardAccountCollection updatedCollection, String accountNumber)
			throws Exception {
		// TODO Auto-generated method stub
		Mono<CreditCardAccountCollection> result = this.getByAccountNumber(accountNumber);
		CreditCardAccountCollection resultNew = result.block();
		
		resultNew.setCreditAmountLimit(updatedCollection.getCreditAmountLimit());
		resultNew.setCreditAmountAvailable(updatedCollection.getCreditAmountAvailable());
		resultNew.setCurrency(updatedCollection.getCurrency());
		resultNew.setState(updatedCollection.getState());
		resultNew.setUpdatedAt(new Date());
		
		return creditCardAccountRepository.save(resultNew);
	}

	@Override
	public Mono<Void> delete(CreditCardAccountCollection collection) throws Exception {
		// TODO Auto-generated method stub
		Mono<CreditCardAccountCollection> result = this.getByAccountNumber(collection.getAccountNumber());
		CreditCardAccountCollection resultNew = result.block();
		
		return creditCardAccountRepository.delete(resultNew);
	}
	
	@Override
	public Mono<Boolean> haveCreditCard(String personCode) throws Exception {
		// TODO Auto-generated method stub
		Mono<Boolean> col = creditCardAccountRepository.findAll().filter(x -> x.getPersonCode().equals(personCode)).count().flatMap( c -> {
			if(c > 0) {
				return Mono.just(true);
			}else {
				return Mono.just(false);
			}
		});
		
		return col;
	}
*/
}
