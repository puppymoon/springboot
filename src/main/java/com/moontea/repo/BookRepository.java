package com.moontea.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.moontea.entity.Book;

public interface BookRepository extends JpaRepository<Book, String> {

}
