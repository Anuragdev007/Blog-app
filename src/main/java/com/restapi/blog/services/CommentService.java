package com.restapi.blog.services;

import com.restapi.blog.payloads.CommentDto;

public interface CommentService {

	
	CommentDto createComment(CommentDto commentDto,Integer postId);
	void deleteComment(Integer id);
}
