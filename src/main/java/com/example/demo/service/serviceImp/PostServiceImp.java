package com.example.demo.service.serviceImp;

import java.util.Date;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Dao.CategoryDao;
import com.example.demo.Dao.PostDao;
import com.example.demo.Dao.UserDao;
import com.example.demo.customException.ResourceNotFoundException;
import com.example.demo.dto.CategoryDto;
import com.example.demo.dto.PostDto;
import com.example.demo.model.Category;
import com.example.demo.model.Post;
import com.example.demo.model.User;
import com.example.demo.repositry.CategoryRepositry;
import com.example.demo.repositry.UserRepositry;
import com.example.demo.service.PostService;

@Service
public class PostServiceImp implements PostService {

	@Autowired
	private PostDao dao;

	@Autowired
	private UserRepositry userrepo;

	@Autowired
	private CategoryRepositry categoryrepo;

	public final String imageName = "yogesh.png";

	@Override
	public PostDto newPost(PostDto dto, Integer userid, Integer categoryId) {

		User user = userrepo.findById(userid)
				.orElseThrow(() -> new ResourceNotFoundException("resource not found", "userID", userid));

		Category category = categoryrepo.findById(categoryId)
				.orElseThrow(() -> new ResourceNotFoundException("resource not found", "categoryID", categoryId));
		Post map = new ModelMapper().map(dto, Post.class);

		map.setPostDate(new Date());
		if (map.getImageName() == null)
			map.setImageName(imageName);
		map.setUser(user);
		map.setCategory(category);

		Post savePost = dao.savePost(map);

		PostDto responseObject = new ModelMapper().map(savePost, PostDto.class);

		return responseObject;
	}

	@Override
	public PostDto updatePost(PostDto dto, Integer updatedUserId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deletePost(Integer postId) {
		// TODO Auto-generated method stub

	}

	@Override
	public PostDto getPost(Integer postId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PostDto> getAllPost(User user, Integer categoryId, Integer userId) {
		// TODO Auto-generated method stub
		return null;
	}

}
