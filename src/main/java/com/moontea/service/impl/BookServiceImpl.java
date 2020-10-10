package com.moontea.service.impl;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

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

	@Override
	public List<Book> findByBookNameLength(int length) {
		return bookRepository.findByBookNameLength(length);
	}

	@Override
	@Transactional
	public int updateBookNameByIsbn(String bookName, String isbn) {
		return bookRepository.updateBookNameByIsbn(bookName, isbn);
	}

	@Override
	public int deleteBookNameByIsbn(String isbn) {
		return bookRepository.deleteBookNameByIsbn(isbn);
	}

	@Override
	@Transactional
	public int deleteAndUpdate(String isbn, String bookName, String isbn2) {

		int delCount = bookRepository.deleteBookNameByIsbn(isbn);

		int updateCount = bookRepository.updateBookNameByIsbn(bookName, isbn2);

		return delCount + updateCount;

	}

}
