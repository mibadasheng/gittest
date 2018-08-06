package com.etc.servlet;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.etc.service.UserService;
import com.etc.vo.User;

public class LoginServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 doPost(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		System.out.println("用户名:"+username);
		System.out.println("密码:"+password);
		
		//创建UserService的实例
		UserService userservice=new UserService();
		if(userservice.isValidUser(request.getParameter("username"), request.getParameter("password"))) {
			System.out.println("333");
			//登录成功后，将用户名信息存入会话
			//登录成功后，将用户名信息存入会话
			HttpSession session = request.getSession();
			User user = new User();
			user.setUsername(request.getParameter("username"));
			user.setPassword(request.getParameter("password"));
			session.setAttribute("username", username);
			session.setAttribute("user", user);
			request.getRequestDispatcher("FIVE.do").forward(request, response);
		}else {
			response.sendRedirect("login.jsp");  //重定向
			
		}
	}
	
}
