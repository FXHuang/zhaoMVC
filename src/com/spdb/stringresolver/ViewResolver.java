package com.spdb.stringresolver;

public class ViewResolver {
	public static String NoLogin = "请先登录";
	public static String LoginSuccess = "登录成功，欢迎您";
	public static String NoRegister = "抱歉该未注册";
	public static String ErrorRegister = "该用户已注册";
	public static String RegisterSuccess = "注册成功，欢迎您的加入";
	public static String DepositSuccess = "您已成功充值200元";
	public static String PaySuccess = "您已成功付款200元";
	public static String ErrorPassword = "用户名或密码错误";

	public static void solveView(String msg) {
		switch (msg){
			case "noLogin":
				System.out.println(NoLogin);
				break;
			case "loginSuccess":
				System.out.println(LoginSuccess);
				break;
			case "noRegister":
				System.out.println(NoRegister);
				break;
			case "errorRegister":
				System.out.println(ErrorRegister);
				break;
			case "registerSuccess":
				System.out.println(RegisterSuccess);
				break;
			case "depositSuccess":
				System.out.println(DepositSuccess);
				break;
			case "paySuccess":
				System.out.println(PaySuccess);
				break;
			case "errorPassword":
				System.out.println(ErrorPassword);
				break;

		}
	}


}
