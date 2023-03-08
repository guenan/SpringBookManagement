package com.mytech.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mytech.entity.MyBookList;
import com.mytech.repository.MyBookRepository;

@Service
public class MyBookListService {
	
	@Autowired
	private MyBookRepository myBookRepo;
	
	public void saveMyBooks(MyBookList mybook) {
		 myBookRepo.save(mybook);
	}
	
	public List<MyBookList> getAllMyBookList(){
		return myBookRepo.findAll();
	}
	
	public void deleteById(int id) {
		myBookRepo.deleteById(id);
	}

}
