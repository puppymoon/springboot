package com.moontea.service.impl;

import java.util.Date;

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

	@Transactional
	@Override
	public Author updateAuthor() {
		Author author = new Author();
		author.setPhone("9999999999");
		author.setNickName("自由自在1");
		author.setSignDate(new Date());
		Author author1 = authorRepostiory.save(author);

		author1.setPhone("111111111");
		Author author2 = authorRepostiory.save(author1);

		int i = 8 / 0;
		return author2;
	}
}
