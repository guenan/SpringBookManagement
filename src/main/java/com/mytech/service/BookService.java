package com.mytech.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mytech.entity.Book;
import com.mytech.repository.BookRepository;

@Service
public class BookService {

	@Autowired
	private BookRepository bRepo;
	
	public void save(Book book) {
		bRepo.save(book);
	}
	
	public List<Book> getAllBooks(){
		return bRepo.findAll();
	}
	
	public Book getBookById(int id) {
		return bRepo.findById(id).get();
	}
	
	public void deleteBookById(int id) {
		bRepo.deleteById(id);
	}
	

}
