package com.moontea.service;

import java.util.List;

import com.moontea.entity.Book;

public interface BookService {

	List<Book> findAll();

	Book save(Book book);

	Book updateBook(Book book);

	void deleteBook(String isbn);

	Book findBook(String isbn);
	
	List<Book> findByAuthor(String author);
	
	List<Book> findByAuthorAndBookName(String author, String bookName);
	
	List<Book> findByBookNameContains(String bookName);
	
	List<Book> findByBookNameLength(int length);
	
	int updateBookNameByIsbn(String bookName, String isbn);

}
