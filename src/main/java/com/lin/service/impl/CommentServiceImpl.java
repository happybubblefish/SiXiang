package com.lin.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lin.model.Comment;
import com.lin.repository.CommentRepository;
import com.lin.service.CommentService;

@Service
@Transactional
public class CommentServiceImpl implements CommentService {
	
	@Autowired
	private CommentRepository commentRepository;

	@Override
	public List<Comment> findAllComments() {
		return commentRepository.findAll();
	}

	@Override
	public List<Comment> findAllCommentsByEmail(String email) {
		List<Comment> comments = commentRepository.findAll();
		List<Comment> result = comments.stream().filter(c -> c.getEmail().equalsIgnoreCase(email)).collect(Collectors.toList());

		return result;
	}
	
	
}
