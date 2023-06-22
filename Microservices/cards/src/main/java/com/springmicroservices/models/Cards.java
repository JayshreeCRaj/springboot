package com.springmicroservices.models;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
public class Cards {
	
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Integer cardId;
		private int customerId;
		private String cardNumber;
		private String cardType;
		private int totalLimit;
		private int amountUsed;
		private int availableAmount;
		private Date createDt;


}
