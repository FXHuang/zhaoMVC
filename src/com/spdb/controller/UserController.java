package com.spdb.controller;

import java.util.Map;

import com.spdb.service.UserService;

public class UserController {
	public UserService userService;
	
	public void pathDispatcher() {
		
	}
	
	public Map login(String userName, String passWord) {
		return  userService.login(userName,passWord);
	}
	
	public void register() {
		userService.register();
	}
	
	public void transfer() {
		userService.transfer(user, transmoney);
	}
	
}
