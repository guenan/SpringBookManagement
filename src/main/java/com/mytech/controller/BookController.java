package com.mytech.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import com.mytech.entity.Book;
import com.mytech.entity.MyBookList;
import com.mytech.service.BookService;
import com.mytech.service.MyBookListService;

@Controller
public class BookController {
	
	@Autowired
	private BookService service;
	
	@Autowired
	private MyBookListService myBookListService;
	

	@GetMapping("/")
	public String home() {
		return "home";
	}
	
	@GetMapping("/book_register")
	public String bookRegister() {
		return "bookRegister";
	}
	
	@GetMapping("/available_books")
	public ModelAndView getAllBook() {
		List<Book> list = service.getAllBooks();
		return new ModelAndView("/bookList", "book", list);
	}
	
	@PostMapping("/save")
	public String saveBook(@ModelAttribute Book book) {
		service.save(book);
		return "redirect:/available_books";
	}
	
	@GetMapping("/my_books")
	public String getMyBooks(Model model) {
		List<MyBookList> list = myBookListService.getAllMyBookList();
		model.addAttribute("book", list);
		return "myBooks";
	}
	
	@RequestMapping("/mylist/{id}")
	public String getMyListBooks(@PathVariable("id") int id) {
		Book book = service.getBookById(id);
		MyBookList myBookList = new MyBookList(book.getId(), book.getName(), book.getAuthor(), book.getPrice());
		myBookListService.saveMyBooks(myBookList);
		return "redirect:/my_books";
	}
	
	@RequestMapping("/editBook/{id}")
	public String editBook(@PathVariable("id") int id, Model model) {
		Book book = service.getBookById(id);
		model.addAttribute("book", book);
		return "bookEdit";		
	}
	
	@RequestMapping("/deleteBook/{id}")
	public String deleteBook(@PathVariable("id") int id) {
		service.deleteBookById(id);		
		
		return "redirect:/available_books";
	}
	
}
