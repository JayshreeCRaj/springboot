package com.springbootdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.springbootdemo.model.Student;

@Controller
public class StudentController {
	
	@GetMapping("/studentform")
	public String loadForm(Model model) {
		Student student =new Student();
		model.addAttribute("student", student);
		return "registration";
	}
	
	@PostMapping("/register")
	public String handleSubmitBtn(Student student, Model model) {
		model.addAttribute("student", student);
		return "regSuccess";
	}
}
