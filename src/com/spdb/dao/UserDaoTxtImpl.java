package com.spdb.dao;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import java.util.ArrayList;

import java.util.List;


import com.spdb.entity.User;
import com.spdb.service.UserService;

//Dao实现类
public class UserDaoTxtImpl implements UserDao {

	private String userFilePath = "d:/user.txt";

	@Override
	public List<User> findAllUsers() throws IOException {
		List<User> users = new ArrayList<User>();
		File file = new File(userFilePath);
		BufferedReader br = null;
		String str = null;
		try {
			 br = new BufferedReader(new FileReader(file));
			while ((str = br.readLine()) != null) {
			
				String[] temp = str.split(" "); //是否有异常
				User user = new User(temp[0],temp[1],Double.parseDouble(temp[2]));
				users.add(user);	
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} finally {
			br.close();
		}
		return users;
	}

	@Override
	public User findUser(List<User> users, String username) throws IOException {
		// Due DB is not in use, so we get all users first then try to match the user in the list 
		for(User user: users) {
			if(user.getName().equals(username)) {
				return user;
			}
		}
		return null;
	}

	@Override
	public void addUser(User user) throws IOException { // write user into the file
		File file = new File(userFilePath);
		if (!file.getParentFile().exists()) {
			file.getParentFile().mkdirs();
		}
		try {
			FileWriter fileWriter = new FileWriter(file, true);
			fileWriter.append(UserService.toRecordString(user));
			fileWriter.append('\n');
			fileWriter.flush();
			fileWriter.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
