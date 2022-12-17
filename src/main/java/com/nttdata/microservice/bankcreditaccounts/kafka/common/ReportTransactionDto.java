package com.nttdata.microservice.bankcreditaccounts.kafka.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReportTransactionDto {
	
	private String personCode;
	private String creditNumber;
	private String movementType;
	private Double amount;
	
}
