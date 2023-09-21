package com.restapi.blog.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.restapi.blog.entites.Comment;

public interface CommentRepo extends JpaRepository<Comment, Integer> {

}
