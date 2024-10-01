package com.Library.Mini.Service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Library.Mini.Entity.Book;
import com.Library.Mini.Entity.UserEntity;
import com.Library.Mini.Repository.BookRepository;
import com.Library.Mini.Repository.UserRepositrory;

@Service
public class BookService {

	@Autowired
	private BookRepository bookRepo;
	
	@Autowired
	private UserRepositrory userRepo;
	
	public List<Book> getAllBooks(){
		return bookRepo.findAll();
	}
	
	public Book findById(Long bookId){
		return bookRepo.findById(bookId).orElse(null);
	}
	
	public Book addBook(Book book) {
		return bookRepo.save(book);
	}
	public String deleteBook(Long bookId) {
		bookRepo.deleteById(bookId);
		return "Success";
	}
	public Book borrowBook(Long bookId, Long userId) {
	     	Book book =  bookRepo.findById(bookId).orElse(null);
	     	UserEntity user = userRepo.findById(userId).orElse(null);
	     	if(book != null && !book.isBorrowed() && user != null)
	     	{
	     		book.setBorrowedBy(user);
	     		book.setBorrowed(true);
	     		return bookRepo.save(book);
	     		
	     	}
	     	return null;
	}
	public Book returnBook(Long bookId) {
		Book book = bookRepo.findById(bookId).orElse(null);
		if(book != null && book.isBorrowed()) {
			book.setBorrowedBy(null);
			book.setBorrowed(false);
			return  bookRepo.save(book);
			 
		}
		return null;
	}
}
