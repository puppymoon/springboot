package com.moontea.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.moontea.entity.Book;
import com.moontea.repo.BookRepository;
import com.moontea.service.BookService;

@Service
public class BookServiceImpl implements BookService {

	@Autowired
	private BookRepository bookRepository;

	@Override
	public List<Book> findAll() {
		return bookRepository.findAll();
	}

	@Override
	public Book save(Book book) {
		return bookRepository.save(book);
	}

	@Override
	public Book findBook(String isbn) {
		Book book = null;
		Optional<Book> opBook = bookRepository.findById(isbn);
		if (opBook.isPresent()) {
			book = opBook.get();
		}
		return book;
	}

	@Override
	public Book updateBook(Book book) {
		return bookRepository.save(book);
	}

	@Override
	public void deleteBook(String isbn) {
		bookRepository.deleteById(isbn);
	}

	@Override
	public List<Book> findByAuthor(String author) {
		return bookRepository.findByAuthor(author);
	}

	@Override
	public List<Book> findByAuthorAndBookName(String author, String bookName) {
		return bookRepository.findByAuthorAndBookName(author, bookName);
	}

	@Override
	public List<Book> findByBookNameContains(String bookName) {
		return bookRepository.findByBookNameContains(bookName);
	}

}
