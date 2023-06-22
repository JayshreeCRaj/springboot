package com.springbootdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class WelcomeController {
	
	@GetMapping("/welcome")
	public String displayWelcomeMsg(@RequestParam("name") String userName, Model model) {
		String outputString = userName.concat(", Welcome to Spring Boot Course");
		model.addAttribute("name", outputString);
		return "index";
	}
	
	@GetMapping("/bookprice")
	public String displayNameAndPrice(@RequestParam("bookName") String bookName, @RequestParam("authorName") String authorName, Model model) {
		String outputString = "Price of " + bookName +" Written By " + authorName + " is 2095 Rs";
		model.addAttribute("name", outputString);
		return "index";
	}

}
