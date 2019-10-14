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


	public void register(Map userMap) {
		//Check if already exist first
		User user = (User) userMap.get("userName");
		
		//User newUser = userDao.findUser(user);
		//construct the user entity
		
	}

	public User login(String userName, String passWord) throws IOException {
		List<User> userList = userDao.findAllUsers();
		//Generate user class through beanFactory
		User user = userDao.findUser(userList, userName);
		return user;
//		if(user.getPassword().equals(passWord)) {
//			return user;
//		}
//		return null;
		
	}

	public void addMoney(User user , int addmoney) {
		user.setMoney(user.getMoney() + addmoney);
	}

	public void transfer(User user, int transmoney) {

		if (!(user.getMoney() < transmoney)) {
			user.setMoney(user.getMoney() - transmoney);
		} else {
			System.out.println("转账失败，余额不足");
		}
	}

}
