package com.restapi.blog.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.restapi.blog.entites.Category;

public interface CategoryRepo extends JpaRepository<Category, Integer> {

}
