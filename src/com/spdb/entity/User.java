package com.spdb.entity;

// 实体类，姓名，密码，余额   密码这么设置感觉有问题，没想到更好的办法
public class User{
    private String name;
    private String password;
    private Double money;
    
    public User(String name, String password, Double money) {
        this.name = name;
        this.password = password;
        this.money = money;
     }

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Double getMoney() {
		return money;
	}

	public void setMoney(Double money) {
		this.money = money;
	}

   
}
