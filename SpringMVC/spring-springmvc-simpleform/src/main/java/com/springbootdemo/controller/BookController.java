package com.springbootdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.springbootdemo.model.Book;

@Controller
public class BookController {
	
	@GetMapping(value= "/loadform")
	public String loadForm() {
		return "index";
	}
	
	@PostMapping("/saveBook")
	public String handleSubmitBtn(Book book, Model model) {
		model.addAttribute("bookInfo", book);
		return "bookdata";
	}

}
