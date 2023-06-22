package com.springbootdemo.request;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Setter
@Getter
@NoArgsConstructor
@ToString
public class Category {
	
	private Integer cId;

	private String cName;

	private Date createdTime;

	private Date updatedTime;

	private Set<Product> pSet = new HashSet<>();
}
