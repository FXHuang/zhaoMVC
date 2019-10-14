package com.spdb.utill;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.spdb.controller.*;
import com.spdb.entity.User;
import com.spdb.stringresolver.ViewResolver;

// 请求进来之后先由这个类拦截，然后到不同的控制类
public class CatchHelper {

	private UserController userController = new UserController();

	public CatchHelper() {

	}
	
	

	public static void main(String[] args) {
		CatchHelper ss = new CatchHelper();
		
	}
	
	public void pathDispatcher(Map<String,String> map) {
		String action = map.get("ActionName");
		switch (action) {
			case "login.do":
				String userName = map.get("username");
				String passWord = map.get("passWord");
				userController.login(userName,passWord);
				break;
			case "register.do":
				 userName = map.get("username");
				 passWord = map.get("passWord");
				
				 userController.register(user);
				break;
			case "deposite.do":
				ViewResolver.solveView("depositSuccess");
				break;
			case "pay.do":
				ViewResolver.solveView("paySuccess");
				break;
			default: System.out.println("your command does not exist");
		}
		
	}

	public Map<String, String> parsePath(String str) {
		Map<String, String> map = new HashMap<>();
		String[] newStr = str.split("\\?");
		String actionName = newStr[0];
		map.put("ActionName", actionName);  //login,register,deposit,pay 
		String rightHalf = newStr[1];
		if (rightHalf.indexOf("&") > -1) { //正常情况下返回&的索引位置
			String userName = rightHalf.substring(rightHalf.indexOf("=") + 1, rightHalf.indexOf("&"));
			String password = rightHalf.substring(rightHalf.lastIndexOf("=") + 1);
			map.put("userName", userName);
			map.put("passWord", password);
		} else {    //没有&的情况，即转账或充值
			String money = rightHalf.substring(rightHalf.indexOf("=") + 1);
			map.put("money", money);
		}
		return map;
	}

}
