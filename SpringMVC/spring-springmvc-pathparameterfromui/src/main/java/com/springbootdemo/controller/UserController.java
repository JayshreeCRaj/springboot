package com.springbootdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.springbootdemo.model.User;

@Controller
public class UserController {
	
	@GetMapping("/user")
	public String getUserDetails(Model model) {
		User userObj = new User();
		userObj.setFirstName("Arjun");
		userObj.setEmailId("arjun12435@gmail.com");
		userObj.setUserId(12435);
		model.addAttribute("user", userObj);
		return "user";
	}

	@GetMapping("/displayUserInfo")
	@ResponseBody
	public User getUserDetails() {
		User userObj = new User();
		userObj.setFirstName("Arjun");
		userObj.setEmailId("arjun12435@gmail.com");
		userObj.setUserId(12435);
		return userObj;
	}
}
