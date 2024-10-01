package com.Library.Mini.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Library.Mini.Entity.Book;
import com.Library.Mini.Service.BookService;

@CrossOrigin(origins ="http://127.0.0.1:5500")
@RestController
@RequestMapping("/books/")
public class BookController {

	@Autowired
	private BookService  bserv;
	
	@GetMapping("/findall")
	public List<Book> findAllBooks(){
		return bserv.getAllBooks();
	}
	@GetMapping("/findById/{bookId}")
	public Book findById(@PathVariable Long bookId)
	{
		return bserv.findById(bookId);
	}
	@PostMapping("/addBook")
	public Book addBook(@RequestBody Book book)
	{
		return bserv.addBook(book);
	}
	@PutMapping("/update/{bookId}")
	public Book updateBook(@PathVariable Long bookId, @RequestBody Book book) {
		return bserv.addBook(book);
	}
	@DeleteMapping("/deleteB/{bookId}")
	public String deleteBook(@PathVariable Long bookId)   
	{
		return bserv.deleteBook(bookId);
	}
	@PostMapping("/borrowTo/{userId}/bk/{bookId}")
	public ResponseEntity<Book> borrowBook(@PathVariable Long userId,@PathVariable Long bookId)
	{
		Book Bbook = bserv.borrowBook(bookId, userId);
		if(Bbook != null) {
			return ResponseEntity.ok(Bbook);
		}
		else
		{
			return ResponseEntity.badRequest().build();
		}
	}
	@PostMapping("/return/{bookId}")
	public ResponseEntity<Book> returnBook(@PathVariable Long bookId)
	{
			Book Bret = bserv.returnBook(bookId);
			if(Bret != null) {
				return ResponseEntity.ok(Bret);
			}
			else
			{
				return ResponseEntity.badRequest().build();
			}
	}
	
}
