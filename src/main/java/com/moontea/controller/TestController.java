package com.moontea.controller;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.moontea.entity.Book;
import com.moontea.interceptor.AuditLog;
import com.moontea.interceptor.AuditLogList;
import com.moontea.interceptor.SpringContextUtil;
import com.moontea.repo.AuthorRepository;
import com.moontea.repo.BookRepository;

@RestController
@RequestMapping("/Test")
public class TestController {

	@Autowired
	private AuthorRepository authorRepostiory;

	@Autowired
	private BookRepository bookRepository;

	@GetMapping
	public Object findAuthorForPage(
			@PageableDefault(page = 0, size = 5, sort = { "id" }, direction = Sort.Direction.DESC) Pageable pageable) {
		return authorRepostiory.findAll(pageable);
	}

	@PostMapping("/insert")
	public Book insertBook() {
		Book book = new Book();
		book.setIsbn(UUID.randomUUID().toString());
		Book book2 = bookRepository.save(book);
		AuditLogList auditLogList = (AuditLogList) SpringContextUtil.getBean("AuditLogList");
		List<AuditLog> list = auditLogList.getList();
		for (AuditLog auditLog : list) {
			System.out.println(auditLog.getSql());
			System.out.println(auditLog.getLogTime());
		}
		return book2;
	}

	@PostMapping("/queryAll")
	public List<Book> queryBooks() {
		
		return bookRepository.findAll();
	}

	@PostMapping("/update")
	public Book updateBook(@RequestParam String isbn) {
		Optional<Book> bookOpt = bookRepository.findById(isbn);
		if (bookOpt.isPresent()) {
			Book book = bookOpt.get();
			book.setAuthor("5566");
			return bookRepository.save(book);
		}
		return null;
	}
	
	@PostMapping("/delete")
	public void deleteBook(@RequestParam String isbn) {
		bookRepository.deleteById(isbn);
	}

}
