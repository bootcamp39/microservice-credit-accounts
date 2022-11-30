package com.nttdata.microservice.bankcreditaccounts.collections;

import java.util.Date;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(value = "credit_movements")
public class CreditMovementCollection {

	@Id
	private ObjectId id;

	private String creditMovementCode;
	private String personCode;
	private String accountNumber;
	private String movementType;
	private Double amount;
	private String currency;

	private String state;
	private Date createdAt;
	private Date updatedAt;
	private Date deletedAt;

}
