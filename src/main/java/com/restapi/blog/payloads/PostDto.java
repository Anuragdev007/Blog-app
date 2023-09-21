package com.restapi.blog.payloads;

import java.util.HashSet;
import java.util.Set;

import com.restapi.blog.entites.Category;
import com.restapi.blog.entites.Comment;
import com.restapi.blog.entites.User;

import jakarta.persistence.ManyToOne;

public class PostDto {

	private Integer postId;
	
	private String title;

	private String content;
	
	private String imageName;

	private java.util.Date date;
	
	private Category category;
	
	private User user;
	
	private Set<CommentDto> comments=new HashSet<>();

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getImageName() {
		return imageName;
	}

	public void setImageName(String imageName) {
		this.imageName = imageName;
	}

	public java.util.Date getDate() {
		return date;
	}

	public void setDate(java.util.Date date) {
		this.date = date;
	}



	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Integer getPostId() {
		return postId;
	}

	public void setPostId(Integer postId) {
		this.postId = postId;
	}

	public Set<CommentDto> getComments() {
		return comments;
	}

	public void setComments(Set<CommentDto> comments) {
		this.comments = comments;
	}



	

}
