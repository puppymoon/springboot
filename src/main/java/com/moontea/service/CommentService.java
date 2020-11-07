package com.moontea.service;

import com.moontea.entity.Comment;

public interface CommentService {

	Comment saveComment(Comment comment);

	void deleteComment(Long id);
}
