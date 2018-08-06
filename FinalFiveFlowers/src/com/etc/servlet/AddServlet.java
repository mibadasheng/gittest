package com.etc.servlet;



import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.etc.dao.CartDao;
import com.etc.dao.GoodsDAO;
import com.etc.service.CartService;
import com.etc.util.ConnectionFactory;
import com.etc.vo.Cart;
import com.etc.vo.Goods;

//@WebServlet("/BuyServlet")

	public class AddServlet extends HttpServlet {
		 protected void doGet(HttpServletRequest request, 
			      HttpServletResponse response) throws ServletException, IOException { 
				  doPost(request,response);
				 
			  } 

	    protected void doPost(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {
	    	System.out.println("555");
			response.setCharacterEncoding("UTF-8");
			request.setCharacterEncoding("UTF-8");
			PreparedStatement ptmt = null;
			ResultSet rs = null;
			Connection conn = ConnectionFactory.getConn();
	    	CartDao cart = new CartDao();
			CartService cartService=new CartService();
	    	String userName = request.getParameter("username");
			String goodid  = request.getParameter("goodid");
			System.out.println(goodid);
		
			int userId = cart.selectByUserName(userName);
			String sql = "select num from shoppingcart where goodsid=? and userid=?";
				try {
			    ptmt = conn.prepareStatement(sql);	
			    ptmt.setString(1, goodid);
			    ptmt.setInt(2, userId);
				rs = ptmt.executeQuery();
			 if(rs.next()) {
				 int num = rs.getInt(1);
				 cart.update(goodid,userId,num+1);
					
			 }else {
				 cart.add(goodid,userId,1);
			}
			 } catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
	        request.getRequestDispatcher("FIVE.do").forward(request, response);
	    }
	}
	


