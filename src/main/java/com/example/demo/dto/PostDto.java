package com.example.demo.dto;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.ManyToOne;

import com.example.demo.model.Category;
import com.example.demo.model.User;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@Getter
@Setter
public class PostDto {

	private int postId;
	private String title;
	private String imageName;
	private String content;
	private Date postDate;
	private CategoryDto category;
	private UserDto user;

}
