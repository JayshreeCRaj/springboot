package com.springbootdemo.request;

import java.util.Date;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@NoArgsConstructor
@ToString
public class Product {

	private Integer pId;
	
	private String pName;
	private Double price;
	private Boolean active;

	private Date createdTime;
	private Date updatedTime;
	
	private Category category;

}
