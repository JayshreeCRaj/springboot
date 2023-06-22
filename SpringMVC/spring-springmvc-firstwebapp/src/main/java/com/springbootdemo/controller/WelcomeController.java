package com.springbootdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class WelcomeController {
	
	@RequestMapping("/welcome")
	public ModelAndView displayMessage() {
		ModelAndView mav = new ModelAndView();
		mav.addObject("msg","Welcome to Spring MVC Module");
		mav.setViewName("index");
		return mav;
	}
	
	@RequestMapping("/greet")
	public String displayMessage(Model model) {
		model.addAttribute("msg","Good Morning");
		return "index";
	}

}
