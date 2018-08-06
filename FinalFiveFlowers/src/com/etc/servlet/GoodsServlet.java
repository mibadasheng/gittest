package com.etc.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.etc.service.GoodsService;
import com.etc.vo.Goods;


public class GoodsServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 doPost(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		//创建UserService的实例
		GoodsService userservice=new GoodsService();
		ArrayList<Goods> list = userservice.getGoodsList();
		if(list!=null) {
			request.setAttribute("list", list);
			request.getRequestDispatcher("FIVE.jsp").forward(request, response);
		}else {
			response.sendRedirect("firstpage.jsp");  //重定向
		}
	}

	
}
