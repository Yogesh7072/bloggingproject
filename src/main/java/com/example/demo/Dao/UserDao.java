package com.example.demo.Dao;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demo.model.User;
import com.example.demo.repositry.UserRepositry;

@Repository
public class UserDao {

	Logger logger = Logger.getLogger(UserDao.class);

	@Autowired
	UserRepositry userRepo;

	public User createUser(User user) {
		// TODO Auto-generated method stub

		try {
			User save = userRepo.save(user);

			return save;

		} catch (Exception e) {
			e.printStackTrace();
			logger.error("user not is save check exception", new Exception(e));
			return null;
		}
	}

}
