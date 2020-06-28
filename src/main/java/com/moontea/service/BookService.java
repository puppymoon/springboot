package com.moontea.service;

import java.util.List;

import com.moontea.entity.Book;

public interface BookService {

	List<Book> findAll();

	Book save(Book book);

}
