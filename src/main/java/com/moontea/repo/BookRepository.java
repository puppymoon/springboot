package com.moontea.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.moontea.entity.Book;

public interface BookRepository extends JpaRepository<Book, String> {

	List<Book> findByAuthor(String author);

	List<Book> findByAuthorAndBookName(String author, String bookName);
}
