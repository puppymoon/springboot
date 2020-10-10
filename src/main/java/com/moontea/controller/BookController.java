package com.moontea.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.moontea.entity.Book;
import com.moontea.service.BookService;

@RestController
//@Controller
@RequestMapping("/api/v1")
public class BookController {

	@Autowired
	private BookService bookService;

	@Autowired
	private ObjectMapper objectMapper;

	@Value("${book.web.html}")
	private String website;

	@RequestMapping(value = "/test", method = RequestMethod.GET)
	public String test() {
		return "Test Success";
	}

//	@ResponseBody
	@PostMapping("/testPost")
	public String testPost() {
		return "Test Post Success";
	}

	// 若controller的annotation為@Controller則是返回templates目錄下的網頁
	// pom內需有spring-boot-starter-thymeleaf
	@PostMapping("/testThymeleaf")
	public String testThymeleaf() {
		return "hello.html";
	}

	@GetMapping("/books/{id}")
	public Object getOne(@PathVariable("id") long id) {

		Map<String, Object> book = new HashMap<>();
		book.put("name", "TEST");
		book.put("id", id);
		return book;
	}

	// @RequestParam括號內可以指定傳送的參數的命名，若不寫則命名要一致
	@PostMapping("/books")
	public Object post(@RequestParam("name") String name, @RequestParam("author") String author,
			@RequestParam("isbn") String isbn) {
		Map<String, Object> book = new HashMap<>();
		book.put("name", name);
		book.put("author", author);
		book.put("isbn", isbn);
		book.put("website", website);
		return book;
	}

	/**
	 * 回傳所有書
	 * 
	 * @return
	 */
	@PostMapping("/findAllBooks")
	public List<Book> findAll() {
		return bookService.findAll();
	}

	/**
	 * 新增一本書
	 * 
	 * @return
	 */
	@PostMapping("/saveBook")
	public Book saveBook(@RequestParam String isbn, @RequestParam String author, @RequestParam String bookName,
			@RequestParam String publish) {
		Book book = new Book();
		book.setIsbn(isbn);
		book.setAuthor(author);
		book.setBookName(bookName);
		book.setPublish(publish);
		return bookService.save(book);
	}

	/**
	 * 獲得一本書的資訊
	 * 
	 * @param isbn
	 * @return
	 */
	@PostMapping("/findBook")
	public Book findBook(@RequestParam String isbn) {
		return bookService.findBook(isbn);
	}

	/**
	 * 找到特定作者的書
	 * 
	 * @param author
	 * @return
	 */
	@PostMapping("/findAuthor")
	public List<Book> findAuthor(@RequestParam String author) {
		return bookService.findByAuthor(author);
	}

	/**
	 * 同時以作者名與書名找尋
	 * 
	 * @param author
	 * @param bookName
	 * @return
	 */
	@PostMapping("/findByAuthorAndBookName")
	public List<Book> findByAuthorAndBookName(@RequestParam String author, @RequestParam String bookName) {
		return bookService.findByAuthorAndBookName(author, bookName);
	}

	/**
	 * 查找書名有包含...的
	 * 
	 * @param bookName
	 * @return
	 */
	@PostMapping("/findByBookNameContains")
	public List<Book> findByBookNameContains(@RequestParam String bookName) {
		return bookService.findByBookNameContains(bookName);
	}

	/**
	 * 以書名長度查詢
	 * 
	 * @param length
	 * @return
	 */
	@PostMapping("/findByBookNameLength")
	public List<Book> findByBookNameLength(@RequestParam int length) {
		return bookService.findByBookNameLength(length);
	}

	/**
	 * 更新指定isbn的書名
	 * 
	 * @param bookName
	 * @param isbn
	 * @return
	 */
	@PostMapping("/updateBookNameByIsbn")
	public int updateBookNameByIsbn(@RequestParam String bookName, @RequestParam String isbn) {
		return bookService.updateBookNameByIsbn(bookName, isbn);
	}
	
	@PostMapping("/deleteBookNameByIsbn")
	public int deleteBookNameByIsbn(@RequestParam String isbn) {
		return bookService.deleteBookNameByIsbn(isbn);
	}

	/**
	 * 更新一本書的資訊
	 * 
	 * @param isbn
	 * @param author
	 * @param bookName
	 * @param publish
	 * @return
	 */
	@PostMapping("/updateBook")
	public Book updateBook(@RequestParam String isbn, @RequestParam String author, @RequestParam String bookName,
			@RequestParam String publish) {
		Book book = new Book();
		book.setIsbn(isbn);
		book.setAuthor(author);
		book.setBookName(bookName);
		book.setPublish(publish);
		return bookService.updateBook(book);
	}

	@PostMapping("/deleteBook")
	public void deleteBook(@RequestParam String isbn) {
		bookService.deleteBook(isbn);
	}

}
