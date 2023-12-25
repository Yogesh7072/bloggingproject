package com.example.demo.repositry;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Post;

public interface PostRepositry extends JpaRepository<Post, Integer> {

	// Post save(Post post);

}
