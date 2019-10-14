package com.spdb.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import com.spdb.entity.User;
import com.spdb.service.UserService;
import com.spdb.stringresolver.ViewResolver;

public class UserController {
	private UserService userService;
	private ViewResolver viewresolver = new ViewResolver();
	private Map session = new HashMap<String, Object>();

	public void login(String userName, String passWord) throws IOException {
		User user = userService.login(userName, passWord);
		if (user == null) {// check if the user exist
			ViewResolver.solveView(); //
		} else if (!user.getPassword().equals(passWord)) { // check if the password match
			ViewResolver.solveView();
		} else { // successfully login
			ViewResolver.solveView();
			session.remove("user");
			session.put("user", user);
		}
	}

	public void register(String userName, String passWord) throws IOException {
		Boolean bool = userService.register(userName, passWord);
		if (bool == false) {
			ViewResolver.solveView(); // the user already exist
		} else if (bool == true) {
			ViewResolver.solveView(); // register successfully
		}

	}

	public void deposite(int amount) {
		User user = (User) session.get("user");
		if (user == null) {
			ViewResolver.solveView(); // please login first
		}else {
			if(userService.deposit(user, amount)) {
				ViewResolver.solveView(); //deposit successfully
			}
		}
	}
	
	public void pay(int amount) {
		User user = (User) session.get("user");
		if (user == null) {
			ViewResolver.solveView(); // please login first
		}else {
			if(userService.pay(user, amount)) {
				ViewResolver.solveView(); //deposit successfully
			}else {
				ViewResolver.solveView(); //credit is not sufficient, please charge
			}
		}
	}

}
