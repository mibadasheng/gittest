package com.etc.service;

import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.etc.dao.UserDao;
import com.etc.vo.User;

public class UserService {
	UserDao userDao = new UserDao();
	private static Logger log = Logger.getLogger(UserService.class);

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
		// insert
		int result = userDao.insert(user);
		System.out.println("result:"+result);
		if(result>0) {
			//�����־
			log.error("error log:�û�ע��ɹ���");
			log.warn("warn log:�û�ע��ɹ���");
			log.info("info log:�û�ע��ɹ���");
			log.debug("debug log:�û�ע��ɹ���");
		}
		return result;
	}
	
	public boolean UserExist(String username) {
		
		
		User user = userDao.selectByName(username);
		
		if (user == null) {
			return false;
		}
		return true;
	}
	
}

