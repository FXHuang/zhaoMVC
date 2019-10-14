package com.spdb.stringresolver;

public class ViewResolver {

	public static void solveView() {
		
	}

//	public static String NoLogin = "请先登录";
//	public static String LoginSuccess = "登录成功，欢迎您";
//	public static String NoRegister = "抱歉%s未注册";
//	public static String ErrorRegister = "用户已注册";
//	public static String RegisterSuccess = "注册成功，欢迎您的加入";
//	public static String DepositSuccess = "您已成功充值200元";
//	public static String PaySuccess = "您已成功付款200元";
//	public static String ErrorPassword = "用户名或密码错误";

	public static void solveView(String msg,String value) {
		switch (msg){
			case "noLogin":
				System.out.println("请先登录");
				break;
			case "loginSuccess":
				System.out.println("登录成功，欢迎您");
				break;
			case "noRegister":
				System.out.println("抱歉"+value+"未注册");
				break;
			case "errorRegister":
				System.out.println("用户"+value+"已注册");
				break;
			case "registerSuccess":
				System.out.println("注册成功，欢迎您的加入");
				break;
			case "depositSuccess":
				System.out.println("您已成功充值"+value+"元");
				break;
			case "paySuccess":
				System.out.println("您已成功付款"+value+"元");
				break;
			case "errorPassword":
				System.out.println("用户名或密码错误");
				break;
			case "noEnoughMoney":
				System.out.println("余额不足，请换卡!");
				break;

		}
	}

}
