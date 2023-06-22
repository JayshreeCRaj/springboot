package com.springmicroservices.models;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@NoArgsConstructor
public class Account {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer accountNumber;
//	@JoinColumn(name = "customerId", nullable = false)
	private int customerId;
	private String accountType;
	private String branchAddress;
//	@CreationTimestamp
	private LocalDate createDt;

}
