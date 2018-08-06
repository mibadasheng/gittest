package com.etc.service;

import java.sql.SQLException;

import com.etc.dao.UserDao;
import com.etc.vo.User;

public class UserService {
	UserDao userDao = new UserDao();
	public boolean isValidUser(String name, String password) {
		
		User user = userDao.selectByNameAndPwd(name, password);
		
		if(user==null) {
			return false;
		}
		return true;
	}

	/*
	 * 注册
	 */
	public int register(User user) {
		// insert数据
		return userDao.insert(user);
	}
	public boolean UserExist(String username) {
		// 取得数据
		User user = userDao.selectByName(username);
		// 判断用户信息是否正确
		if (user == null) {
			return false;
		}
		return true;
	}
	
}

