package com.example.demo.serviceImp;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.stubbing.OngoingStubbing;
import org.modelmapper.ModelMapper;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.Dao.UserDao;
import com.example.demo.dto.UserDto;
import com.example.demo.model.User;
import com.example.demo.service.serviceImp.UserServiceImp;

@SpringBootTest(classes = { UserServiceImpTest.class })
public class UserServiceImpTest {
//	@Mock
//	private UserDao userdao;
//
////	@InjectMocks
////	private UserServiceImp userServiceImp;
//
//
//	public void saveUserTest() {
//		User save = new User(1, "yogesh", "abc", "xyz", "mnc");
//		UserDto userDto = new UserDto(1, "yogesh", "abc", "xyz", "mnc");
//		UserServiceImp userServiceImp = new UserServiceImp();
//
//		OngoingStubbing<User> thenReturn = when(userServiceImp.setUserDtoToUser(userDto)).thenReturn(save);
//		User mock2 = thenReturn.getMock();
//		String gmailId = mock2.getGmailId();
//		System.out.println(gmailId);
////		when(userdao.createUser(save)).thenReturn(save);
////		when(userServiceImp.setUserToUserDto(save)).thenReturn(userDto);
////		UserDto result = userServiceImp.saveUser(userDto);
////		System.out.println(userDto);
////		System.out.println(result);
//
//	}
}
