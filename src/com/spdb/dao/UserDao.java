package com.spdb.dao;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import com.spdb.entity.User;

//Dao层原本是连接数据库用的，现在定为处理文件
public interface UserDao {	
	public abstract List<User> findAllUsers() throws IOException;
	public abstract void addUser(User user) throws IOException;
	public abstract User findUser(List<User> user,String username) throws IOException;
}
