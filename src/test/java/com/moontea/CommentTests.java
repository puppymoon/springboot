package com.moontea;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.moontea.entity.Article;
import com.moontea.entity.Comment;
import com.moontea.service.ArticleService;
import com.moontea.service.CommentService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CommentTests {

	@Autowired
	private CommentService commentService;

	@Autowired
	private ArticleService articleService;

	@Test
	public void saveCommentTest() {
		Article article = articleService.findArticle(2L);

		Comment comment = new Comment();
		comment.setContent("关于互联网思维....");
		comment.setArticle(article);

		commentService.saveComment(comment);
	}

	@Test
	public void deleteCommentTest() {
		commentService.deleteComment(8L);
	}
}
