package com.example.demo.Dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demo.dto.PostDto;
import com.example.demo.model.Post;
import com.example.demo.repositry.PostRepositry;

@Repository
public class PostDao {
	@Autowired
	private PostRepositry postRepo;

	public Post savePost(Post post) {

		Post save = postRepo.save(post);
		System.out.println(save.getImageName());
		return save;

	}

}
