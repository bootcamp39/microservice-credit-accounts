package com.nttdata.microservice.bankcreditaccounts.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.nttdata.microservice.bankcreditaccounts.kafka.common.ReportTransactionDto;
import com.nttdata.microservice.bankcreditaccounts.kafka.producer.ReportTransactionMessagePublish;

@RestController
@RequestMapping(value = "/kafkaCreditAccounts")
public class KafkaController {
	
	private final ReportTransactionMessagePublish transactionMessagePublish;
	
	@Autowired
	public KafkaController(ReportTransactionMessagePublish transactionMessagePublish) {
		this.transactionMessagePublish = transactionMessagePublish;
	}
	
	@PostMapping(value = "/reportPublish")
	public void sendMenssageToKafkaTopic(@RequestBody ReportTransactionDto reportTransactionDto) throws JsonProcessingException {
		this.transactionMessagePublish.sendMessage(reportTransactionDto);
	}

}
