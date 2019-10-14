package com.spdb.controller;

import java.io.IOException;
import java.util.Map;

import com.spdb.entity.User;
import com.spdb.service.UserService;
import com.spdb.stringresolver.ViewResolver;

public class UserController {
	private UserService userService;
	private ViewResolver viewresolver = new ViewResolver();

	public void login(String userName, String passWord)  throws IOException {

		User user = userService.login(userName, passWord);
		if (user == null) {// check if the user exist
			ViewResolver.solveView(); //
		} else if (!user.getPassword().equals(passWord)) { // check if the password match
			ViewResolver.solveView();
		} else {
			ViewResolver.solveView();
		}
	}

	public void register(String userName, String passWord) throws IOException {
		User user = userService.login(userName, passWord);
		
	}

	public void transfer(String userName, Double amount) {
		userService.transfer(user, transmoney);
	}

}
