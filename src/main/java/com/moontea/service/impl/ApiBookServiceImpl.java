package com.moontea.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.moontea.entity.Book;
import com.moontea.repo.BookRepository;
import com.moontea.service.ApiBookService;

@Service
public class ApiBookServiceImpl implements ApiBookService {

	@Autowired
	private BookRepository repository;

	@Override
	public List<Book> findAllBooks() {
		return repository.findAll();
	}

	@Override
	public Book getBookByIsbn(String isbn) {
		return repository.findById(isbn).get();
	}

	@Override
	public Book saveBook(Book book) {
		return repository.save(book);
	}

	@Override
	public Book updateBook(Book book) {
		return repository.save(book);
	}

	@Override
	public void deleteBookByIsbn(String isbn) {
		repository.deleteById(isbn);
	}

	@Override
	public void deleteAllBooks() {
		repository.deleteAll();
	}
}
