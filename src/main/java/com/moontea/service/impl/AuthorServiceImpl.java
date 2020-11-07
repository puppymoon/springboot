package com.moontea.service.impl;

import java.util.Date;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.moontea.entity.Author;
import com.moontea.repo.AuthorRepository;
import com.moontea.service.AuthorService;

@Service
public class AuthorServiceImpl implements AuthorService {

	@Autowired
	private AuthorRepository authorRepostiory;

	@Override
	public Author saveAuthor(Author author) {
		return authorRepostiory.save(author);
	}

	@Override
	public Author updateAuthor(Author author) {
		return authorRepostiory.save(author);
	}

	@Override
	public Author findAuthor(Long id) {
		return authorRepostiory.findById(id).orElseThrow(() -> new EntityNotFoundException());
	}

	@Override
	public void deleteAuthor(Long id) {
		authorRepostiory.findById(id).orElseThrow(() -> new EntityNotFoundException());
	}

}
