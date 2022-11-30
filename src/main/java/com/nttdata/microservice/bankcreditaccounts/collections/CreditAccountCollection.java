package com.nttdata.microservice.bankcreditaccounts.collections;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(value = "credit_accounts")
public class CreditAccountCollection extends Credit {
	
	private Double creditAmount;
	private Double creditRemaining;
	private Integer quantityCreditLimit;
	
	
}
