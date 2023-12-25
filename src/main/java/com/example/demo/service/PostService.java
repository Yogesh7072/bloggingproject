package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.PostDto;
import com.example.demo.model.User;

public interface PostService {

	PostDto newPost(PostDto dto, Integer userid, Integer categoryId);

	PostDto updatePost(PostDto dto, Integer updatedUserId);

	void deletePost(Integer postId);

	public PostDto getPost(Integer postId);

	public List<PostDto> getAllPost(User user, Integer categoryId, Integer userId);

}
