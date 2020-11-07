package com.moontea.service.impl;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.moontea.entity.Comment;
import com.moontea.repo.CommentRepository;
import com.moontea.service.CommentService;

@Service
public class CommentServiceImpl implements CommentService {

	@Autowired
	private CommentRepository commentRepository;

	@Transactional
	@Override
	public Comment saveComment(Comment comment) {
		return commentRepository.save(comment);
	}

	@Transactional
	@Override
	public void deleteComment(Long id) {
		Comment comment = commentRepository.findById(id).orElseThrow(() -> new EntityNotFoundException());
		comment.clearComment();
		commentRepository.deleteById(id);
	}
}
