package com.example.demo.Dao;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.apache.log4j.Logger;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demo.apiConstant.Apiconstants;
import com.example.demo.customException.ResourceNotFoundException;
import com.example.demo.customException.UserNotFoundException;
import com.example.demo.dto.UserDto;
import com.example.demo.model.User;
import com.example.demo.repositry.UserRepositry;

@Repository
public class UserDao {

	Logger logger = Logger.getLogger(UserDao.class);

	@Autowired
	UserRepositry userRepo;

	public String abc() {
		String sms = "sucessfully done";
		return sms;
	}

	public User createUser(User user) {
		// TODO Auto-generated method stub

		User save = userRepo.save(user);

		return save;

	}

	public User updateUsers(UserDto userDto) {
		try {

			System.out.println("updateUsers start" + userDto.getUid());

			Optional<User> findById = userRepo.findById(userDto.getUid());
			System.out.println("updateUsers start" + findById);

			User user = findById.get();
			System.out.println("updateUsers start" + user);

			if (userDto.getGmailId() != null && user.getGmailId() != userDto.getGmailId())
				user.setGmailId(userDto.getGmailId());
			if (userDto.getPassword() != null)
				user.setPassword(userDto.getPassword());
			if (userDto.getuAddress() != null)
				user.setuAddress(userDto.getuAddress());
			if (userDto.getUname() != null)
				user.setUname(userDto.getUname());

			User save = userRepo.save(user);
			System.out.println(save);
			return save;

		} catch (Exception e) {
			e.printStackTrace();

			return null;

		}

	}

	public void deleteUser(int uid) {
		// TODO Auto-generated method stub

		try {
			if (userRepo.findById(uid).get() != null) {
				userRepo.deleteById(uid);

			} else {
				throw new NullPointerException(Apiconstants.NULL_USER_RESPONSE);

			}
		} catch (Exception e) {
			e.printStackTrace();

		}
	}

	public User getuserById(int uid) {
		// TODO Auto-generated method stub
		try {
			Optional<User> findById = userRepo.findById(uid);

			if (!findById.isEmpty()) {

				User user = findById.get();
				return user;
			} else {
				throw new ResourceNotFoundException("resource is null ", "user id", uid);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new ResourceNotFoundException("resource is null", " ID :  ", uid);

		}

	}

	public List<UserDto> getAllUser() {
		// TODO Auto-generated method stub
		List<User> findAll = userRepo.findAll();
		if (findAll != null) {

			ArrayList<UserDto> listdto = new ArrayList<UserDto>();
			for (User user2 : findAll) {
				UserDto userdto = new ModelMapper().map(user2, UserDto.class);
				listdto.add(userdto);
			}

			return listdto;
		} else {
			throw new RuntimeException("users not found");
		}
	}

}
