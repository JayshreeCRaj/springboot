package com.springbootdemo.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class Student {
	
	private String firstName;
	private String lastName;
	private String email;
	private String gender;
	private String course;
	private String[] timings;
	

}
