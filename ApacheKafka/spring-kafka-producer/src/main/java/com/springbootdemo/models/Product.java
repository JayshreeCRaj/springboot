package com.springbootdemo.models;

import java.util.Date;
import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {

	private UUID pId;
	
	private String pName;
	private Double price;
	private Boolean active;

	private Date createdTime;
	private Date updatedTime;
	
	

}
