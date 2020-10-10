package com.moontea.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.moontea.entity.Book;

public interface BookRepository extends JpaRepository<Book, String> {

	List<Book> findByAuthor(String author);

	List<Book> findByAuthorAndBookName(String author, String bookName);

	//查詢以...為結尾的 == select * from book where BOOK_NAME like '%bookName'
	List<Book> findByBookNameEndsWith(String bookName);

	//查詢內容有包含...的 == select * from book where BOOK_NAME like '%bookName%'
	List<Book> findByBookNameContains(String bookName);
}
