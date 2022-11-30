package com.nttdata.microservice.bankcreditaccounts.collections;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(value = "credit_card_accounts")
public class CreditCardAccountCollection extends Credit {

	private Double creditAmountLimit;
	private Double creditAmountAvailable;

}
