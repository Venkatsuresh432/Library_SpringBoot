package com.Library.Mini.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Library.Mini.Entity.Book;


@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

	public Book findByBookTitle(String bookTitle);
}
