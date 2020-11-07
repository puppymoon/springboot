package com.moontea.service;

import com.moontea.entity.Author;

public interface AuthorService {

	Author saveAuthor(Author author);

	Author updateAuthor(Author author);

	Author findAuthor(Long id);

	void deleteAuthor(Long id);

}
