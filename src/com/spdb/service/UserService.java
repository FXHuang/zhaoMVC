package com.spdb.service;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.spdb.dao.UserDao;
import com.spdb.entity.User;

// 处理请求
public class UserService {
	private UserDao userDao;
	private boolean isLogin = false;
	private Map<String, Object> result = new HashMap<>();

	public static String toRecordString(User user) {
		return String.format("%s %s", user.getName(), user.getPassword());
	}
	// should check logic be placed here or controller? if controller, how?
	public boolean register(String userName, String passWord) throws IOException {
		List<User> userList = userDao.findAllUsers();
		User user = userDao.findUser(userList, userName);
		if (user.getName().equals(userName)) {
			return false; //already exists
		}else {
			User newUser = new User(userName,passWord,0);
			userDao.addUser(newUser);
			return true;
		}
	}

	public User login(String userName, String passWord) throws IOException {
		List<User> userList = userDao.findAllUsers();
		// should be replaced by Generating the user class through beanFactory ?
		User user = userDao.findUser(userList, userName);
		return user;

	}

	public boolean deposit(User user, int addmoney) {
		return false;
	}

	public boolean pay(User user, int transmoney) {

		return true;
	}

}
