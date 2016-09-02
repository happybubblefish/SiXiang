package com.lin.service;

import java.util.List;

import com.lin.model.Comment;

public interface CommentService {

	List<Comment> findAllComments();
	
	List<Comment> findAllCommentsByEmail(String email);
}
