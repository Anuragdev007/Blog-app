package com.restapi.blog.services;

import java.util.List;

import com.restapi.blog.entites.Post;
import com.restapi.blog.payloads.PostDto;
import com.restapi.blog.payloads.PostRseponse;

public interface PostService {
	
	//create
	
	PostDto createPost(PostDto postDto,Integer userId,Integer categoryId);
	
	
	//update
	PostDto updatePost(PostDto postDto,Integer postId);
	
	
	//delete
	void deletePost(Integer postId);
		
	//get all post
    PostRseponse getAllPost(Integer pageNumber, Integer pageSize,String sortBy);
		
	//get single post
		
	PostDto getPostById(Integer postId);
		
	//get all post by category
	List<PostDto> getPostByCategory(Integer categoryId);
	
	//get all posts by user
	List<PostDto> getPostByUser(Integer userId);
		
	//search posts
	List<PostDto> searchPost(String Keyword);
		
	

}
