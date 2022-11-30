package com.nttdata.microservice.bankcreditaccounts.repository;

import org.bson.types.ObjectId;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

import com.nttdata.microservice.bankcreditaccounts.collections.CreditAccountCollection;

@Repository
public interface ICreditAccountRepository extends ReactiveCrudRepository<CreditAccountCollection, ObjectId> {

}
