package com.example.demo.controller;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.apiConstant.Apiconstants;
import com.example.demo.apiConstant.URIConstant;
import com.example.demo.dto.PostDto;
import com.example.demo.service.serviceImp.PostServiceImp;

@RestController
@RequestMapping(URIConstant.Post + "/api")
public class PostController {
	@Autowired
	private PostServiceImp postservice;

	@PostMapping(URIConstant.Post + "/userId/{userId}/categoryId/{categoryId}")
	public ResponseEntity<PostDto> createPost(@RequestBody PostDto post, @PathVariable Integer userId,
			@PathVariable Integer categoryId) {

		PostDto newPost = postservice.newPost(post, userId, categoryId);

		if (newPost != null) {
			return new ResponseEntity<PostDto>(newPost, HttpStatus.CREATED);

		} else {
			throw new NullPointerException(Apiconstants.POST_NOT_SAVE + "controller is null ");
		}

	}

//	@PutMapping(URIConstant.Post + "/update")
//	public ResponseEntity<PostDto> updatePost() {
//
//		return null;
//
//	}
//
//	@DeleteMapping(URIConstant.Post + "/delete")
//	public ResponseEntity<PostDto> deletePost() {
//
//		return null;
//
//	}
//
//	@GetMapping(URIConstant.Post + "/getById")
//	public ResponseEntity<PostDto> getPost() {
//
//		return null;
//
//	}
//
//	@GetMapping(URIConstant.Post + "/getAll")
//	public ResponseEntity<PostDto> getAllPost() {
//
//		return null;
//
//	}

}
