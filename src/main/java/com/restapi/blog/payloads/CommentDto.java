package com.restapi.blog.payloads;

import com.restapi.blog.entites.Post;
import com.restapi.blog.entites.User;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

public class CommentDto {


	private int id;
	
	
	private String content;


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getContent() {
		return content;
	}


	public void setContent(String content) {
		this.content = content;
	}
	

	
	
	
}
