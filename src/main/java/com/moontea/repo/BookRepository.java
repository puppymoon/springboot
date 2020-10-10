package com.moontea.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.moontea.entity.Book;

public interface BookRepository extends JpaRepository<Book, String> {

	List<Book> findByAuthor(String author);

	List<Book> findByAuthorAndBookName(String author, String bookName);

	// 查詢以...為結尾的 == select * from book where BOOK_NAME like '%bookName'
	List<Book> findByBookNameEndsWith(String bookName);

	// 查詢內容有包含...的 == select * from book where BOOK_NAME like '%bookName%'
	List<Book> findByBookNameContains(String bookName);

	// Book為com.moontea.entity下的實體名稱
	@Query("select b from Book b where length(b.bookName) > ?1")
	List<Book> findByBookNameLength(int length);

	// 也可以使用原生寫法 如下
//	@Query(value = "select * from book where length(BOOK_NAME) > ?1", nativeQuery = true)
//	List<Book> findByBookNameLength(int length);

}
