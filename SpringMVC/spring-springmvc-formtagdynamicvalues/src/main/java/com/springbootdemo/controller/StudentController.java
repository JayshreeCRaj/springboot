package com.springbootdemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.springbootdemo.model.Student;
import com.springbootdemo.service.StudentService;

@Controller
public class StudentController {

	@Autowired
	private StudentService studentService;
	
	@GetMapping("/studentform")
	public String loadForm(Model model) {
		Student student =new Student();
		model.addAttribute("student", student);
		model.addAttribute("genders", studentService.getGenders());
		model.addAttribute("courses", studentService.getCourses());
		model.addAttribute("timingsInfo", studentService.getTimimgs());
		return "registration";
	}
	
	@PostMapping("/register")
	public String handleSubmitBtn(Student student, Model model) {
		model.addAttribute("student", student);
		return "regSuccess";
	}
}
