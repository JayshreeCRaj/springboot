package com.springbootdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WelcomeController {
	
	@GetMapping("/welcome")
	public String welcomeMessage(Model model) {
		model.addAttribute("msg", "Welcome to Java backend development course");
		return "index";
	}

}
