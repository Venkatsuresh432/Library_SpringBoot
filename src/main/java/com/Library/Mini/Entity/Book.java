package com.Library.Mini.Entity;

import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity

public class Book {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long bookId;
	private String bookTitle;
	private String bookAuthor;
	private boolean borrowed;
	
	@ManyToOne
	@JoinColumn(name="user_id")
	private UserEntity borrowedBy;

	
	
	public Long getBookId() {
		return bookId;
	}

	public void setBookId(Long bookId) {
		this.bookId = bookId;
	}

	public String getBookTitle() {
		return bookTitle;
	}

	public void setBookTitle(String bookTitle) {
		this.bookTitle = bookTitle;
	}

	public String getBookAuthor() {
		return bookAuthor;
	}

	public void setBookAuthor(String bookAuthor) {
		this.bookAuthor = bookAuthor;
	}

	public boolean isBorrowed() {
		return borrowed;
	}

	public void setBorrowed(boolean borrowed) {
		this.borrowed = borrowed;
	}

	public UserEntity getBorrowedBy() {
		return borrowedBy;
	}

	public void setBorrowedBy(UserEntity borrowedBy) {
		this.borrowedBy = borrowedBy;
	}

	@Override
	public String toString() {
		return "Book [bookId=" + bookId + ", bookTitle=" + bookTitle + ", bookAuthor=" + bookAuthor + ", borrowed="
				+ borrowed + ", borrowedBy=" + borrowedBy + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(bookAuthor, bookId, bookTitle, borrowed, borrowedBy);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Book other = (Book) obj;
		return Objects.equals(bookAuthor, other.bookAuthor) && Objects.equals(bookId, other.bookId)
				&& Objects.equals(bookTitle, other.bookTitle) && borrowed == other.borrowed
				&& Objects.equals(borrowedBy, other.borrowedBy);
	}
	
	
}
