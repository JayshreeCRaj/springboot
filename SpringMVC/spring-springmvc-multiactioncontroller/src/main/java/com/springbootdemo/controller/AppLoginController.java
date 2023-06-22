package com.springbootdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/app")
public class AppLoginController {
	
	@RequestMapping(value={"/","/index","/login"})
	public String loginPage(Model model) {
		model.addAttribute("msg","Welcome to Application Login page");
		return "login";
	}
	
	/*
	 * @RequestMapping(value="/index") public String loginPageIndex(Model model) {
	 * model.addAttribute("msg","Welcome to Application Login page"); return
	 * "login"; }
	 * 
	 * @RequestMapping(value="/") public String loginPageRoot(Model model) {
	 * model.addAttribute("msg","Welcome to Application Login page"); return
	 * "login"; }
	 */

}
