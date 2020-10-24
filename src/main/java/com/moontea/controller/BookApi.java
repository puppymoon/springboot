package com.moontea.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.moontea.dto.BookDTO;
import com.moontea.entity.Book;
import com.moontea.exception.BookNotFoundException;
import com.moontea.exception.InvalidRequestException;
import com.moontea.service.ApiBookService;

import springfox.documentation.swagger2.mappers.ModelMapper;

@RestController
@RequestMapping("/api/book")
public class BookApi {

	@Autowired
	private ApiBookService apiBookService;

//	@Autowired
//	private ObjectMapper objectMapper;
//
//	@Autowired
//	private ModelMapper modelMapper;

	/**
	 * 
	 * @return
	 */
	@GetMapping("/books")
	public ResponseEntity<?> listAllBooks() {
		List<Book> books = apiBookService.findAllBooks();
		if (books.isEmpty()) {
			throw new BookNotFoundException("Books Not Found");
		}
		return new ResponseEntity<List<Book>>(books, HttpStatus.OK);
	}

	/**
	 * 
	 * @param isbn
	 * @return
	 */
	@GetMapping("/books/{isbn}")
	public ResponseEntity<?> getBook(@PathVariable String isbn) {
		Book book = apiBookService.getBookByIsbn(isbn);
		if (book == null) {
			throw new BookNotFoundException(String.format("book by isbn %s not found", isbn));
		}
		return new ResponseEntity<Object>(book, HttpStatus.OK);
	}

	@PostMapping("/books")
	public ResponseEntity<?> saveBook(@Valid @RequestBody BookDTO bookDTO, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			throw new InvalidRequestException("Invalid parameter", bindingResult);
		}

		Book book = new Book();
		BeanUtils.copyProperties(bookDTO, book);
		return new ResponseEntity<Object>(apiBookService.saveBook(book), HttpStatus.CREATED);
	}

	@PutMapping("/books/{isbn}")
	public ResponseEntity<?> updateBook(@PathVariable String isbn, @Valid @RequestBody BookDTO bookDTO,
			BindingResult bindingResult) {

		Book currentBook = apiBookService.getBookByIsbn(isbn);
		if (currentBook == null) {
			throw new BookNotFoundException(String.format("book by isbn %s not found", isbn));
		}
		if (bindingResult.hasErrors()) {
			throw new InvalidRequestException("Invalid parameter", bindingResult);
		}
		BeanUtils.copyProperties(bookDTO, currentBook);
		return new ResponseEntity<Object>(apiBookService.updateBook(currentBook), HttpStatus.OK);
	}

	@DeleteMapping("/books/{id}")
	public ResponseEntity<?> deleteBook(@PathVariable String isbn) {
		apiBookService.deleteBookByIsbn(isbn);
		return new ResponseEntity<Object>(HttpStatus.NO_CONTENT);
	}

	@DeleteMapping("/books")
	public ResponseEntity<?> deleteAllBooks() {
		apiBookService.deleteAllBooks();
		return new ResponseEntity<Object>(HttpStatus.NO_CONTENT);
	}

}
