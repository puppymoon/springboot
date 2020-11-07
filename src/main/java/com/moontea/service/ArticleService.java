package com.moontea.service;

import com.moontea.entity.Article;

public interface ArticleService {

	Article saveArticle(Article article);

	Article updateArticle(Article article);

	Article findArticle(Long id);

	void deleteArticle(Long id);
}
