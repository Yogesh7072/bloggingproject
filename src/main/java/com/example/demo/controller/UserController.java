package com.example.demo.controller;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;

import javax.validation.Valid;
import javax.validation.ValidationException;

import org.apache.log4j.Logger;
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
import com.example.demo.apiResponse.ApiResponse;
import com.example.demo.customException.ResourceNotFoundException;
import com.example.demo.customException.UserNotFoundException;
import com.example.demo.dto.UserDto;
import com.example.demo.model.User;
import com.example.demo.service.serviceImp.UserServiceImp;

@RestController
@RequestMapping("/User/api")
public class UserController {
	Logger logger = Logger.getLogger(UserController.class);

	@Autowired
	UserServiceImp userService;

	/**
	 * @author yogeshwar chate
	 * @apiNote this api represent the create new User
	 * @see binding with @PostMapping
	 * @see
	 * @return New Added User
	 * @throws SQLIntegrityConstraintViolationException
	 * @see if user not store in database then return exception
	 */

	@PostMapping(URIConstant.URI_USER)
	public ResponseEntity<UserDto> createUser(@Valid @RequestBody UserDto user)
			throws SQLIntegrityConstraintViolationException {

		logger.info("createUser request payload" + user);
		UserDto saveUser = userService.saveUser(user);
		logger.info("final response :  controller  :  " + saveUser);

		return new ResponseEntity<UserDto>(saveUser, HttpStatus.ACCEPTED);

	}

	@PutMapping(URIConstant.URI_USER)
	public ResponseEntity<UserDto> updateUser(@RequestBody UserDto user) {
		if (user.getGmailId() != null && !user.getGmailId().contains("@"))
			throw new ValidationException("must be a well-formed email address");

		UserDto updateUser = userService.updateUser(user);

		if (updateUser != null) {
			logger.info("updated response :  controller  :  " + updateUser);

			return new ResponseEntity<UserDto>(updateUser, HttpStatus.ACCEPTED);

		} else {

			throw new ResourceNotFoundException(Apiconstants.NULL_USER_RESPONSE, "id", user.getUid());

		}

	}

	@GetMapping(URIConstant.URI_USER + URIConstant.URI_USER_Id)
	public ResponseEntity<UserDto> getUserByIds(@PathVariable int id) {
		UserDto user = userService.getUserById(id);
		if (user != null) {
			logger.info("getUserByIds response :  controller  :  " + user);
			return new ResponseEntity<UserDto>(user, HttpStatus.ACCEPTED);
		} else {
			throw new ResourceNotFoundException(Apiconstants.NULL_USER_RESPONSE, " id ", id);
		}
	}

	@DeleteMapping(URIConstant.URI_USER + URIConstant.URI_USER_Id)
	public ResponseEntity<ApiResponse> deleteUser(@PathVariable int id) {

		userService.deleteUser(id);
		return new ResponseEntity<ApiResponse>(new ApiResponse(Apiconstants.DELETE_USER, true), HttpStatus.ACCEPTED);
	}

	@GetMapping(URIConstant.URI_USER)
	public ResponseEntity<List<UserDto>> getAllUsers() {
		List<UserDto> allUser = userService.getAllUser();

		if (allUser != null) {

			return new ResponseEntity<List<UserDto>>(allUser, HttpStatus.OK);

		} else {
			// return null;

			throw new NullPointerException(Apiconstants.NULL_USER_RESPONSE);

		}

	}

}
