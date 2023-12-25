package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.UserDto;
import com.example.demo.model.User;

public interface UserServices {

	UserDto saveUser(UserDto userDto);

	UserDto updateUser(UserDto userDto);

	void deleteUser(int uid);
	
	UserDto getUserById(int uid);
	List<UserDto> getAllUser();

	

}
