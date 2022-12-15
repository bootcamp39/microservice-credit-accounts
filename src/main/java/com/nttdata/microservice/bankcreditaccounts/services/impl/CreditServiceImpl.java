package com.nttdata.microservice.bankcreditaccounts.services.impl;

import java.util.Date;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.nttdata.microservice.bankcreditaccounts.collections.CreditCollection;
import com.nttdata.microservice.bankcreditaccounts.enums.CreditTypeEnum;
import com.nttdata.microservice.bankcreditaccounts.enums.PersonTypeEnum;
import com.nttdata.microservice.bankcreditaccounts.repository.ICreditRepository;
import com.nttdata.microservice.bankcreditaccounts.services.ICreditService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class CreditServiceImpl implements ICreditService {
	
	@Autowired
	private ICreditRepository repository;

	@Override
	public Mono<CreditCollection> saveCreditPersonal(CreditCollection credit) {
		
		return this.checkIfHaveCreditCard(credit.getPersonCode()).flatMap(x -> {
			
			if(!x) {
				//credit
				credit.setCreditType(CreditTypeEnum.CREDIT.toString());
				credit.setPersonType(PersonTypeEnum.PERSONAL.toString());
				credit.setCreditNumber(UUID.randomUUID().toString());
				
				//audit
				credit.setState("1");
				credit.setCreatedAt(new Date());
				
				return repository.save(credit);
			}else {
				return Mono.error(new Exception("La persona ya cuenta con un crédito activo"));
			}
			
		});
	}

	@Override
	public Mono<CreditCollection> saveCreditEnterprise(CreditCollection credit) {
		
		//credit
		credit.setCreditType(CreditTypeEnum.CREDIT.toString());
		credit.setPersonType(PersonTypeEnum.ENTERPRISE.toString());
		credit.setCreditNumber(UUID.randomUUID().toString());
		
		//audit
		credit.setState("1");
		credit.setCreatedAt(new Date());
		
		return repository.save(credit);
	}

	@Override
	public Mono<CreditCollection> saveCreditCardPersonal(CreditCollection credit) {
		
		//credit card
		credit.setCreditType(CreditTypeEnum.CREDIT_CARD.toString());
		credit.setPersonType(PersonTypeEnum.PERSONAL.toString());
		credit.setCreditNumber(UUID.randomUUID().toString());
		
		//audit
		credit.setState("1");
		credit.setCreatedAt(new Date());
		
		return repository.save(credit);
	}

	@Override
	public Mono<CreditCollection> saveCreditCardEnterprise(CreditCollection credit) {
		
		//credit card
		credit.setCreditType(CreditTypeEnum.CREDIT_CARD.toString());
		credit.setPersonType(PersonTypeEnum.ENTERPRISE.toString());
		credit.setCreditNumber(UUID.randomUUID().toString());
		
		//audit
		credit.setState("1");
		credit.setCreatedAt(new Date());
		
		return repository.save(credit);
	}

	@Override
	public Mono<Boolean> checkIfHaveCreditCard(String personCode) {
		
		return repository.findByPersonCode(personCode)
				.switchIfEmpty(Mono.empty())
				.count()
				.flatMap(x -> {
					if(x > 0) {
						return Mono.just(true);	
					}
					return Mono.just(false);
				});
	}

	@Override
	public Mono<CreditCollection> updateAmountAvalilable(String creditNumber, Double newAmountAvailable) {
		return repository.findByCreditNumber(creditNumber).next().flatMap(collection -> {
			collection.setCreditAmountAvailable(newAmountAvailable);
			return repository.save(collection);
		});
	}

	@Override
	public Mono<Double> getAmountLimit(String creditNumber) {
		return repository.findByCreditNumber(creditNumber).next().flatMap( x -> Mono.just(x.getCreditAmountLimit()));
	}

	@Override
	public Mono<Double> getAmountAvailable(String creditNumber) {
		return repository.findByCreditNumber(creditNumber).next().flatMap( x -> Mono.just(x.getCreditAmountAvailable()));
	}

	@Override
	public Mono<CreditCollection> updatePaymentDate(String creditNumber, Date paymentDate) {
		return repository.findByCreditNumber(creditNumber).next().flatMap(collection -> {
			collection.setPaymentDate(paymentDate);
			return repository.save(collection);
		});
	}

	/**
	 * Ver si tiene deudas
	 */
	@Override
	public Mono<Boolean> checkIfHaveDebt(String personCode) {
		return repository.findByPersonCode(personCode).filter(x -> new Date().compareTo(x.getPaymentDate()) > 0)
				.count().flatMap(w -> {
			if (w > 0) {
				return Mono.just(true);
			}
			return Mono.just(false);
		} );
	}

}
