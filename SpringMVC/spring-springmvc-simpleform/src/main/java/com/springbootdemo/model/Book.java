package com.springbootdemo.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Book {
	
	private String bookName;
	private String authorName;
	private String price;

}
