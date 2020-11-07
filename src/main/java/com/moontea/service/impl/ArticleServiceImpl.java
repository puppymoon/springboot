package com.moontea.service.impl;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.moontea.entity.Article;
import com.moontea.repo.ArticleRepository;
import com.moontea.service.ArticleService;

@Service
public class ArticleServiceImpl implements ArticleService {

	@Autowired
	private ArticleRepository articleRepository;

	@Override
	public Article saveArticle(Article article) {
		return articleRepository.save(article);
	}

	@Override
	public Article updateArticle(Article article) {
		return articleRepository.save(article);
	}

	@Override
	public Article findArticle(Long id) {
		return articleRepository.findById(id).orElseThrow(() -> new EntityNotFoundException());
	}

	@Override
	public void deleteArticle(Long id) {
		articleRepository.deleteById(id);
	}
}
