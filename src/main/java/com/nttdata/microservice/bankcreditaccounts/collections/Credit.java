package com.nttdata.microservice.bankcreditaccounts.collections;

import java.util.Date;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Credit {

	@Id
	private ObjectId id;
	private String creditCode;

	private String personCode;
	private String accountType;
	private String accountNumber;
	private String currency;

	private String state;
	private Date createdAt;
	private Date updatedAt;
	private Date deletedAt;

}
