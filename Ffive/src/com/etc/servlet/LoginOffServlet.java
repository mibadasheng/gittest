package com.etc.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginOffServlet extends HttpServlet {

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 doPost(req, resp);
	}

	
	public void doPost(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		HttpSession session=req.getSession();
		//ʧЧ�ķ�����ͬ��
		//session.setMaxInactiveInterval(0);
		session.invalidate();
		req.setAttribute("msg", "�Ѿ��ǳ��������µ�¼��");
		req.getRequestDispatcher("login.jsp").forward(req, resp);
		
		}

}
