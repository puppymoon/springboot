package com.moontea.service;

import java.util.List;

import com.moontea.entity.Book;

public interface ApiBookService {

	List<Book> findAllBooks();

	Book getBookByIsbn(String isbn);

	Book saveBook(Book book);

	Book updateBook(Book book);

	void deleteBookByIsbn(String isbn);

	void deleteAllBooks();
}
