package com.example.demo.service.serviceImp;

import java.util.List;

import org.apache.log4j.Logger;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Dao.UserDao;
import com.example.demo.dto.UserDto;
import com.example.demo.model.User;
import com.example.demo.service.UserServices;

@Service
public class UserServiceImp implements UserServices {

	Logger logger = Logger.getLogger(UserServiceImp.class);

	@Autowired
	private UserDao userdao;

	@Override
	public UserDto saveUser(UserDto userDto) {

		logger.info(" start saveUser method request object  :   " + userDto);

	

			User user = this.setUserDtoToUser(userDto);

			User save = userdao.createUser(user);
			UserDto userDt = this.setUserToUserDto(save);
			logger.info("end saveUser method response object : " + userDt);

			return userDt;

	

	}

	@Override
	public UserDto updateUser(UserDto userDto) {
		// TODO Auto-generated method stub
		logger.info("start updateUser method response object : " + userDto);

		try {

			User user = userdao.updateUsers(userDto);

			UserDto userDt = this.setUserToUserDto(user);
			logger.info("end updateUser method response object : " + userDt);

			return userDt;

		} catch (Exception e) {
			e.printStackTrace();
			logger.error("saveUser", new Exception());
			return null;

		}
	}

	@Override
	public void deleteUser(int uid) {

		try {

			userdao.deleteUser(uid);

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}

	@Override
	public UserDto getUserById(int uid) {
		// TODO Auto-generated method stub

		User user = userdao.getuserById(uid);
		if (user != null) {
			UserDto setUserToUserDto = this.setUserToUserDto(user);

			return setUserToUserDto;
		}
		return null;
	}

	@Override
	public List<UserDto> getAllUser() {
		// TODO Auto-generated method stub

		return userdao.getAllUser();
	}

	public User setUserDtoToUser(UserDto userDto) {

		User user = new User();

		ModelMapper users = new ModelMapper();
		User map = users.map(userDto, user.getClass());
		System.out.println("setUserDtoToUser :  " + map);

		return map;

	}

	public UserDto setUserToUserDto(User user) {

		UserDto userdto = new UserDto();

		UserDto map2 = new ModelMapper().map(user, userdto.getClass());
		System.out.println("setUserToUserDto :  " + map2);
		return map2;

	}

}
