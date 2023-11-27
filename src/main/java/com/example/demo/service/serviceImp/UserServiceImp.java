package com.example.demo.service.serviceImp;

import org.apache.log4j.Logger;
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
	UserDao userdao;

	@Override
	public UserDto saveUser(UserDto userDto) {

		logger.info("request object  :   " + userDto);

		logger.info("start saveUser method");
		User user = this.setUserDtoToUser(userDto);
		try {
			User save = userdao.createUser(user);
			UserDto userDt = this.setUserToUserDto(user);
			logger.info("end saveUser method response object : " + userDt);

			return userDt;

		} catch (Exception e) {
			e.printStackTrace();
			logger.error("saveUser", new Exception());
			return null;

		}

	}

	public User setUserDtoToUser(UserDto userDto) {

		User user = new User();
		user.setGmailId(userDto.getGmailId());
		user.setUname(userDto.getUname());
		user.setPassword(userDto.getPassword());
		user.setUid(userDto.getUid());
		user.setuAddress(userDto.getuAddress());

		return user;

	}

	public UserDto setUserToUserDto(User user) {

		UserDto userdto = new UserDto();
		userdto.setGmailId(user.getGmailId());
		userdto.setUname(user.getUname());
		userdto.setPassword(user.getPassword());
		userdto.setUid(user.getUid());
		userdto.setuAddress(user.getuAddress());
		return userdto;

	}

}
