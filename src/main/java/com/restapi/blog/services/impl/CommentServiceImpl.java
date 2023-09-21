package com.restapi.blog.services.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.restapi.blog.entites.Comment;
import com.restapi.blog.entites.Post;
import com.restapi.blog.exceptions.ResourceNotFoundException;
import com.restapi.blog.payloads.CommentDto;
import com.restapi.blog.repositories.CommentRepo;
import com.restapi.blog.repositories.PostRepo;
import com.restapi.blog.services.CommentService;


@Service
public class CommentServiceImpl implements CommentService {
	
	@Autowired
	private PostRepo postRepo;
	
	@Autowired
	private CommentRepo commentRepo;
	
	@Autowired
	private ModelMapper mapper;

	@Override
	public CommentDto createComment(CommentDto commentDto, Integer postId) {
		
		Post post=this.postRepo.findById(postId) .orElseThrow(()->new ResourceNotFoundException("Post", "post id", postId));
		
		Comment comment = this.mapper.map(commentDto, Comment.class);
		comment.setPost(post);
		Comment savedComment = this.commentRepo.save(comment);
		
		
		return this.mapper.map(savedComment, CommentDto.class);
	}

	@Override
	public void deleteComment(Integer id) {
		Comment com=this.commentRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("comment", "comment id", id));

		this.commentRepo.delete(com);
	}

}
