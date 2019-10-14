package com.spdb.dao;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import com.spdb.entity.User;
import com.spdb.service.UserService;

// Dao实现类
public class UserDaoTxtImpl implements UserDao {

	private String userFilePath = "d:/user.txt";

	@Override
	public Map findAllUsers() throws IOException {
		Map<String, User> userInfoMap = new HashMap<>();
		Scanner scanner = new Scanner(new File(userFilePath));
		while (scanner.hasNextLine()) {
			String userRecord = scanner.nextLine();
			String[] temp = userRecord.split(" "); //是否有异常
		
			
			User user = new User(temp[0],temp[1],Double.parseDouble(temp[2]));
			userInfoMap.put(temp[0],user);		
			if (userRecord.equals("")) {
				continue;
			}
		}
		return userInfoMap;
	}
	@Override
	public User findUser(User user) throws IOException{    
		//Due DB is not in use, so we get all users first then try to match the key in the map. 
		Map<String, String> userInfoMap = new HashMap<>();
		userInfoMap = findAllUsers();
		if(userInfoMap.get(user.getName()) != null) {
			return user;
		}
		System.out.println("this user does not exist please register first");
		return null;
	}

	@Override
	public void addUser(User user) throws IOException { //write user into the file
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
