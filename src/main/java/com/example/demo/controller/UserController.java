package com.example.demo.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.UserDto;
import com.example.demo.service.serviceImp.UserServiceImp;

@RestController
public class UserController {
	Logger logger = Logger.getLogger(UserController.class);

	@Autowired
	UserServiceImp userService;

//	, produces = { "application/xml", "application/json" }, consumes = {
//			"application/xml", "application/json" }

	@PutMapping(value = "/createnewUser")
	public ResponseEntity<UserDto> createUser(UserDto user) {

		try {

			logger.info("createUser request payload" + user);
			UserDto saveUser = userService.saveUser(user);
			System.out.println("userService class response" + saveUser);

			if (saveUser != null) {
				logger.info("final response :  controller  :  " + saveUser);

				return new ResponseEntity<UserDto>(saveUser, HttpStatus.ACCEPTED);

			} else {

				throw new NullPointerException("user not save becouse user dto is null");

			}
		} catch (Exception e) {

			e.printStackTrace();
			logger.error("controller create user  : " + e);
			throw new NullPointerException("user not save becouse user dto is null");

		}
	}

}
