package com.springmicroservices.responses;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Cards {
	
		private Integer cardId;
		private int customerId;
		private String cardNumber;
		private String cardType;
		private int totalLimit;
		private int amountUsed;
		private int availableAmount;
		private Date createDt;


}
