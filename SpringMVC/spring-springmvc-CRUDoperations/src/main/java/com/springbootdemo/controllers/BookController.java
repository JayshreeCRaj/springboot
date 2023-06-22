package com.springbootdemo.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.springbootdemo.entities.BookEntity;
import com.springbootdemo.repository.BookRepository;

@Controller
public class BookController {
	
	@Autowired
	private BookRepository bookRepository;
	
	@GetMapping(value="/bookform")
	public String loadBookForm(Model model) {
		BookEntity bookEntity = new BookEntity();
		model.addAttribute("book", bookEntity);
		return "addBook";
	}
	
	@PostMapping("/addBook")
	public String handleSubmitBtn(@ModelAttribute("book")BookEntity book, Model model) {
		BookEntity entity= bookRepository.save(book);
		if(entity.getBookID() != null) {
			model.addAttribute("success", "Book Stored Successfully");
		}
		return "addBook";
	}
	
	@GetMapping(value = "/viewBooks")
	public String viewAllBooks(Model model) {
		model.addAttribute("books", bookRepository.findAll());
		return "viewBooks";
	}
	
	@PostMapping("/editbook/{id}")
	public String editBook(@ModelAttribute("book")BookEntity book, @PathVariable("id") Integer bookID, Model model) {
		
		Optional<BookEntity> optional = bookRepository.findById(bookID);
		if(optional.isPresent()) {
			BookEntity entity = optional.get();
			if(book.getBookName()!=null) {
				entity.setBookName(book.getBookName());
			}
			if(book.getAuthorName()!=null) {
				entity.setAuthorName(book.getAuthorName());
			}
			if(book.getBookPrice()!=null) {
				entity.setBookPrice(book.getBookPrice());
			}
			bookRepository.save(entity);
		}
		return "addBook";
	}

}
