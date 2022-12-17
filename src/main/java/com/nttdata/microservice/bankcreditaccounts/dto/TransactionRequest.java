package com.nttdata.microservice.bankcreditaccounts.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TransactionRequest {
	
	private String creditNumber;
	private String personCode;
	private String personType;

}

