package com.moontea;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.alibaba.fastjson.JSON;
import com.moontea.entity.Article;
import com.moontea.entity.Comment;
import com.moontea.service.ArticleService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ArticleTests {

    @Autowired
    private ArticleService articleService;


    @Test
    public void saveArticle() {
        Article article = new Article();
        article.setTitle("关于创业");
        article.setContent("关于创业的一些想法....");

        Comment comment1 = new Comment("评论内容1");
        Comment comment2 = new Comment("评论内容2");

        article.addComment(comment1);
        article.addComment(comment2);

        articleService.saveArticle(article);
    }

    @Test
    public void updateArticle() {
        Article article = articleService.findArticle(3L);
        article.setContent("游记的一些所见所闻....");
        articleService.updateArticle(article);
    }

    @Test
    public void findArticle() {
        Article article = articleService.findArticle(3L);
        System.out.println(JSON.toJSONString(article, true));
    }

    @Test
    public void deleteArticle() {
        articleService.deleteArticle(1L);
    }

}
