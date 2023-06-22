package com.springbootdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class BookController {
	
	@GetMapping("/bookprice/{bname}/{aname}")
	public String displayNameAndPrice(@PathVariable("bname") String bname, 
			@PathVariable("aname") String aname, Model model) {
		String outputString = "Price of " + bname +" Written By " + aname + " is 2095 Rs";
		model.addAttribute("name", outputString);
		return "index";
	}

}
