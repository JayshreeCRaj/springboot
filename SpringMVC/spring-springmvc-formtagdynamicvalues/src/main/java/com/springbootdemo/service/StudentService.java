package com.springbootdemo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class StudentService {
	
	public List<String> getGenders(){
		List<String> genders = new ArrayList<String>();
		genders.add("Male");
		genders.add("Female");
		return genders;
	}
	
	public List<String> getCourses(){
		List<String> courses = new ArrayList<String>();
		courses.add("Select");
		courses.add("Java");
		courses.add("Python");
		courses.add("BigData");
		courses.add("Springboot");
		courses.add("Microservices");
		return courses;
	}
	
	public List<String> getTimimgs(){
		List<String> timings = new ArrayList<String>();
		timings.add("Morning");
		timings.add("Afternoon");
		timings.add("Evening");
		return timings;
	}

}
