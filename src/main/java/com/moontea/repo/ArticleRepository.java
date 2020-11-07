package com.moontea.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.moontea.entity.Article;

public interface ArticleRepository extends JpaRepository<Article, Long> {
}
